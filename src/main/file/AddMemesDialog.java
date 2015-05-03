package main.file;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import net.miginfocom.swing.MigLayout;

public class AddMemesDialog {
	JFrame mainFrame;
	MigLayout mainLayout;
	JPanel mainPanel, buttonPane, previewPane;
	JList<String> list;
	JFileChooser chooser;
	JButton browse, remove, next;
	File[] picFiles;
	DefaultListModel<String> listModel;
	JScrollPane listPane;
	String selectedItem;
	BufferedImage preview;
	JLabel previewLabel;
	List<File> listItems;
	String[] tempList;
	ImageIcon imgIcon;
	boolean continueLoop = true;
	
	public AddMemesDialog() {
		// MainFrame and MainLayout
		mainFrame = new JFrame("Add Meme(s)");
		mainLayout = new MigLayout();
		mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		// JPanels
		mainPanel = new JPanel();
		mainPanel.setLayout(mainLayout);
		buttonPane = new JPanel();
		buttonPane.setLayout(new MigLayout("", "[center]", "[center]"));
		previewPane = new JPanel();
		previewPane.setLayout(new MigLayout("", "[center]", "[center]"));
		
		// JLabel
		previewLabel = new JLabel();
		
		// JList
		listItems = new ArrayList<File>();
		listModel = new DefaultListModel<>();
		list = new JList<>(listModel);
		list.setMinimumSize(new Dimension(150, 200));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if(!list.isSelectionEmpty()) {
					int index = list.getSelectedIndex();
					File f = listItems.get(index);
					imgIcon = new ImageIcon(f.getPath());
					int width = imgIcon.getIconWidth();
					int height = imgIcon.getIconHeight();
					float r = (width > height) ? ( (float) 500 / width ) : ( (float) 500 / height );
					Image img = imgIcon.getImage();
					Image newimg = img.getScaledInstance((int)(width * r),(int)(height * r), Image.SCALE_SMOOTH);
					ImageIcon newImageIcon = new ImageIcon(newimg);
					previewLabel.setIcon(newImageIcon);
					mainFrame.pack();
				}
			}
			
		});
		
		// JScrollPane
		listPane = new JScrollPane(list);
		listPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		// JFileChooser
		chooser = new JFileChooser();
		chooser.setMultiSelectionEnabled(true);
		
		// JButton
		browse = new JButton("Browse");
		browse.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int retval = chooser.showOpenDialog(mainFrame);
				if(retval == JFileChooser.APPROVE_OPTION) {
					picFiles = chooser.getSelectedFiles();
					for(File file : picFiles) {
						if(checkFile(file) && notInList(file)) {
							listItems.add(file);
							listModel.addElement(file.getName());
						}
					}
					if(list.isSelectionEmpty() && listItems.size() != 0) {
						list.setSelectedIndex(0);
					}
				}
			}
		});
		
		remove = new JButton("Remove");
		remove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(!list.isSelectionEmpty()) {
					int index = list.getSelectedIndex();
					listModel.remove(index);
					listItems.remove(index);
					list.setSelectedIndex((index == 0) ? index : index - 1);
				}
			}
			
		});
		
		next = new JButton("Next");
		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				nextAction();
				
			}
			
		});
		
		// Add
		filler(buttonPane, "wrap");
		buttonPane.add(browse);
		filler(buttonPane, "wrap");
		buttonPane.add(remove);
		
		previewPane.add(previewLabel);
		
		filler(mainPanel, "span 4");
		filler(mainPanel, "wrap");
		filler(mainPanel);
		mainPanel.add(listPane);
		filler(mainPanel);
		mainPanel.add(buttonPane);
		filler(mainPanel);
		mainPanel.add(previewPane);
		filler(mainPanel, "wrap");
		filler(mainPanel, "span 4");
		mainPanel.add(next);
		mainFrame.add(mainPanel);
		
		// Set Visibility
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
	
	boolean checkFile(File file) {
		ImageIcon iI = new ImageIcon(file.getPath());
		if(iI.getIconWidth() == -1) {
			return false;
		} else {
			return true;
		}

	}
	
	boolean notInList(File file) {
		if(listModel.contains((String)file.getName())) {
			return false;
		} else {
			return true;
		}
	}

	
	void filler(JPanel panel) {
		panel.add(new JPanel());
	}
	
	void filler(JPanel panel, String arg) {
		panel.add(new JPanel(), arg);
	}
	
	void nextAction() {
		for(File f : listItems) {
			new AddDetailsDialog(f, this);
			if(!continueLoop) { break; }
		}
	}

}