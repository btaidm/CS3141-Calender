package com.cs3141.calender;

import java.util.HashMap;


public class EventManager
{

	private HashMap<Integer, Event> events;
	
	public EventManager(){
		events = new HashMap<Integer, Event>();
	}

	public Event addEvent(Event event){
		events.put(event.hashCode(), event);
		event.id = event.hashCode();
		return event;
	}
	
	public Event removeEvent(Integer key){
		return events.remove(key);
	}
	
	public Event removeEvent(Event event){
		return events.get(event.id);
	}

	public Event getEvent(Integer key){
		return events.get(key);

	}
}
