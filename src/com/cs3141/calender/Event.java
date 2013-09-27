package com.cs3141.calender;

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
public class Event{

	protected int id;
	public Date m_date;
	public String m_name;
	public String m_place;
	public String m_discription;

	public Event(Date _date, String _name, String _place, String _dis)
	{
		id = _date.hashCode() + _name.hashCode() + _place.hashCode() + _dis.hashCode();
		m_date = _date;
		m_name = _name;
		m_place = _place;
		m_discription = _dis;
	}

	public int getId()
	{
		return id;
	}
	//boolean m_repeat;

}
