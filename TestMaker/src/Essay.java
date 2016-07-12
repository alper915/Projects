/*	Alper Akgoz 
 * 
 * 	CS 350 Assignment 2
 * 	November 7 2014
 *  Essay Class
 */

import java.util.Scanner;


//Child class that contains the answer to essay question
public class Essay extends Question{
	String answer;

	//Will be used when user is taking the test
	public void addAnswer()
	{
		answer = in.nextLine();
	}

}
