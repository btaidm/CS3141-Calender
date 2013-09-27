package com.cs3141.calender;

import java.util.Date;


public class EventManagerTest
{

	public static void main(String args[]){
		EventManager manager = new EventManager();
		Event e = new Event(new Date(), "TEST", "HERE", "THIS IS A TEST");
		manager.addEvent(e);
		if(!manager.getEvent(e.hashCode()).equals(e)){
			System.out.println("ERROR in get");
		}
		if(!manager.removeEvent(e).equals(e)){
			System.out.println("ERROR in remove");
		}
		manager.addEvent(e);
		if(!manager.removeEvent(e.hashCode()).equals(e)){
			System.out.println("ERROR in remove with key");
		}
	}

}
