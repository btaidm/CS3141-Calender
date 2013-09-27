package com.cs3141.calender;

import java.io.IOException;
import java.util.Date;


public class EventManagerTest
{

	public static void main(String args[]){
		EventManager manager = new EventManager();
		Event e = new Event(new Date(), "TEST", "HERE", "THIS IS A TEST");
		manager.addEvent(e);
		if(!manager.getEvent(e.id).equals(e)){
			System.out.println("ERROR in get");
		}
		if(!manager.removeEvent(e).equals(e)){
			System.out.println("ERROR in remove");
		}
		manager.addEvent(e);
		if(!manager.removeEvent(e.id).equals(e)){
			System.out.println("ERROR in remove with key");
		}
		if(manager.containsEventWithId(e.id)){
			System.out.println("ERROR in remove with key: didn't remove");
		}
		
		
		for(int i = 0; i < 5; i++){
			manager.addEvent(new Event(new Date(), "test" + i, "here" + i, "this is a test" + i));
		}
		try{
			manager.saveToCSV();
		}
		catch(IOException exc){
			System.out.println("Error in saving to csv");
		}
		
		manager.clearEventManager();
		
		try{
			manager.readFromCSV();
		}
		catch(IOException exc){
			System.out.println("error reading from csv");
		}
		manager.printAllEvents();
	}

}
