/*	Alper Akgoz 
 * 
 * 	CS 350 Assignment 2
 * 	November 7 2014
 *  MultChoice Class
 */


import java.util.Scanner;
import java.util.Vector;

//Child class that contains the correct answer to multiple choice question
public class MultChoice extends Question{
	
	//Choices given to the user
	Vector<String> options = new Vector<String>();
	int correctAns;
	
	//User can add as many options as possible
	public void addOption()
	{
		String o = new String();
		System.out.println("Add choices for the question. Type \"done\" when finished.");
		while(!(o.equals("done")))
		{
			o = in.nextLine();
			
			if(!(o.equals("done")))
			{
				options.add(o);
			}
			
		}
		
	}
	
	//Correct answer is decided by the position of the item in options vector
	public void chooseCorrectAns()
	{
		System.out.println("Choose the index of the correct answer: ");
		correctAns = in.nextInt();
	}
	
	//Prints options
	public void printOptions()
	{
		for(int i = 0; i < options.size(); i++)
		{
			System.out.println((i+1) + ")" + options.get(i) + '\n');
		}
		
	}
	
	//Prints the correct answer from options
	public void printCorrectAns(){
		System.out.println("Correct Answer: " + options.get(correctAns) + '\n');
	}
	
	//Retrieves the correct answer from options
	//Will be used when grading the tests
	public String getCorrectAns()
	{
		return options.get(correctAns);
	}

}
