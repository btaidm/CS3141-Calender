package com.cs3141.gui;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ListModel;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.filechooser.FileFilter;

import com.cs3141.calender.EventManager;


public class SaveDialog extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField saveName;
	private boolean saveOrLoad;//true for save
	private EventManager manager;
	private JList<String> filenameList;
	private JTextField textField;

	/**
	 * Create the dialog.
	 */
	public SaveDialog(boolean saveOrLoad, EventManager manager) {
		this.saveOrLoad = saveOrLoad;
		this.manager = manager;
		setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		{
			DefaultListModel<String> model = new DefaultListModel<String>();
			File home = new File(System.getProperty("user.home"));
			for(File file: home.listFiles(new filter("a"))){
				if(!file.isDirectory()){
					model.addElement(file.getName());
				}
			}
		}
		saveName = new JTextField();
		saveName.setColumns(25);
		{
			JScrollPane scrollPane = new JScrollPane();
			getContentPane().add(scrollPane, BorderLayout.CENTER);
			{
				JList<String> list = new JList<String>();
				if(saveOrLoad){
					list.addListSelectionListener(new FileList(saveName, list));
				}

				DefaultListModel<String> model = new DefaultListModel<String>();

				File home = new File(System.getProperty("user.home"));
				for(File file: home.listFiles(new filter(".csv"))){
					if(!file.isDirectory()){
						model.addElement(file.getName());

					}
				}
				list.setModel(model);
				filenameList = list;
				scrollPane.setViewportView(list);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			if(saveOrLoad){
				{
					JLabel lblSaveAs = new JLabel("Save as:");
					buttonPane.add(lblSaveAs);
				}
				{
					buttonPane.add(saveName);
				}
			}
			{
				String text = saveOrLoad ? "Save" : "Load";
				JButton okButton = new JButton(text);
				okButton.addActionListener(new SaveOrLoadFile(saveOrLoad, manager, saveName, this));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
