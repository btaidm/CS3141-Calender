package com.cs3141.gui;
import java.io.File;
import java.io.FileFilter;


public class filter implements FileFilter {

	String accepted;
	
	public filter(String acc){
		accepted = acc;
	}
	@Override
	public boolean accept(File arg0) {
		return (arg0.getName().contains(accepted));
	}

}
