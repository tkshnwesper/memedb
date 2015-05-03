package main.file;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import main.db;
import net.miginfocom.swing.MigLayout;



public class AddDetailsDialog {
	JFrame mainFrame;
	JPanel mainPanel, buttonPanel;
	JLabel titleLabel, descriptionLabel, tagsLabel, categoryLabel, fileNameLabel;
	JTextField titleField, tagsField, fileNameField;
	JTextArea descriptionArea;
	JScrollPane dAreaPane;
	JButton skipAll, addToDB, skip;
	db db;
	
	void filler() {
		mainPanel.add(new JPanel());
	}
	
	void filler(String arg) {
		mainPanel.add(new JPanel(), arg);
	}
	
	JLabel addLabel(JLabel l, String t) {
		l = new JLabel(t);
		return l;
	}
	
	JTextField addTF(JTextField tf) {
		tf = new JTextField(20);
		return tf;
	}
	
	void addToDBMethod() throws Exception {
		if(fileNameField.getText() == "") {
			throw new Exception("File Name should not be left empty");
		}
		
		
	}
	
	AddDetailsDialog(File memeImage, final AddMemesDialog callingObj) {
		db = new db();
		
		mainFrame = new JFrame();
		mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new MigLayout());
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new MigLayout());
		
		descriptionArea = new JTextArea(3, 20);
		dAreaPane = new JScrollPane(descriptionArea);
		dAreaPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		fileNameField = new JTextField(memeImage.getName(), 20);
		
		// JButton
		skip = new JButton("Skip");
		skip.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				mainFrame.dispose();
				
			}
			
		});
		
		skipAll = new JButton("Skip All");
		skipAll.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				callingObj.continueLoop = false;
				
			}
		});
		
		addToDB = new JButton("Add to DB");
		addToDB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					addToDBMethod();
				} catch(Exception except) {
					except.printStackTrace();
				}
			}
		});
		
		buttonPanel.add(skipAll);
		buttonPanel.add(skip);
		buttonPanel.add(addToDB);
		
		// Add
		filler("span 2");
		filler("wrap");
		filler();
		mainPanel.add(addLabel(fileNameLabel, "File Name"), "align left");
		filler("wrap");
		filler();
		mainPanel.add(fileNameField);
		filler("wrap");
		filler("span 2");
		filler("wrap");
		filler();
		mainPanel.add(addLabel(titleLabel, "Title"), "align left");
		filler("wrap");
		filler();
		mainPanel.add(addTF(titleField));
		filler("wrap");
		filler("span 2");
		filler("wrap");
		filler();
		mainPanel.add(addLabel(descriptionLabel, "Description"), "align left");
		filler("wrap");
		filler();
		mainPanel.add(dAreaPane);
		filler("wrap");
		filler("span 2");
		filler("wrap");
		filler();
		mainPanel.add(addLabel(tagsLabel, "Tags"), "align left");
		filler("wrap");
		filler();
		mainPanel.add(addTF(tagsField));
		filler("wrap");
		filler("span 2");
		filler("wrap");
		filler();
		mainPanel.add(buttonPanel);
		filler("wrap");
		filler("span 3");
		
		// Add to mainFrame
		mainFrame.add(mainPanel);
		mainFrame.pack();
		mainFrame.setVisible(true);
	}

}
