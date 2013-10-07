package com.cs3141.calender;


import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class EventManager
{

	private HashMap<Integer, Event> events;
	private Calendar cal = Calendar.getInstance();


	public EventManager()
	{
		events = new HashMap<Integer, Event>();
	}

	public void clearEventManager()
	{
		events = new HashMap<Integer, Event>();
	}


	public Event removeEvent(Integer key)
	{
		return events.remove(key);
	}

	public Event addEvent(Event event)
	{
		events.put(event.getId(), event);
		return event;
	}

	public Event addEvent(Date date, String name, String place, String description)
	{
		Event event = new Event(date, name, place, description);
		events.put(event.getId(), event);
		return event;
	}


	public Event removeEvent(Event event)
	{
		return events.remove(event.getId());
	}

	public Event getEvent(Integer key)
	{
		return events.get(key);
	}

	public boolean containsEventWithId(Integer id)
	{
		return events.containsKey(id);
	}

	public ArrayList<Event> getRange(Date beginning, Date end) throws IllegalArgumentException
	{
		if (beginning.after(end))
		{
			throw new IllegalArgumentException("Beginning Date is after End Date");
		}
		ArrayList<Event> eventRange = new ArrayList<Event>();
		ArrayList<Event> eventList = new ArrayList<Event>(events.values());
		for (int i = 0; i < eventList.size(); i++)
		{
			Event e = eventList.get(i);
			if(e.m_date.before(end) && e.m_repeat != Repeated.NONE)
			{
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(e.m_date);
				switch (e.m_repeat)
				{
				case DAILY:
					calendar.add(Calendar.DAY_OF_MONTH, 1);
					break;
				case MONTHLY:
					calendar.add(Calendar.MONTH, 1);
					break;
				case WEEKLY:
					calendar.add(Calendar.WEEK_OF_YEAR, 1);
					break;
				case YEARLY:
					calendar.add(Calendar.YEAR, 1);
					break;
				default:
					break;
				}
				Event newEvent = new Event(calendar.getTime(),e.m_name,e.m_place,e.m_discription,e.m_repeat);
				eventList.add(newEvent);
			}

			if ((e.m_date.after(beginning) || e.m_date.equals(beginning)) && (e.m_date.before(end) || e.m_date.equals(end)))
			{
				eventRange.add(e);
			}
		}
		Collections.sort(eventRange);
		return eventRange;
	}

	public void saveToCSV() throws IOException
	{
		String location = System.getProperty("newCalender");
		saveToCSV(location);
	}

	public void saveToCSV(String filename) throws IOException
	{
		if (!filename.endsWith(".cal.csv"))
		{
			filename = filename + ".cal.csv";
		}
		filename = System.getProperty("user.home") + "/" + filename;
		File file = new File(filename);
		FileWriter writer = new FileWriter(file);
		BufferedWriter buffWriter = new BufferedWriter(writer);

		for (Integer key : events.keySet())
		{
			Event nextToWrite = events.get(key);
			buffWriter.write(nextToWrite.m_date + "|" + nextToWrite.m_discription + "|" +
					nextToWrite.m_name + "|" + nextToWrite.m_place + "|" + nextToWrite.m_repeat + "\n");
		}
		buffWriter.close();
	}


	public void readFromCSV() throws IOException
	{
		ArrayList<String> location = new ArrayList<String>();
		location.add(System.getProperty("user.home"));
		readFromCSV(location);
	}

	///TODO we need to make embedded commas not break the IO
	///TODO move away from deprecated date functions
	public void readFromCSV(List<String> locs) throws IOException
	{
		this.clearEventManager();
		for(String location: locs){
			location = System.getProperty("user.home") + "/" + location;
			File file = new File(location);
			FileReader reader = new FileReader(file);
			BufferedReader buffReader = new BufferedReader(reader);

			while (buffReader.ready())
			{
				String nextLine = buffReader.readLine();
				String[] allElements = nextLine.split("\\|");
				if (allElements.length >= 4)
				{
					Event event = new Event(Util.tryParse(allElements[0]), allElements[1], allElements[2], allElements[3]);
					if (!events.containsKey(event.getId()))
					{
						events.put(event.getId(), event);
					}
				}
			}

			buffReader.close();
		}
	}

	public void printAllEvents()
	{
		for (Integer key : events.keySet())
		{
			Event nextToWrite = events.get(key);
			System.out.println(nextToWrite.m_date + "," + nextToWrite.m_discription + "," +
					nextToWrite.m_name + "," + nextToWrite.m_place + "\n");
		}
	}

	public ArrayList<Event> getAllEvents()
	{

		ArrayList<Event> eventRange = new ArrayList<Event>(events.values());
		Collections.sort(eventRange);
		return eventRange;
	}

	public ArrayList<Event> getCurrentMonthEvents() throws IllegalArgumentException
	{
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, Calendar.getInstance().getActualMinimum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR_OF_DAY, Calendar.getInstance().getActualMinimum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, Calendar.getInstance().getActualMinimum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, Calendar.getInstance().getActualMinimum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND, Calendar.getInstance().getActualMinimum(Calendar.MILLISECOND));
		Date startOfMonth = calendar.getTime();
		calendar.set(Calendar.DAY_OF_MONTH, Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR_OF_DAY, Calendar.getInstance().getActualMaximum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, Calendar.getInstance().getActualMaximum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, Calendar.getInstance().getActualMaximum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND, Calendar.getInstance().getActualMaximum(Calendar.MILLISECOND));
		Date endOfMonth = calendar.getTime();
		return getRange(startOfMonth, endOfMonth);
	}

	public ArrayList<Event> getCurrentYearEvents() throws IllegalArgumentException
	{
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, Calendar.JANUARY);
		calendar.set(Calendar.DAY_OF_MONTH, Calendar.getInstance().getActualMinimum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR_OF_DAY, Calendar.getInstance().getActualMinimum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, Calendar.getInstance().getActualMinimum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, Calendar.getInstance().getActualMinimum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND, Calendar.getInstance().getActualMinimum(Calendar.MILLISECOND));
		Date startOfMonth = calendar.getTime();
		calendar.set(Calendar.MONTH, Calendar.DECEMBER);
		calendar.set(Calendar.DAY_OF_MONTH, Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR_OF_DAY, Calendar.getInstance().getActualMaximum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, Calendar.getInstance().getActualMaximum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, Calendar.getInstance().getActualMaximum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND, Calendar.getInstance().getActualMaximum(Calendar.MILLISECOND));
		Date endOfMonth = calendar.getTime();
		return getRange(startOfMonth, endOfMonth);
	}

	public ArrayList<Event> getCurrentWeekEvents() throws IllegalArgumentException
	{
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.getInstance().getActualMinimum(Calendar.DAY_OF_WEEK));
		calendar.set(Calendar.HOUR_OF_DAY, Calendar.getInstance().getActualMinimum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, Calendar.getInstance().getActualMinimum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, Calendar.getInstance().getActualMinimum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND, Calendar.getInstance().getActualMinimum(Calendar.MILLISECOND));
		Date startOfMonth = calendar.getTime();
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_WEEK));
		calendar.set(Calendar.HOUR_OF_DAY, Calendar.getInstance().getActualMaximum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, Calendar.getInstance().getActualMaximum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, Calendar.getInstance().getActualMaximum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND, Calendar.getInstance().getActualMaximum(Calendar.MILLISECOND));
		Date endOfMonth = calendar.getTime();
		return getRange(startOfMonth, endOfMonth);
	}

	public ArrayList<Event> getCurrentAgenda() throws IllegalArgumentException
	{
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, Calendar.getInstance().getActualMinimum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, Calendar.getInstance().getActualMinimum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, Calendar.getInstance().getActualMinimum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND, Calendar.getInstance().getActualMinimum(Calendar.MILLISECOND));
		Date startOfMonth = calendar.getTime();
		calendar.set(Calendar.HOUR_OF_DAY, Calendar.getInstance().getActualMaximum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, Calendar.getInstance().getActualMaximum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, Calendar.getInstance().getActualMaximum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND, Calendar.getInstance().getActualMaximum(Calendar.MILLISECOND));
		Date endOfMonth = calendar.getTime();
		return getRange(startOfMonth, endOfMonth);
	}
}
