package com.cs3141.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwitchViewListener implements ActionListener{
	
	private CalenderGui gui;
	private int val;
	
	public SwitchViewListener(CalenderGui gui, int val){
		this.gui = gui;
		this.val = val;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		gui.remake();
	}

}
