package com.cs3141.calender;

import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Tim
 * Date: 9/18/13
 * Time: 2:09 PM
 */

/*! /brief
 *
 *
 *
 */
public class Event implements Comparable {

	protected int id;
	public Date m_date;
	public String m_name;
	public String m_place;
	public String m_discription;
	public Repeated m_repeat = Repeated.NONE;

	public Event(Date _date, String _name, String _place, String _dis) {
		id = _date.hashCode() + _name.hashCode() + _place.hashCode() + _dis.hashCode() + m_repeat.hashCode();
		m_date = _date;
		m_name = _name;
		m_place = _place;
		m_discription = _dis;
	}

	public Event(Date _date, String _name, String _place, String _dis, Repeated _repeat) {
		id = _date.hashCode() + _name.hashCode() + _place.hashCode() + _dis.hashCode() + _repeat.hashCode();
		m_date = _date;
		m_name = _name;
		m_place = _place;
		m_discription = _dis;
		m_repeat = _repeat;
	}

	public int getId() {
		return id;
	}

	@Override
	public int compareTo(Object o) throws IllegalArgumentException {
		if (o instanceof Event) {
			if (this.m_date.before(((Event) o).m_date)) {
				return -1;
			} else if (this.m_date.equals(((Event) o).m_date)) {
				return 0;
			} else if (this.m_date.after(((Event) o).m_date)) {
				return 1;
			}
			throw new IllegalArgumentException();
		}
		throw new IllegalArgumentException();
	}

	public String toStringHtmlLong()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(m_date);
		int min = calendar.get(Calendar.MINUTE);
		int hour = (calendar.get(Calendar.HOUR) == 0 ? 12 : calendar.get(Calendar.HOUR));
		int ampm = calendar.get(Calendar.AM_PM);
		if(ampm == Calendar.AM)
		{
			return String.format("<html><p>" + m_name + ": " + m_discription +"<br>Place: " + m_place + "<br>Time: " + hour + ":%02d AM</p></html>", min);
		}
		else
		{
			return String.format("<html><p>" + m_name + ": " + m_discription +"<br>Place: " + m_place + "<br>Time: " + hour + ":%02d PM</p></html>", min);
		}
	}

	public String toStringHtmlShort()
	{
			return "<html><p>" + m_name + "</p></html>";
	}
}
