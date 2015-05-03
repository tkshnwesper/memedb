package main.help;


import java.awt.Font;
import java.awt.font.TextAttribute;
import java.io.*;
import java.util.Map;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class AboutDialog {

	JFrame mainFrame;
	JPanel mainPanel;
	MigLayout mainLayout;
	JLabel imgIcon, libraries,
		name, credits, sqliteDriver, 
		license, version, versionNo, versionName, 
		migLayoutLib;
	
	String iconPath() {
		File classPath = new File(AboutDialog.class.getResource("AboutDialog.class").getPath());
		File iPath = classPath.getParentFile().getParentFile().getParentFile();
		return iPath.getPath() + 
				File.separator + 
				"misc" + 
				File.separator + 
				"icons" + 
				File.separator +
				"MDB100x100.png";
	}
	
	public void launch() {
		// Main Frame
		mainFrame = new JFrame("About");
		mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mainFrame.setResizable(false);
		
		// Main Panel
		mainLayout = new MigLayout("", "[center]", "[center]");
		mainPanel = new JPanel(mainLayout);
		
		// Labels
		ImageIcon mdbIcon = new ImageIcon(iconPath());
		imgIcon = new JLabel(mdbIcon);
		version = new JLabel("Version");
		underlineLabel(version);
		versionNo = new JLabel("v0.0.0");
		versionName = new JLabel("\"I see what you did there\"");
		credits = new JLabel("Created by");
		underlineLabel(credits);
		name = new JLabel("Saurabh M. Machave");
		license = new JLabel("GNU Public License v3.0");
		underlineLabel(license);
		libraries = new JLabel("Libraries");
		underlineLabel(libraries);
		sqliteDriver = new JLabel("SQLite Driver: sqlite-jdbc driver by xerial");
		migLayoutLib = new JLabel("MigLayout Library");
		
		// Add to panel
		mainPanel.add(imgIcon, "wrap 30");
		mainPanel.add(version, "wrap");
		mainPanel.add(versionNo, "wrap");
		mainPanel.add(versionName, "wrap");
		mainPanel.add(new JPanel(), "wrap");
		mainPanel.add(credits, "wrap");
		mainPanel.add(name, "wrap");
		mainPanel.add(new JPanel(), "wrap");
		mainPanel.add(libraries, "wrap");
		mainPanel.add(sqliteDriver, "wrap");
		mainPanel.add(migLayoutLib, "wrap");
		mainPanel.add(new JPanel(), "wrap");
		mainPanel.add(license, "wrap 10");
		
		// Add Panel to Frame
		mainFrame.add(mainPanel);
		
		// Toggle Visibility
		mainFrame.setVisible(true);
		mainFrame.pack();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	void underlineLabel(JLabel label) {
		Font font = label.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		label.setFont(font.deriveFont(attributes));
	}

}
