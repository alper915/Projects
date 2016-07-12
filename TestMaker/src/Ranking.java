/*	Alper Akgoz 
 * 
 * 	CS 350 Assignment 2
 * 	November 7 2014
 *  Ranking Class
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//Child class that contains the correct order to ranking question
public class Ranking extends Question{
	Map m = new HashMap();
	String p1 = "";
	
	//Allows user to add items in increasing rank
	public void addPair(){
		
		System.out.println("Enter items in increasing rank.");
		System.out.println("Enter done when finished.");		
		int rank = 0;
		while(!p1.equals("done"))
		{	
			p1 = in.nextLine();
			if(!p1.equals("done"))
			{
				if(!m.values().contains(p1))
				{
					m.put(rank, p1);
					rank++;
				}
				else
				{
					System.out.println("Item already exists.");
				}
				
			}
		}
	}
	
	//Prints items and rankings in a randomized way
	public void printOptions()
	{
		List randKeys = new ArrayList(m.keySet());
		Collections.shuffle(randKeys);
		
		List keys = new ArrayList(m.keySet());
		Collections.shuffle(keys);
		for(int i = 0; i < randKeys.size(); i++)
	
		{
			System.out.println(m.get(randKeys.get(i)).toString() + '\t' + '\t' + (Integer.parseInt(keys.get(i).toString()) + 1));
		}
		
	}
	
	//Prints the correct ranking order of items
	public void printCorrectOrder(){
		String items = new String();
		for(int i = 0; i < m.size(); i++)
		{
			if(i == m.size() - 1)
			{
				items += m.get(i);
			}
			else
			{
				items += m.get(i) + ", ";
			}
		}
		System.out.println("Correct Order: " + items + '\n');
		
	}

	
}
