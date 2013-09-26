package com.cs3141.test;



import com.cs3141.calender.Event;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Tim
 * Date: 9/25/13
 * Time: 2:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class EventTest {
	public static void main(String [] args)
	{
		int passCount = 0;
		int failCount = 0;
		System.out.println("Test Event:");
		System.out.print("\tTest Date:");
		if(testEventDate())
		{
			System.out.println("[PASS]");
			passCount++;
		}
		else
		{
			System.out.println("[FAIL]");
			failCount++;
		}
		System.out.print("\tTest Name:");
		if(testEventName())
		{
			System.out.println("[PASS]");
			passCount++;
		}
		else
		{
			System.out.println("[FAIL]");
			failCount++;
		}
		System.out.print("\tTest Place:");
		if(testEventPlace())
		{
			System.out.println("[PASS]");
			passCount++;
		}
		else
		{
			System.out.println("[FAIL]");
			failCount++;
		}
		System.out.print("\tTest Description:");
		if(testEventDescript())
		{
			System.out.println("[PASS]");
			passCount++;
		}
		else
		{
			System.out.println("[FAIL]");
			failCount++;
		}
		System.out.print("\tTest ID:");
		if(testEventID())
		{
			System.out.println("[PASS]");
			passCount++;
		}
		else
		{
			System.out.println("[FAIL]");
			failCount++;
		}
		System.out.printf("Event Testing Done:\n\tPassed: %d\n\tFailed: %d", passCount, failCount);
	}

	static boolean testEventDate()
	{
		Date newDate = new Date(2013,9,25,12,0);
		Event newEvent = new Event(newDate, "name", "place", "descript");

		return (newEvent.m_date.equals(newDate));
	}

	static boolean testEventName()
	{
		String name = "Test1";
		Event newEvent = new Event( new Date(2013,9,25,12,0), name, "place", "descript");

		return (newEvent.m_name.equals(name));
	}

	static boolean testEventPlace()
	{
		String place = "Test2";
		Event newEvent = new Event( new Date(2013,9,25,12,0), "name", place, "descript");

		return (newEvent.m_place.equals(place));
	}

	static boolean testEventDescript()
	{
		String descript = "Test3";
		Event newEvent = new Event( new Date(2013,9,25,12,0), "name", "place", descript);

		return (newEvent.m_discription.equals(descript));
	}

	static boolean testEventID()
	{
		Date newDate = new Date(2013,9,25,12,0);
		String name = "Test1";
		String place = "Test2";
		String descript = "Test3";
		int id = newDate.hashCode() + name.hashCode() + place.hashCode() + descript.hashCode();
		Event newEvent = new Event(newDate, name, place, descript);

		return (newEvent.getId() == id);
	}
}
