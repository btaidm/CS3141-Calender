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
public class Event implements Comparable {

	protected int id;
	public Date m_date;
	public String m_name;
	public String m_place;
	public String m_discription;

	public Event(Date _date, String _name, String _place, String _dis) {
		id = _date.hashCode() + _name.hashCode() + _place.hashCode() + _dis.hashCode();
		m_date = _date;
		m_name = _name;
		m_place = _place;
		m_discription = _dis;
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
	//boolean m_repeat;

}
