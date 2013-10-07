package com.cs3141.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;


public class RadioKeeper implements ActionListener{
	private static JRadioButton daily;
	private static JRadioButton weekly;
	private static JRadioButton monthly;
	private static JRadioButton yearly;
	
	public static void setDaily(JRadioButton button){
		daily=button;
	}
	
	public static void setWeekly(JRadioButton button){
		weekly=button;
	}
	
	public static void setMonthly(JRadioButton button){
		monthly=button;
	}
	
	public static void setYearly(JRadioButton button){
		yearly=button;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(!e.getSource().equals(daily)){
			daily.setSelected(false);
		}
		if(!e.getSource().equals(weekly)){
			weekly.setSelected(false);
		}
		if(!e.getSource().equals(monthly)){
			monthly.setSelected(false);
		}
		if(!e.getSource().equals(yearly)){
			yearly.setSelected(false);
		}
	}
	
	
}
