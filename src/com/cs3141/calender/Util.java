package com.cs3141.calender;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Tim
 * Date: 10/3/13
 * Time: 9:43 AM
 * To change this template use File | Settings | File Templates.
 */
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
}
