package iu.oop.labs.lab04;

import javax.swing.JFrame;

import iu.oop.labs.lab04.question1.Question1;
import iu.oop.labs.lab04.question2.Question2;
import iu.oop.labs.lab04.question3.Question3A;
import iu.oop.labs.lab04.question3.Question3B;
import iu.oop.labs.lab04.question4.Question4A;
import iu.oop.labs.lab04.question4.Question4B;
import iu.oop.labs.lab04.question5.Question5A;
import iu.oop.labs.lab04.question5.Question5B;
import iu.oop.labs.lab04.question6.Question6;

public class Main {
	public static void Q1() {
		Question1.main(null);
	}

	public static void Q2() {
		// Create a panel that contains our drawing
		Question2 q2 = new Question2();
		// Create a new frame to hold the panel
		JFrame frame  = new JFrame();
	
		// Set the frame to exit when it is closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(q2); // add the panel to the frame
		frame.setSize(250, 250); // set the size of the frame
		frame.setVisible(true); // make the frame visible
	}

	public static void Q3A() {
		// Create a panel that contains our drawing
		Question3A q3a = new Question3A();
	
		// Create a new frame to hold the panel
		JFrame frame  = new JFrame();
			
		// Set the frame to exit when it is closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(q3a); // add the panel to the frame
		frame.setSize(250, 250); // set the size of the frame
		frame.setVisible(true); // make the frame visible
	}

	public static void Q3B() {
		// Create a panel that contains our drawing
		Question3B q3b = new Question3B();
	
		// Create a new frame to hold the panel
		JFrame frame  = new JFrame();
			
		// Set the frame to exit when it is closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(q3b); // add the panel to the frame
		frame.setSize(250, 250); // set the size of the frame
		frame.setVisible(true); // make the frame visible
	}

	public static void Q4A() {
		// Create a panel that contains our drawing
		Question4A q4a = new Question4A();
	
		// Create a new frame to hold the panel
		JFrame frame  = new JFrame();
			
		// Set the frame to exit when it is closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(q4a); // add the panel to the frame
		frame.setSize(250, 250); // set the size of the frame
		frame.setVisible(true); // make the frame visible
	}

	public static void Q4B() {
		// Create a panel that contains our drawing
		Question4B q4b = new Question4B();
	
		// Create a new frame to hold the panel
		JFrame frame  = new JFrame();
			
		// Set the frame to exit when it is closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(q4b); // add the panel to the frame
		frame.setSize(250, 250); // set the size of the frame
		frame.setVisible(true); // make the frame visible
	}

	public static void Q5A() {
		// Create a panel that contains our drawing
		Question5A q5a = new Question5A();
	
		// Create a new frame to hold the panel
		JFrame frame  = new JFrame();
			
		// Set the frame to exit when it is closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(q5a); // add the panel to the frame
		frame.setSize(250, 250); // set the size of the frame
		frame.setVisible(true); // make the frame visible
	}

	public static void Q5B() {
		// Create a panel that contains our drawing
		Question5B q5b = new Question5B();
	
		// Create a new frame to hold the panel
		JFrame frame  = new JFrame();
			
		// Set the frame to exit when it is closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(q5b); // add the panel to the frame
		frame.setSize(250, 250); // set the size of the frame
		frame.setVisible(true); // make the frame visible
	}

	public static void Q6() {
		// Create a panel that contains our drawing
		Question6 q6 = new Question6();
	
		// Create a new frame to hold the panel
		JFrame frame  = new JFrame();
			
		// Set the frame to exit when it is closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(q6); // add the panel to the frame
		frame.setSize(250, 250); // set the size of the frame
		frame.setVisible(true); // make the frame visible
	}

	public static void main(String[] args) {
		// Q1();
		// Q2();
		// Q3A();
		// Q3B();
		// Q4A();
		// Q4B();
		// Q5A();
		Q5B();
		// Q6();
	}
}