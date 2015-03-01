package com.mycompany.mvc.examples.button.example2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * An event listener for the button
 * 
 * @author colin
 *
 */
public class ButtonListener implements ActionListener {

	// view
	private ListenerDemo guiReference;

	/**
	 * Constructor
	 * 
	 * @param l the view
	 */
	public ButtonListener(ListenerDemo l) {
		guiReference = l;
	}

	/**
	 *  'call back' to GUI to set label
	 */
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		guiReference.setLabel("Button4 Pressed");
	}

}
