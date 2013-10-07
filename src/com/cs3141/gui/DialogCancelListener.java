package com.cs3141.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;


public class DialogCancelListener implements ActionListener{

	private JDialog dialog;
		
	public DialogCancelListener(JDialog d){
		dialog = d;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		dialog.dispose();
	}

}
