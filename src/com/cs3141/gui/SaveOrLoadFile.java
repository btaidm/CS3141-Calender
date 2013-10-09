/**
 * @author mfmansfi
 * 
 * @date 10/7/2013
 * 
 * Listener for saving or loading data
 */

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

	/**
	 * 
	 * @param saveOrLoad if true, saves program
	 * @param manager the event manager tied to the stuff
	 * @param textField the text field that file names come from. for saving
	 * @param list the list load files come from
	 * @param dialog the dialog 
	 * @param g
	 */
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
	/**
	 * saves the current event manager to the file specified in textField
	 */
	private void save(){
		try {
			manager.saveToCSV(textField.getText());
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}
	/**
	 * loads the selected event manager.
	 */
	private void load(){
		try {
			manager.readFromCSV(list.getSelectedValuesList());
			gui.remake();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
