package com.cs3141.test;

import com.cs3141.calender.Event;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Tim
 * Date: 9/25/13
 * Time: 2:29 PM
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

	private static boolean testEventDate()
	{
		Date newDate = new Date();
		Event newEvent = new Event(newDate, "name", "place", "descript");

		return (newEvent.m_date.equals(newDate));
	}

	private static boolean testEventName()
	{
		String name = "Test1";
		Event newEvent = new Event( new Date(), name, "place", "descript");

		return (newEvent.m_name.equals(name));
	}

	private static boolean testEventPlace()
	{
		String place = "Test2";
		Event newEvent = new Event( new Date(), "name", place, "descript");

		return (newEvent.m_place.equals(place));
	}

	private static boolean testEventDescript()
	{
		String descript = "Test3";
		Event newEvent = new Event( new Date(), "name", "place", descript);

		return (newEvent.m_discription.equals(descript));
	}

	private static boolean testEventID()
	{
		Date newDate = new Date();
		String name = "Test1";
		String place = "Test2";
		String descript = "Test3";
		int id = newDate.hashCode() + name.hashCode() + place.hashCode() + descript.hashCode();
		Event newEvent = new Event(newDate, name, place, descript);

		return (newEvent.getId() == id);
	}
}
