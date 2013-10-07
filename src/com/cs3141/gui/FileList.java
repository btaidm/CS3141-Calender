package com.cs3141.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JList;
import javax.swing.JTextField;

public class FileList<X> extends JList<X> implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField field;

	public FileList(JTextField field) {
		super();
		this.field = field;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		field.setText(this.getSelectedValue().toString());
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
