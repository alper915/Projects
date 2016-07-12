/*	Alper Akgoz 
 * 
 * 	CS 350 Assignment 2
 * 	November 7 2014
 *  ShortAns Class
 */

import java.util.Scanner;

//Child class that contains the correct answer to short answer question
public class ShortAns extends Question{

	String correctAns;

	//Allows the user to set the correct answer to the question
	public void addCorrectAnswer(){
		System.out.println("Answer: ");
		correctAns = in.nextLine();
	}

	//Prints the correct answer
	public void printCorrectAns(){
		System.out.println("Correct Answer: " + correctAns + '\n');
	}	
	
	//Returns the correct answer
	//Will be used when grading the tests
	public String getCorrectAns()
	{
		return correctAns;
	}

}
