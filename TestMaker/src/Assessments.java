/*	Alper Akgoz 
 * 
 * 	CS 350 Assignment 3
 * 	November 17 2014
 *  Assessments Class
 */




import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

//Abstract class containing attributes for Test and Survey
public class Assessments implements Serializable{
	static Vector<Question> q_list = new Vector<Question>();
	static Vector<Object> user_ans_list = new Vector<Object>();

	public static double totalPoints = 0;
	
	//Sets questions for the assessment
	public void addQuestions(Vector<Question> ql)
	{
		q_list = ql;
		for(int m = 0; m < q_list.size(); m++)
		{
			Question qs = q_list.get(m);
			if(qs.getClass() != Essay.class)
			{
				totalPoints += 10;
			}
		}
	}
	
	public void takeTest(){
		Scanner input = new Scanner(System.in);
		for(int i = 0; i < q_list.size(); i++)
		{
			Question q = q_list.get(i);
			String ans = new String();
			if(q.getClass() == TrueFalse.class)
			{
				while(!ans.equals("true") && !ans.equals("false"))
				{
					q.printQuestion();
					System.out.println("Enter Answer ( true/false ): ");
					ans = input.nextLine();
					
					if(ans.equals("true"))
					{
						user_ans_list.add(true);
					}
					else if (ans.equals("false"))
					{
						user_ans_list.add(false);
					}
					else
					{
						System.out.println("Invalid Input");
					}
				}
			}
			else if(q.getClass() == MultChoice.class)
			{
				MultChoice mc = (MultChoice) q;
				mc.printQuestion();
				mc.printOptions();
				List<String> l = new ArrayList<String>();
				for(int k = 1; k < mc.options.size() + 1; k++)
				{
					l.add(Integer.toString(k));
				}
				
				while(!l.contains(ans))
				{
					System.out.println("Enter Answer ( 1,2,3 etc. ): ");
					ans = input.nextLine();
					
					if(l.contains(ans))
					{
						user_ans_list.add(Integer.parseInt(ans) - 1);
					}
					else
					{
						System.out.println("Invalid Input.");
					}
				}	
				
			}
			else if(q.getClass() == ShortAns.class)
			{
				q.printQuestion();
				System.out.println("Enter Answer: ");
				ans = input.nextLine();
				user_ans_list.add(ans);
				
			}
			else if(q.getClass() == Essay.class)
			{
				q.printQuestion();
				System.out.println("Enter Answer: ");
				ans = input.nextLine();
				user_ans_list.add(ans);
				
			}
			else if(q.getClass() == Matching.class)
			{
				Matching match = (Matching) q;
				match.printQuestion();
				match.printOptions();
				
				String choice;
				Map match_ans = new HashMap();
				System.out.println("Enter Item,Match one by one.");
	
				while(match_ans.values().size() < match.m.values().size())
				{
					choice = input.nextLine();
					choice = choice.replaceAll("\\s", "");
					String[] v = choice.split(",");
					if(match_ans.containsKey(v[0]))
					{
						System.out.println("Item already entered into answer.");
					}
					else if (match_ans.containsValue(v[1]))
					{
						System.out.println("Match already entered into answer.");
					}
					else if (!match.m.containsKey(v[0]))
					{
						System.out.println("Item does not exists.");
					}
					else if (!match.m.containsValue(v[1]))
					{
						System.out.println("Match does not exists.");
					}
					else
					{
						match_ans.put(v[0], v[1]);
					}
				}
				user_ans_list.add(match_ans);
								
			}
			else if(q.getClass() == Ranking.class)
			{
				Ranking rank = (Ranking) q;
				rank.printQuestion();
				rank.printOptions();
				
				String choice;
				System.out.println("Enter the options in incrasing order seperated by a comma: ");
				
				choice = input.nextLine();
				choice = choice.replaceAll("\\s", "");
				String[] orderedValues = choice.split(",");
				List<String> answers = new ArrayList<String>(Arrays.asList(orderedValues));
				user_ans_list.add(answers);
				
				
			}
			
		}	
	}	

}
