/**
 * @author mfmansfi
 * 
 * @date 10/7/2013
 * 
 * listens for changes in the list data
 */

package com.cs3141.gui;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

import com.cs3141.calender.Event;
import com.cs3141.calender.EventManager;

public class ListDataListen implements ListDataListener {
	
	JList<Event> list;
	EventManager manager;
	DefaultListModel<Event> model;
	/**
	 * listens to changes in the list data. takes in a list, event manager, and model.
	 * @param l
	 * @param m
	 * @param mod
	 */
	public ListDataListen(JList<Event> l, EventManager m, DefaultListModel<Event> mod){
		list = l;
		manager = m;
	}

	@Override
	public void contentsChanged(ListDataEvent e) {
		/*
		 * removes and replaces all items in the list.
		 */
		list.removeAll();
		for(Event ev: manager.getAllEvents()){
			model.addElement(ev);
		}
	}

	@Override
	public void intervalAdded(ListDataEvent e) {
		list.removeAll();
		for(Event ev: manager.getAllEvents()){
			model.addElement(ev);
		}
	}

	@Override
	public void intervalRemoved(ListDataEvent e) {
		list.removeAll();
		for(Event ev: manager.getAllEvents()){
			model.addElement(ev);
		}
	}

}
