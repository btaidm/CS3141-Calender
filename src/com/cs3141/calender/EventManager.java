package com.cs3141.calender;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;


public class EventManager
{

	private HashMap<Integer, Event> events;

	public EventManager(){
		events = new HashMap<Integer, Event>();
	}
	
	public void clearEventManager(){
		events = new HashMap<Integer, Event>();
	}

	public Event addEvent(Event event){
		events.put(event.id, event);
		return event;
	}

	public Event addEvent(Date date, String name, String place, String description){
		Event event = new Event(date, name, place, description);
		events.put(event.id, event);
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

	public boolean containsEventWithId(Integer id){
		return events.containsKey(id);
	}

	public void saveToCSV() throws IOException{
		String location = System.getProperty("user.home");
		saveToCSV(location);
	}

	public void saveToCSV(String location) throws IOException{
		if(!location.endsWith(".csv")){
			if(!location.endsWith("/")){
				location = location + "/"; 
			}
			location = location + "calenderData.csv";
		}
		File file = new File(location);
		FileWriter writer = new FileWriter(file);
		BufferedWriter buffWriter = new BufferedWriter(writer);

		for(Integer key: events.keySet()){
			Event nextToWrite = events.get(key);
			buffWriter.write(nextToWrite.m_date + "," + nextToWrite.m_discription + "," +
					nextToWrite.m_name + "," + nextToWrite.m_place + "\n");
		}
		buffWriter.close();
	}

	public void readFromCSV() throws IOException{
		String location = System.getProperty("user.home");
		readFromCSV(location);
	}

	//TODO we need to make embedded commas not break the IO
	public void readFromCSV(String location) throws IOException{
		if(!location.endsWith(".csv")){
			if(!location.endsWith("/")){
				location = location + "/"; 
			}
			location = location + "calenderData.csv";
		}
		File file = new File(location);
		FileReader reader = new FileReader(file);
		BufferedReader buffReader = new BufferedReader(reader);

		while(buffReader.ready()){
			String nextLine = buffReader.readLine();
			String[] allElements = nextLine.split(",");
			if(allElements.length >= 3){
				Event event = new Event(new Date(allElements[0]), allElements[1], allElements[2], allElements[3]);
			}
		}
		buffReader.close();
	}
	
	public void printAllEvents(){
		for(Integer key: events.keySet()){
			Event nextToWrite = events.get(key);
			System.out.println(nextToWrite.m_date + "," + nextToWrite.m_discription + "," +
					nextToWrite.m_name + "," + nextToWrite.m_place + "\n");
		}
	}

}
