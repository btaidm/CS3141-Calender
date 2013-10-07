package com.cs3141.gui;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;

import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

import com.cs3141.calender.Event;
import com.cs3141.calender.EventManager;

import java.awt.Panel;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.event.ListDataEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class CalenderGui {

	private JFrame frame;
	private static EventManager manager;
	private DefaultListModel<Event> dailyModel;
	private JList<Event> dailyList;
	private DefaultListModel<Event> weeklyModel;
	private JList<Event> weeklyList;
	private DefaultListModel<Event> monthlyModel;
	private JList<Event> monthlyList;

	/**DefaultListModel
	 * Launch the application.
	 */
	public static void main(String[] args) {
		manager = new EventManager();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalenderGui window = new CalenderGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static EventManager getEventManager(){
		return manager;
	}

	/**
	 * Create the application.
	 */
	public CalenderGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		manager = new EventManager();
		frame = new JFrame();
		frame.setBounds(100, 100, 850, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu JmFile = new JMenu("File");
		menuBar.add(JmFile);

		JMenuItem mntmSave = new JMenuItem("Save");
		final CalenderGui forgetThis = this;
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SaveDialog save = new SaveDialog(true, manager, forgetThis);
				save.setVisible(true);
			}
		});
		final EventManager ma = manager;

		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ma.clearEventManager();
				forgetThis.remake();
			}
		});
		JmFile.add(mntmNew);
		JmFile.add(mntmSave);

		JMenuItem mntmLoad = new JMenuItem("Load");
		mntmLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SaveDialog save = new SaveDialog(false, manager, forgetThis);
				save.setVisible(true);
			}
		});
		JmFile.add(mntmLoad);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new closeListener(frame));
		JmFile.add(mntmExit);

		JMenu mnEvents = new JMenu("Events");
		menuBar.add(mnEvents);

		JMenuItem mntmAddEvent = new JMenuItem("Add Event");
		mntmAddEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddEvent eventDialog = new AddEvent(forgetThis);
				eventDialog.setVisible(true);
			}
		});
		mnEvents.add(mntmAddEvent);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane);
		DefaultListModel<Event> model = new DefaultListModel<Event>();
		for(Event e: manager.getAllEvents()){
			model.addElement(e);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Daily", null, scrollPane, null);
		
		JList<Event> list = new JList<Event>();
		list.addKeyListener(new delKeyListener(manager, this, list));
		list.setModel(model);
		dailyList = list;
		dailyModel = model;
		scrollPane.setViewportView(list);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("Weekly", null, scrollPane_1, null);
		
		JList<Event> list_1 = new JList<Event>();
		model = new DefaultListModel<Event>();
		list_1.setModel(model);
		weeklyList = list_1;
		weeklyModel = model;
		list_1.addKeyListener(new delKeyListener(manager, this, list_1));
		scrollPane_1.setViewportView(list_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		tabbedPane.addTab("Monthly", null, scrollPane_2, null);
		
		JList<Event> list_2 = new JList<Event>();
		
		model = new DefaultListModel<Event>();
		list_2.setModel(model);
		monthlyList = list_2;
		monthlyModel = model;
		list_2.addKeyListener(new delKeyListener(manager, this, list_2));
		
		scrollPane_2.setViewportView(list_2);
		
		

	}
	
	public void remake(){
		dailyList.removeAll();
		dailyModel.clear();
		for(Event ev: manager.getCurrentDayEvents()){
			dailyModel.addElement(ev);
		}
		weeklyList.removeAll();
		weeklyModel.clear();
		for(Event ev: manager.getCurrentWeekEvents()){
			weeklyModel.addElement(ev);
		}
		monthlyList.removeAll();
		monthlyModel.clear();
		for(Event ev: manager.getCurrentMonthEvents()){
			monthlyModel.addElement(ev);
		}
	}
}
