/*
 * |-------------------------------------------------
 * | Copyright © 2008 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.mvc.examples.button.example1;

/**
 * Main driver for the program
 * 
 * @author colin
 *
 */
public class App {
	
	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Create Model
		PersonModel p = new PersonModel();
        p.setAge(23);
        
        // Create 2 Views attached as Observers of one Model
        PersonView pv1 = new PersonView(p);
        pv1.setLocation(200, 200);
        pv1.setVisible(true);
        
        PersonView pv2 = new PersonView(p);
        pv2.setLocation(400, 200);
        pv2.setVisible(true);
        
        PersonView pv3 = new PersonView(p);
        pv3.setLocation(600, 200);
        pv3.setVisible(true);
	}
}

