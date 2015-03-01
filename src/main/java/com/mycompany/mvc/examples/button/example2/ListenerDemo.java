package com.mycompany.mvc.examples.button.example2;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * Demonstrate different ways of attaching listeners to buttons
 * 
 * <p>
 * There are multiple ways to do this. This demo example doesn't fully exploit
 * MVC. However, all methods achieve separation of the Event handling 'Controller' logic
 * from the Presenting 'View'. 
 * 
 * <p>
 * This very simple example demonstrates 4 ways to implement this:
 * <ol>
 * 	<li>local action performed method</li>
 * 	<li>Inner classes</li>
 * 	<li>Anonymous inner classes</li>
 * 	<li>External class</li>
 * </ol>
 * 
 * 
 * @author colin
 */
public class ListenerDemo implements ActionListener {
	
	// UI component
	private JLabel label;

	/**
	 * Creates the UI components 
	 * 
	 * @return an UI component container containing the individual UI components
	 */
	public Component createComponents() {
		
		label = new JLabel();

		JButton button1 = new JButton("Button1");
		JButton button2 = new JButton("Button2");
		JButton button3 = new JButton("Button3");
		JButton button4 = new JButton("Button4");

		JPanel pane = new JPanel();
		pane.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		pane.setLayout(new GridLayout(5, 1));
		pane.add(button1);
		pane.add(button2);
		pane.add(button3);
		pane.add(button4);
		pane.add(label);
		
		// 1. Uses local actionPerformed method
		button1.addActionListener(this);
		
		// 2. Uses inner class
		button2.addActionListener(new Button2Listener());
		
		// 3. Uses anonymous inner class
		button3.addActionListener(new ActionListener() {
			
			/*
			 * (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText("Button3 Pressed");
			}
		});

		// 4. Uses external class
		button4.addActionListener(new ButtonListener(this));

		return pane;
	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		label.setText("Button1 Pressed");
	}

	// Inner class
	private class Button2Listener implements ActionListener {
		
		/*
		 * (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			label.setText("Button2 Pressed");
		}
	}

	/**
	 * To accommodate callback from outside
	 * 
	 * @param s label text
	 */
	public void setLabel(String s) {
		label.setText(s);
	}

	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Create the top-level container and add contents to it.
		JFrame frame = new JFrame("ListenerDemo");
		ListenerDemo app = new ListenerDemo();
		frame.getContentPane().add(app.createComponents(), BorderLayout.CENTER);
		frame.setLocation(200, 200);
		
		frame.addWindowListener(new WindowAdapter() {
			
			/*
			 * (non-Javadoc)
			 * @see java.awt.event.WindowAdapter#windowClosing(java.awt.event.WindowEvent)
			 */
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		// Finish setting up the frame, and show it.
		frame.pack();
		frame.setVisible(true);
	}
}
