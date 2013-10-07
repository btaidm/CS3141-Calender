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
	private SaveDialog dialog;

	public SaveOrLoadFile(boolean saveOrLoad, EventManager manager, JTextField textField, SaveDialog dialog){
		this.manager = manager;
		this.saveOrLoad = saveOrLoad;
		this.textField = textField;
		this.dialog = dialog;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(textField.getText() != null){
			if(saveOrLoad){
				save();
			}
			else{
				load();
			}
			dialog.dispose();
		}

	}

	private void save(){

		System.out.println("save " + textField.getText());

	}

	private void load(){
		System.out.println("load " + textField.getText());
	}

}
