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
	
	public ListDataListen(JList<Event> l, EventManager m, DefaultListModel<Event> mod){
		list = l;
		manager = m;
	}

	@Override
	public void contentsChanged(ListDataEvent e) {
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
