package com.cs3141.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JDialog;

import com.cs3141.calender.*;

public class addEventListener implements ActionListener {

	NewEventObject newEventObj;
	JDialog dialog;
	EventManager manager;

	public addEventListener(NewEventObject newEventObj, JDialog dialog){
		this.newEventObj = newEventObj;
		this.dialog = dialog;
		this.manager = CalenderGui.getEventManager();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(!anyTextNull()){
			Date date = Util.tryParse(newEventObj.eventDate.getText());
			Event event;
			
				event = new Event(date, newEventObj.eventName.getText(), newEventObj.eventDisc.getText(), newEventObj.eventLoc.getText(), getRepeated());
			
			manager.addEvent(event);

			dialog.dispose();
		}
	}

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

	private boolean ARadioIsSelected(){
		return (newEventObj.daily.isSelected() || newEventObj.weekly.isSelected() || newEventObj.monthly.isSelected() || newEventObj.yearly.isSelected());
		
		
	}
	
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
