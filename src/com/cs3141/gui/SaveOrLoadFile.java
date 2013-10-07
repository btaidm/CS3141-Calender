package com.cs3141.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JList;
import javax.swing.JTextField;

import com.cs3141.calender.EventManager;


public class SaveOrLoadFile implements ActionListener {

	private EventManager manager;
	private boolean saveOrLoad;
	private JTextField textField;
	private JList<String> list;
	private SaveDialog dialog;
	private CalenderGui gui;

	public SaveOrLoadFile(boolean saveOrLoad, EventManager manager, JTextField textField, JList<String> list, SaveDialog dialog, CalenderGui g){
		this.manager = manager;
		this.saveOrLoad = saveOrLoad;
		this.textField = textField;
		this.dialog = dialog;
		this.list = list;
		gui = g;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(saveOrLoad){
			if(textField.getText() != null){
				save();
				dialog.dispose();
			}
		}
		else{
			if(list.getSelectedValue() != null){
				load();
				dialog.dispose();
			}
		}

	}

	private void save(){
		try {
			manager.saveToCSV(textField.getText());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void load(){
		try {
			manager.readFromCSV(list.getSelectedValuesList());
			gui.remake();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
