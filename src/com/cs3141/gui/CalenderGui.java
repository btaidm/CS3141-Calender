package com.cs3141.gui;
import java.awt.EventQueue;

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

import com.cs3141.calender.EventManager;

import java.awt.Panel;


public class CalenderGui {

	private JFrame frame;
	private EventManager manager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the application.
	 */
	public CalenderGui() {
		initializeWeek();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initializeWeek(){
		initialize();
		
		//Date begWeek = manager.getBegginingOfWeek();
		//int day = begWeek.getDay();
	}
	
	private void initialize() {
		manager = new EventManager();
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu JmFile = new JMenu("File");
		menuBar.add(JmFile);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SaveDialog save = new SaveDialog(true, manager);
				save.setVisible(true);
			}
		});
		
		JMenuItem mntmNew = new JMenuItem("New");
		JmFile.add(mntmNew);
		JmFile.add(mntmSave);
		
		JMenuItem mntmLoad = new JMenuItem("Load");
		mntmLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SaveDialog save = new SaveDialog(false, manager);
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
				AddEvent eventDialog = new AddEvent();
				eventDialog.setVisible(true);
			}
		});
		mnEvents.add(mntmAddEvent);
		
		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);
		
		JMenuItem mntmViewByMonth = new JMenuItem("View By Month");
		mnView.add(mntmViewByMonth);
		
		JMenuItem mntmViewByWeek = new JMenuItem("View By Week");
		mnView.add(mntmViewByWeek);
		
		JMenuItem mntmViewByDay = new JMenuItem("View By Day");
		mnView.add(mntmViewByDay);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{542, 0};
		gridBagLayout.rowHeights = new int[] {73, 373, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		frame.getContentPane().add(panel_1, gbc_panel_1);
		panel_1.setLayout(new GridLayout(2, 7, 0, 0));
		
		JPanel Mon = new JPanel();
		panel_1.add(Mon);
		
		JLabel lblMonday = new JLabel("Monday");
		Mon.add(lblMonday);
		
		JPanel tues = new JPanel();
		panel_1.add(tues);
		
		JLabel lblTuesday = new JLabel("Tuesday");
		tues.add(lblTuesday);
		
		JPanel wed = new JPanel();
		panel_1.add(wed);
		
		JLabel lblWednesday = new JLabel("Wednesday");
		wed.add(lblWednesday);
		
		JPanel thurs = new JPanel();
		panel_1.add(thurs);
		
		JLabel lblThursday = new JLabel("Thursday");
		thurs.add(lblThursday);
		
		JPanel fri = new JPanel();
		panel_1.add(fri);
		
		JLabel lblFriday = new JLabel("Friday");
		fri.add(lblFriday);
		
		JPanel sat = new JPanel();
		panel_1.add(sat);
		
		JLabel lblSaturday = new JLabel("Saturday");
		sat.add(lblSaturday);
		
		JPanel sun = new JPanel();
		panel_1.add(sun);
		
		JLabel lblSunday = new JLabel("Sunday");
		sun.add(lblSunday);
		
		JPanel panel_9 = new JPanel();
		panel_1.add(panel_9);
		
		JLabel lblDay = new JLabel("Day");
		panel_9.add(lblDay);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		JLabel label = new JLabel("Day");
		panel_2.add(label);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		
		JLabel label_1 = new JLabel("Day");
		panel_3.add(label_1);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		
		JLabel label_2 = new JLabel("Day");
		panel_4.add(label_2);
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);
		
		JLabel label_3 = new JLabel("Day");
		panel_5.add(label_3);
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);
		
		JLabel label_4 = new JLabel("Day");
		panel_6.add(label_4);
		
		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7);
		
		JLabel label_5 = new JLabel("Day");
		panel_7.add(label_5);
		
		JPanel calPanel = new JPanel();
		GridBagConstraints gbc_calPanel = new GridBagConstraints();
		gbc_calPanel.insets = new Insets(0, 0, 5, 0);
		gbc_calPanel.fill = GridBagConstraints.BOTH;
		gbc_calPanel.gridx = 0;
		gbc_calPanel.gridy = 1;
		frame.getContentPane().add(calPanel, gbc_calPanel);
		calPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		calPanel.add(scrollPane, BorderLayout.CENTER);
		
		Panel panel = new Panel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(1, 7, 0, 0));
		
		Panel panel_8 = new Panel();
		panel.add(panel_8);
		
		Panel panel_10 = new Panel();
		panel.add(panel_10);
		
		Panel panel_11 = new Panel();
		panel.add(panel_11);
		
		Panel panel_14 = new Panel();
		panel.add(panel_14);
		
		Panel panel_12 = new Panel();
		panel.add(panel_12);
		
		Panel panel_13 = new Panel();
		panel.add(panel_13);
		
		Panel panel_15 = new Panel();
		panel.add(panel_15);
		
	}

}
