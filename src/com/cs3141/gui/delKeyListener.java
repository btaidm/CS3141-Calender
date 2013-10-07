package com.cs3141.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.cs3141.calender.EventManager;

public class delKeyListener implements KeyListener{

	private EventManager manager;
	private CalenderGui gui;
	
	public delKeyListener(EventManager ma, CalenderGui gu){
		
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getKeyChar() == 46){
			//Event event = 
			//manager.removeEvent(event);
			gui.remake();
		}
	}
}