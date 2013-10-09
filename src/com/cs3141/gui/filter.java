/**
 * @author mfmansfi
 * 
 * @date 10/7/2013
 * 
 * the filter for filtering out undesired files
 */

package com.cs3141.gui;
import java.io.File;
import java.io.FileFilter;


public class filter implements FileFilter {

	String accepted;
	
	/**
	 * takes in the string accepted strings must contain.
	 * @param acc
	 */
	
	public filter(String acc){
		accepted = acc;
	}
	@Override
	public boolean accept(File arg0) {
		return (arg0.getName().contains(accepted));
	}

}
