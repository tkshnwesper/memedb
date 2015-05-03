package main;

import javax.swing.*;

import java.awt.*;


public class MemeDB {
	JFrame mainFrame;
	JPanel mainPanel, northPanel;
	JMenuBar menuBar;
	Dimension mainFrameSize, minMainFrameSize;
	BorderLayout mainPanelLayout;
	
	public void launch() {
		// Main Frame Settings
		mainFrame = new JFrame("MemeDB");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrameSize = new Dimension(800, 480);
		mainFrame.setSize(mainFrameSize);
		
		// Main Panel
		mainPanel = (JPanel) mainFrame.getContentPane();
		mainPanelLayout = new BorderLayout();
		mainPanel.setLayout(mainPanelLayout);
		
		// North Panel
		northPanel = new NorthPanel();
		mainPanel.add(new NorthPanel(), BorderLayout.NORTH);
		
		// Menu Bar
		menuBar = new MenuBar();
		mainFrame.setJMenuBar(menuBar);
		
		// Add Panels to Main Panel
		
		// Set Visibility
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MemeDB MDB = new MemeDB();
				MDB.launch();
			}
		});
	}

}
