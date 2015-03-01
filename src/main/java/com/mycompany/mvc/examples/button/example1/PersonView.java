package com.mycompany.mvc.examples.button.example1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



/**
 * This represents the View of the MVC. It holds a reference to the Model in order
 * to obtain changes in the data. This view creates the Controller (Listener).
 * 
 * @author colin
 *
 */
public class PersonView extends JFrame implements Observer {

	private static final long serialVersionUID = -4273041196870622292L;

	private PersonModel aperson;			// Model

	private PersonController acontroller; 	// Controller

	private JLabel label;
	private JTextField textfield;
	private JButton button1;

	/**
	 * Constructor
	 * 
	 * @param p the model representing the person
	 */
	public PersonView(PersonModel p) {

		// View holds a reference to person Model
		aperson = p;

		// register View as an observer of person Model
		p.addObserver(this);

		initComponents();
		
		// create Controller - eventHandler - with reference to person Model
		// and reference to person View for 'call backs'
		acontroller = new PersonController(aperson, this);
		button1.addActionListener(acontroller);
		textfield.addActionListener(acontroller);

		this.pack();
	}
	
	/*
	 * Makes the UI components and lays them on screen
	 */
	private void initComponents(){
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label = new JLabel("Age: " + aperson.getAge());
		textfield = new JTextField();
		button1 = new JButton("Button1");

		// Just laying out the Frame
		JPanel pane = new JPanel(new BorderLayout());
		pane.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		pane.setLayout(new GridLayout(3, 1));
		pane.add(button1);
		pane.add(textfield);
		pane.add(label);
		
		this.getContentPane().add(BorderLayout.SOUTH, pane);
	}

	
	/**
	 * When person Model changes it sends update message to all its Observers
	 */
	/*
	 * (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object obj) {
		int age = aperson.getAge();
		label.setText("Age: " + age);
		textfield.setText(Integer.toString(age));
	}

	
	/**
	 * This methods is used by Controller (Listener) to obtain age value from the 
	 * textfield
	 * 
	 * @return the age value from the textfield
	 */
	public int getAge() {
		
		// catching this runtime exception
		int age = aperson.getAge();
		
		try{
			age = Integer.parseInt(textfield.getText());
			if(age < 0){
				displayErrorMessage("Age cannot be a negative value");
			}
		}
		catch(NumberFormatException e){
			displayErrorMessage("Age needs to be a number");
		}
		
		return age;
	}
	
	/*
	 * Helper method to display an error message in a standard error dialog
	 */
	private void displayErrorMessage(String message){
		JOptionPane.showMessageDialog(this, message, 
				"ERROR", JOptionPane.ERROR_MESSAGE);
	}
}
