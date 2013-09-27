package com.cs3141.calender;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Tim
 * Date: 9/26/13
 * Time: 8:31 PM
 */
public class Calender {
	private static final String help = "Calender by Tim and Matt\n" +
			"Help:\n" +
			"\thelp, h, ?: displays this\n" +
			"\texit, quit, q: exits calender\n" +
			"\tadd event, add: Prompts for adding event\n" +
			"\tview, v: View events from nearest to furthest out\n" +
			"\tsave, s: Save the events to the calender file\n";

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Scanner inputInt = new Scanner(System.in);
		EventManager eventManager = new EventManager();
		try {
			eventManager.readFromCSV();
		}
		catch (IOException e)
		{
			System.out.println("Error Reading: " + e.toString());
		}

		boolean exit = false;
		while (!exit) {
			System.out.print("Calender Command: ");
			String in = input.nextLine();
			System.out.println();

			if (in.equalsIgnoreCase("help") || in.equalsIgnoreCase("h") || in.equalsIgnoreCase("?")) {
				System.out.println(help);
				continue;
			}
			if(in.equalsIgnoreCase("test"))
			{
				String date = input.nextLine();

				Date newDate = tryParse(date);
				if(newDate != null)
				{
					System.out.println("Your input \'" + date + "\' converts to \'" + newDate.toString() + "\'");
				}
			}
			if (in.equalsIgnoreCase("add event") || in.equalsIgnoreCase("add")) {
				Date newDate = null;

				System.out.print("Event Name: ");
				String name = input.nextLine();

				while(newDate == null)
				{
					System.out.print("Event Date (mm/dd/yyyy hh:mm AM/PM or mm-dd-yyyy hh:mm AM/PM): ");
					String date = input.nextLine();
					newDate = tryParse(date);
					if(newDate == null)
					{
						System.out.println("Invalid Date format");
					}
				}

				System.out.print("Event Place: ");
				String place = input.nextLine();

				System.out.print("Event Description: ");
				String description = input.nextLine();

				Event newEvent = new Event(newDate, name, place, description);
				eventManager.addEvent(newEvent);

			}

			if (in.equalsIgnoreCase("view") || in.equalsIgnoreCase("v")) {
				ArrayList<Event> events = eventManager.getAllEvents();
				for(Event event : events)
				{
					System.out.println(event.m_name + ": " + event.m_discription);
					System.out.println("Place: " + event.m_place);
					DateFormat dateFormat = new SimpleDateFormat("EEEE MMMM d, YYYY hh:mm a");
					System.out.println(dateFormat.format(event.m_date));
					System.out.println();
				}
			}

			if(in.equalsIgnoreCase("save") || in.equalsIgnoreCase("s"))
			{
				try {
					eventManager.saveToCSV();
				}
				catch (IOException e)
				{
					System.out.println("Error Saving: " + e.toString());
				}
			}

			if (in.equalsIgnoreCase("exit") || in.equalsIgnoreCase("quit") || in.equalsIgnoreCase("q")) {
				exit = true;
			}
		}
	}

	private static final String formatStrings[] = {"MM/dd/yyyy hh:mm a", "MM-dd-yyyy hh:mm a"};
	private static Date tryParse(String dateString)
	{
		for (String formatString : formatStrings)
		{
			try
			{
				return new SimpleDateFormat(formatString).parse(dateString);
			}
			catch (ParseException e) {}
		}

		return null;
	}
}
