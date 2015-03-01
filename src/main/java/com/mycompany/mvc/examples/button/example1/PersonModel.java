package com.mycompany.mvc.examples.button.example1;

import java.util.Observable;

/**
 * This is the model of the MVC. It knows nothing of the Views or the Controller.
 * It only knows of Observers where it sends them update when anything changes
 * 
 * @author colin
 *
 */
public class PersonModel extends Observable {

	private int age;

	/**
	 * Constructor
	 */
	public PersonModel() {
		age = 0;
	}

	/**
	 * Sets the age of the person
	 * 
	 * @param a new age
	 */
	public void setAge(int a) {
		age = a;
		
		// tell Observers that the observable subject has changed
		setChanged();
		notifyObservers();
	}

	/**
	 * Gets the age of the person
	 * 
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
}
