/*	Alper Akgoz 
 * 
 * 	CS 350 Assignment 2
 * 	November 7 2014
 *  Question Class
 */


import java.util.Scanner;

//Contains the question part of other children classes
public class Question implements java.io.Serializable{
	String question = new String();
	transient Scanner in = new Scanner(System.in);
	
	//Prompts the user to add a question
	public void addQuestion()
	{
		System.out.println("Enter question: ");
		question = in.nextLine();
	}
	
	//Prints the question
	public void printQuestion()
	{
		System.out.println("Question: " + question + '\n');
	}
}