package com.cs3141.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JList;

import com.cs3141.calender.EventManager;


public class SaveOrLoadFile implements ActionListener {

	private EventManager manager;
	private boolean saveOrLoad;
	private JList list;
	private SaveDialog dialog;

	public SaveOrLoadFile(boolean saveOrLoad, EventManager manager, JList<String> list, SaveDialog dialog){
		this.manager = manager;
		this.saveOrLoad = saveOrLoad;
		this.list = list;
		this.dialog = dialog;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(list.getSelectedValue() != null){
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

		System.out.println("save " + list.getSelectedValue());

	}

	private void load(){
		System.out.println("load " + list.getSelectedValue());
	}

}
