package com.mycompany.mvc.examples.button.example1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Separate Controller (Listener) that know of both View and Model
 * 
 * @author colin
 *
 */
public class PersonController implements ActionListener {
	
	// Model
	private PersonModel model;
	
	// View
	private PersonView view;

	/**
	 * Constructor
	 * 
	 * @param m the model
	 * @param v the view
	 */
	public PersonController(PersonModel m, PersonView v) {
		model = m;
		view = v;
	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		model.setAge(view.getAge());
		System.out.println(command);
	}

}