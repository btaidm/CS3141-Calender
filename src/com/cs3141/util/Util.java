package com.cs3141.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Util
{
	private static final String[] formatStrings = {"MM/dd/yyyy hh:mm a", "MM-dd-yyyy hh:mm a",
			"E MMM dd HH:mm:ss zzz yyyy", "MM/dd/yyyy", "MM-dd-yyyy"};

	private static final String[] formatStringShort= {"MM/dd/yyyy", "MM-dd-yyyy"};

	public static Date tryParse(String dateString)
	{
		try
		{
			return new SimpleDateFormat().parse(dateString);
		} catch (ParseException e)
		{
		}

		for (String formatString : formatStrings)
		{
			try
			{
				return new SimpleDateFormat(formatString).parse(dateString);
			} catch (ParseException e)
			{
			}
		}

		return null;
	}

	public static Date tryParseShort(String dateString)
	{

		for (String formatString : formatStringShort)
		{
			try
			{
				return new SimpleDateFormat(formatString).parse(dateString);
			} catch (ParseException e)
			{
			}
		}

		return null;
	}

	public static int parseDay(Date _date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(_date);
		return calendar.get(Calendar.DAY_OF_WEEK);
	}
}
