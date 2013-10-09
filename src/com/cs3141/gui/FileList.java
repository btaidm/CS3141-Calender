/**
 * @author mfmansfi
 * 
 * @date 10/7/2013
 * 
 * listens for changes in the FileList
 */

package com.cs3141.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class FileList implements ListSelectionListener {

	private JTextField field;
	private JList<String> list;
	
	/**
	 * takes in a field that will be filled with the selected filename, and a list that will have the filename pulled out of.
	 * @param field
	 * @param list
	 */

	public FileList(JTextField field, JList<String> list) {
		super();
		this.field = field;
		this.list = list;
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		if(field != null){
			if(!field.getText().equals(list.getSelectedValue())){
				field.setText(list.getSelectedValue());
			}
		}
	}

}
