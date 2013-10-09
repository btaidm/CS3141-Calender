/**
 * @author mfmansfi
 * 
 * @date 10/7/2013
 * 
 * listener for the OK button on the add event GUI
 */

package com.cs3141.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JDialog;

import com.cs3141.calender.*;
import com.cs3141.util.Util;

public class addEventListener implements ActionListener {

	NewEventObject newEventObj;
	JDialog dialog;
	EventManager manager;
	CalenderGui gui;
	/**
	 * 
	 * @param newEventObj the event object that is passed in. 
	 * @param dialog the dialog that will popup
	 * @param g the main gui
	 */
	public addEventListener(NewEventObject newEventObj, JDialog dialog, CalenderGui g){
		this.newEventObj = newEventObj;
		this.dialog = dialog;
		this.manager = CalenderGui.getEventManager();
		gui = g;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(!anyTextNull()){
			Date date = Util.tryParse(newEventObj.eventDate.getText());
			Event event;
			
				event = new Event(date, newEventObj.eventName.getText(), newEventObj.eventDisc.getText(), newEventObj.eventLoc.getText(), getRepeated());
			
			manager.addEvent(event);
			
			gui.remake();

			dialog.dispose();
		}
	}
	/**
	 * returns true if any of the text box's in dialog are empty
	 * @return boolean 
	 */
	private boolean anyTextNull(){
		if(newEventObj.eventDate.getText() == null){
			return true;
		}
		if(newEventObj.eventDisc.getText() == null){
			return true;
		}
		if(newEventObj.eventLoc.getText() == null){
			return true;
		}
		if(newEventObj.eventName.getText() == null){
			return true;
		}
		if(newEventObj.checkbox.isSelected()){
			if(ARadioIsSelected()){
				if(newEventObj.numTimesRepeated.getText() == null){
					return true;
				}
			}
			else{
				return true;
			}
		}

		return false;
	}
	
	
	/**
	 * returns true if any of the radio buttons for repeating are selected
	 * @return boolean
	 */
	private boolean ARadioIsSelected(){
		return (newEventObj.daily.isSelected() || newEventObj.weekly.isSelected() || newEventObj.monthly.isSelected() || newEventObj.yearly.isSelected());
		
		
	}
	/**
	 * returns weather or not the event will be repeated.
	 * @return boolean
	 */
	private Repeated getRepeated(){
		if(newEventObj.daily.isSelected()){
			return Repeated.DAILY;
		}
		if(newEventObj.weekly.isSelected()){
			return Repeated.WEEKLY;
		}
		if(newEventObj.monthly.isSelected()){
			return Repeated.MONTHLY;
		}
		if(newEventObj.yearly.isSelected()){
			return Repeated.YEARLY;
		}
		return Repeated.NONE;
	}

}
