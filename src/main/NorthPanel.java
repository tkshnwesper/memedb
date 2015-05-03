package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class NorthPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	FlowLayout northPanelLayout;
	JTextField searchTextField;
	JButton searchButton;
	String searchQuery = null;
	JPanel searchBarPanel, searchByPanel;
	JRadioButton titleRB, descriptionRB, tagsRB;
	RadioButtonActionListener searchByAL;
	ButtonGroup searchByBG;
	JLabel searchByLabel;
	
	String getSearchQuery() {
		return searchQuery;
	}
	
	void setUpRB(String label, String AC, JRadioButton RB) {
		RB = new JRadioButton(label);
		RB.setActionCommand(AC);
		RB.addActionListener(searchByAL);
		searchByBG.add(RB);
		searchByPanel.add(RB);
	}
	
	NorthPanel() {
		// Layout
		northPanelLayout = new FlowLayout();
		this.setLayout(northPanelLayout);
		
		searchByAL = new RadioButtonActionListener();
		searchByBG = new ButtonGroup();
		
		searchByPanel = new JPanel(new FlowLayout());
		searchByLabel = new JLabel("Search By:");
		
		// Search Bar
		searchTextField = new JTextField(20);
		searchButton = new JButton("Search");
		searchBarPanel = new JPanel(new FlowLayout());
		
		searchButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				searchQuery = searchTextField.getText();
				onSearch();
							
			}
		});
		
		
		// Adding
		searchBarPanel.add(searchTextField);
		searchBarPanel.add(searchButton);
	
		searchByPanel.add(searchByLabel);
		setUpRB("Title", "title", titleRB);
		setUpRB("Tags", "tags", tagsRB);
		setUpRB("Description", "description", descriptionRB);
		
		this.add(searchBarPanel);
		this.add(searchByPanel);
		
	}
	
	void onSearch() {
		
	}
	

}
