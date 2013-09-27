package com.cs3141.calender;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;


public class EventManager {

	private HashMap<Integer, Event> events;

	public EventManager() {
		events = new HashMap<Integer, Event>();
	}

	public Event addEvent(Event event) {
		events.put(event.hashCode(), event);
		event.id = event.hashCode();
		return event;
	}

	public Event removeEvent(Integer key) {
		return events.remove(key);
	}

	public Event removeEvent(Event event) {
		return events.get(event.id);
	}

	public Event getEvent(Integer key) {
		return events.get(key);

	}

	public ArrayList<Event> getRange(Date beginning, Date end) throws Exception {
		if (beginning.after(end)) {
			throw new Exception("Beginning Date is after End Date");
		}
		ArrayList<Event> eventRange = new ArrayList<Event>();
		for (Event e : events.values()) {
			if ((e.m_date.after(beginning) || e.m_date.equals(beginning)) && (e.m_date.before(end) || e.m_date.equals(end))) {
				eventRange.add(e);
			}
		}
		Collections.sort(eventRange);
		return eventRange;
	}
}
