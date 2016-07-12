/*	Alper Akgoz 
 * 
 * 	CS 350 Assignment 2
 * 	November 7 2014
 *  Matching Class
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//Child class that contains the correct pairing to matching question
public class Matching extends Question{
	Map m = new HashMap();
	String p1 = "";
	
	//Allows user to add an item with its correct match
	public void addPair(){
		
		System.out.println("Enter options in Item,Match format.");
		System.out.println("Enter done when finished.");		
		while(!p1.equals("done"))
		{	
			p1 = in.nextLine();
			p1 = p1.replaceAll("\\s", "");
			String[] p2 = p1.split(",");
			if(!p1.equals("done"))
			{
				if(!m.values().contains(p2[0]) || !m.keySet().contains(p2[1]))
				{
					m.put(p2[0], p2[1]);
				}
				else
				{
					System.out.println("Item or Match already exists.");
				}
				
			}
		}
	}

	//Prints items and their matches in a randomized way
	public void printOptions()
	{
		List randKeys = new ArrayList(m.keySet());
		Collections.shuffle(randKeys);
		
		List keys = new ArrayList(m.keySet());
		Collections.shuffle(keys);
		for(int i = 0; i < randKeys.size(); i++)
	
		{
			System.out.println(m.get(randKeys.get(i)).toString() + '\t' + '\t' + keys.get(i));
		}
		
	}
	
	//Prints the correct matching of items
	public void printCorrectMatch(){
		List keys = new ArrayList(m.keySet());
		System.out.println("Correct pairing: " + '\n');
		System.out.println('\t' + "Item" + " <-----> " + "Match" + '\n');
		for(int i = 0; i < keys.size(); i++)
			
		{
			System.out.println('\t' + m.get(keys.get(i)).toString() + " <-----> " + keys.get(i) + '\n');
		}		
			
			
	}


}
