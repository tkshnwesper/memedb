package main;

import java.awt.event.*;


public class RadioButtonActionListener implements ActionListener {
	String actionCommand;
	
	public RadioButtonActionListener() {
		actionCommand = null;
	}

	public void actionPerformed(ActionEvent e) {
		actionCommand = e.getActionCommand();
	}
	
	public String getActionCommand() {
		return actionCommand;
	}
	
	public void setActionCommand(String ac) {
		actionCommand = ac;
	}

}
