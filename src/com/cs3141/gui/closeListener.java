package com.cs3141.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class closeListener implements ActionListener{

	JFrame frame;
	
	public closeListener(JFrame frame){
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		frame.dispose();
		
	}

}
