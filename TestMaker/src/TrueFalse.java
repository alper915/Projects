/*	Alper Akgoz 
 * 
 * 	CS 350 Assignment 2
 * 	November 7 2014
 *  TrueFalse Class
 */



import java.util.Scanner;

//Child class that contains the correct answer to true/false question
public class TrueFalse extends Question{
	boolean correctAns;
	String s;
	
	//Allows the user to set the correct answer to the question
	public void chooseCorrectAns(){
		System.out.println("Answer: ");
		correctAns = in.nextBoolean();
	}
	
	//Returns the correct answer
	//Will be used when grading the tests
	public boolean getCorrectAns(){
		return correctAns;
	}
	
	//Prints the correct answer
	//Used when user wants to display a test
	public void printCorrectAns(){
		System.out.println("Correct Answer: " + correctAns +'\n');
	}
}
