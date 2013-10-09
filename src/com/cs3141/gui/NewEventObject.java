/**
 * @author mfmansfi
 * 
 * @date 10/7/2013
 * 
 * an object to hold alot of fields. just exists to shorten method parameters
 */

package com.cs3141.gui;

import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class NewEventObject {
	/**
	 * basic data container.
	 */
	JTextField eventName;
	JTextField eventDisc;
	JTextField eventDate;
	JTextField eventLoc;
	JTextField numTimesRepeated;
	JCheckBox checkbox;
	JRadioButton daily;
	JRadioButton weekly;
	JRadioButton monthly;
	JRadioButton yearly;
}
