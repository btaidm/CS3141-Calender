package com.cs3141.calender;

import com.cs3141.util.Util;

import java.io.IOException;
import java.text.DateFormat;
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
public class CalenderTxtUI
{
	private static final String help = "Calender by Tim and Matt\n" +
			"Help:\n" +
			"\thelp, h, ?: displays this\n" +
			"\texit, quit, q: exits calender\n" +
			"\tadd event, add: Prompts for adding event\n" +
			"\tview, v: View events from nearest to furthest out\n" +
			"\tsave, s: Save the events to the calender file\n";

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		EventManager eventManager = new EventManager();
		try
		{
			eventManager.readFromCSV();
		} catch (IOException e)
		{
			System.out.println("Error Reading: " + e.toString());
		}

		boolean exit = false;
		while (!exit)
		{
			System.out.print("CalenderTxtUI Command: ");
			String in = input.nextLine();
			System.out.println();

			if (in.equalsIgnoreCase("help") || in.equalsIgnoreCase("h") || in.equalsIgnoreCase("?"))
			{
				System.out.println(help);
				continue;
			}
			if (in.equalsIgnoreCase("test"))
			{
				String date = input.nextLine();

				Date newDate = Util.tryParse(date);
				if (newDate != null)
				{
					System.out.println("Your input \'" + date + "\' converts to \'" + newDate.toString() + "\'");
				}
			}
			if (in.equalsIgnoreCase("add event") || in.equalsIgnoreCase("add"))
			{
				Date newDate = null;

				System.out.print("Event Name: ");
				String name = input.nextLine();

				while (newDate == null)
				{
					System.out.print("Event Date (mm/dd/yyyy hh:mm AM/PM or mm-dd-yyyy hh:mm AM/PM): ");
					String date = input.nextLine();
					newDate = Util.tryParse(date);
					if (newDate == null)
					{
						System.out.println("Invalid Date format");
					}
				}

				System.out.print("Event Place: ");
				String place = input.nextLine();

				System.out.print("Event Description: ");
				String description = input.nextLine();
				String repeat;
				Repeated repeated = Repeated.NONE;
				boolean repeatSpecified= false;

				if (!repeatSpecified)
				{
					System.out.print("Repeated - (n)one, (d)aily, (w)eekly, (m)onthly, (y)early: ");
					repeat = input.nextLine();

					if (repeat.equalsIgnoreCase("n") || repeat.equalsIgnoreCase("none"))
					{
						repeated = Repeated.NONE;
						repeatSpecified = true;
					} else if (repeat.equalsIgnoreCase("d") || repeat.equalsIgnoreCase("daily"))
					{
						repeated = Repeated.DAILY;
						repeatSpecified = true;
					} else if (repeat.equalsIgnoreCase("w") || repeat.equalsIgnoreCase("weekly"))
					{
						repeated = Repeated.WEEKLY;
						repeatSpecified = true;
					} else if (repeat.equalsIgnoreCase("m") || repeat.equalsIgnoreCase("monthly"))
					{
						repeated = Repeated.MONTHLY;
						repeatSpecified = true;
					}else if(repeat.equalsIgnoreCase("y") || repeat.equalsIgnoreCase("yearly"))
					{
						repeated = Repeated.YEARLY;
						repeatSpecified = true;
					}
					if(!repeatSpecified)
					{
						System.out.println("Repeat not specified correctly");
					}
				}

				Event newEvent = new Event(newDate, name, place, description, repeated);
				eventManager.addEvent(newEvent);

			}

			if (in.equalsIgnoreCase("view") || in.equalsIgnoreCase("v"))
			{
				ArrayList<Event> events = eventManager.getAllEvents();
				for (Event event : events)
				{
					System.out.println(event.m_name + ": " + event.m_discription);
					System.out.println("Place: " + event.m_place);
					DateFormat dateFormat = new SimpleDateFormat("EEEE MMMM d, YYYY hh:mm a");
					System.out.println(dateFormat.format(event.m_date));
					System.out.println("Repeated: " + event.m_repeat);
					System.out.println();
				}
			}

			if (in.equalsIgnoreCase("month") || in.equalsIgnoreCase("m"))
			{
				ArrayList<Event> events = eventManager.getCurrentMonthEvents();
				for (Event event : events)
				{
					Util.parseDay(event.m_date);
					System.out.println(event.m_name + ": " + event.m_discription);
					System.out.println("Place: " + event.m_place);
					DateFormat dateFormat = new SimpleDateFormat("EEEE MMMM d, YYYY hh:mm a");
					System.out.println(dateFormat.format(event.m_date));
					System.out.println();
				}
			}

			if (in.equalsIgnoreCase("range") || in.equalsIgnoreCase("r"))
			{
				Date startDate = null;
				Date endDate = null;

				while (startDate == null)
				{
					System.out.print("Start Date (mm/dd/yyyy or mm-dd-yyyy): ");
					String date = input.nextLine();
					startDate = Util.tryParseShort(date);
					if (startDate == null)
					{
						System.out.println("Invalid Date format");
					}
				}

				while (endDate == null)
				{
					System.out.print("End Date (mm/dd/yyyy or mm-dd-yyyy): ");
					String date = input.nextLine();
					endDate = Util.tryParseShort(date);
					if (endDate == null)
					{
						System.out.println("Invalid Date format");
					}
				}

				System.out.println();

				try
				{
					ArrayList<Event> events = eventManager.getRange(startDate, endDate);
					if (events.isEmpty())
					{
						System.out.println("No Events Found\n");
					} else
					{
						for (Event event : events)
						{
							System.out.println(event.m_name + ": " + event.m_discription);
							System.out.println("Place: " + event.m_place);
							DateFormat dateFormat = new SimpleDateFormat("EEEE MMMM d, YYYY hh:mm a");
							System.out.println(dateFormat.format(event.m_date));
							System.out.println();
						}
					}
				} catch (IllegalArgumentException e)
				{
					System.out.println("Error: " + e.toString() + "\n");
				}
			}

			if (in.equalsIgnoreCase("save") || in.equalsIgnoreCase("s"))
			{
				try
				{
					eventManager.saveToCSV();
				} catch (IOException e)
				{
					System.out.println("Error Saving: " + e.toString());
				}
			}

			if (in.equalsIgnoreCase("load") || in.equalsIgnoreCase("l"))
			{
				try
				{
					eventManager.readFromCSV();
				} catch (IOException e)
				{
					System.out.println("Error loading: " + e.toString());
				}
			}

			if (in.equalsIgnoreCase("exit") || in.equalsIgnoreCase("quit") || in.equalsIgnoreCase("q"))
			{
				exit = true;
			}
		}
	}


}
