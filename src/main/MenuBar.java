package main;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import main.help.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import main.file.*;


import javax.swing.*;

public class MenuBar extends JMenuBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JMenu fileMenu, helpMenu;
	JMenuItem addMemesMenuItem, preferencesMenuItem, exitMenuItem;	// File Menu
	JMenuItem visitWebsiteMenuItem, aboutMenuItem;		// Help Menu
	
	
	MenuBar() {
		fileMenu = new JMenu("File");
		helpMenu = new JMenu("Help");
		
		// File Menu - Add Meme(s)
		addMemesMenuItem = new JMenuItem("Add Meme(s)");
		addMemesMenuItem.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddMemesDialog();
			}
		});
		
		// File Menu - Preferences
		preferencesMenuItem = new JMenuItem("Preferences");
		preferencesMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		// File Menu - Exit
		exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		// Help Menu - Visit Website
		visitWebsiteMenuItem = new JMenuItem("Visit Website");
		visitWebsiteMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				URI uri = null;
				try {
					uri = new URI("http://cryf.in/");
				} catch (Exception arg) {
					arg.printStackTrace();
				}
				Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
			    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
			        try {
			            desktop.browse(uri);
			        } catch (IOException e1) {
			            e1.printStackTrace();
			        }
			    }
			
			}
		});
		
		// Help Menu - About
		aboutMenuItem = new JMenuItem("About");
		aboutMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AboutDialog AD = new AboutDialog();
				AD.launch();
			}
		});
		
		fileMenu.add(addMemesMenuItem);
		fileMenu.add(preferencesMenuItem);
		fileMenu.add(exitMenuItem);
		
		helpMenu.add(visitWebsiteMenuItem);
		helpMenu.add(aboutMenuItem);
		
		this.add(fileMenu);
		this.add(helpMenu);
	}

}
