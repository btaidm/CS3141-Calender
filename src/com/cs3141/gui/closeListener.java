/**
 * @author mfmansfi
 * 
 * @date 10/7/2013
 * 
 * listener for closing JFrames. used on CalenderGui exit button
 */

package com.cs3141.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class closeListener implements ActionListener{

	JFrame frame;
	/**
	 * takes in the frame that would be closed
	 * @param frame
	 */
	public closeListener(JFrame frame){
		this.frame = frame;
	}

	/**
	 * if any action is performed on something with this listener, then the frame passed in is disposed of.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		frame.dispose();
		
	}

}
