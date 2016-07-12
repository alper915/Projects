/*	Alper Akgoz 
 * 
 * 	CS 350 Assignment 2
 * 	November 7 2014
 *  Main Program
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;


public class main {
	//User adds questions to this list.
	static Vector<Question> current = new Vector<Question>();
	static Test t = new Test();
	static Survey s = new Survey();
	public static void main(String[] args) {
		int menu1 = 0;
		String c = new String();
		Scanner f = new Scanner(System.in);
		List<String> options = new ArrayList<String>(Arrays.asList("1","2",
		"3","4","5","6","7","8","9","10","11","12","13","14","15","16"));
		
		
		
		
		
		
		//Main Menu
		while(menu1 != 16)
		{
			
			System.out.println("1) Create a new Survey");
			System.out.println("2) Create a new Test");
			System.out.println("3) Display a Survey");
			System.out.println("4) Display a Test");
			System.out.println("5) Load a Survey");
			System.out.println("6) Load a Test ");
			System.out.println("7) Save a Survey");
			System.out.println("8) Save a Test ");
			
			System.out.println("9) Modify an Existing Survey");
			System.out.println("10) Modify an Existing Test"); 
			System.out.println("11) Take a Survey");
			System.out.println("12) Take a Test ");
			System.out.println("13) Grade a Test");
			System.out.println("14) Tabulate a Survey");
			System.out.println("15) Tabulate a Test");

			System.out.println("16) Quit");

			
			c = f.next();
			if(options.contains(c))
			{
				menu1 = Integer.parseInt(c);
				menuTwo(menu1);
			}
			else
			{
				System.out.println("Invalid Input." + '\n');
			}
			
		}
}
	
 public static class Global {
         public static String inFile = "";
         public static String inFile2 = "";
 }
 public static void menuTwo(int o)
 {
	Scanner in = new Scanner(System.in);
	
	switch(o)
	{
		//Creates a new survey by adding questions to the Vector current
		//If the vector contains question then asks if the user would like to create a new set of questions
		//Does not ask for correct answers
		case 1:
		{
				if(current.size() == 0)
				{
						
					int option1 = 0;
					
					//Loops until user decides to return to previous menu
					//User can add multiple questions of the same type
					while(option1 != 7)
					{
						System.out.println("1) Add a new T/F question" + 
						'\n' + "2) " + "Add a new multiple choice question" + 
						'\n' + "3) Add a new short answer question" + 
						'\n' + "4) Add a new essay question" + 
						'\n' + "5) Add a new ranking question " + 
						'\n' + "6) Add a new matching question" +
						'\n' + "7) Return to previous menu");
						
						option1 = in.nextInt();	
						switch(option1)
						{
							case 1:
							{
								int option2 = 1;
								do
								{
									System.out.println("New True False Question");
									TrueFalse q = new TrueFalse();
									q.addQuestion();
									current.add(q);
									
									
									System.out.println("1) Add another True False question.");
									System.out.println("2) Quit.");
									option2 = in.nextInt();
								}while(option2 != 2);					
							}
							break;
							case 2:
							{
								int option3 = 1;
								do
								{
									System.out.println("New Multiple Choice Question");
									MultChoice q = new MultChoice();
									q.addQuestion();
									q.addOption();
									current.add(q);
									
									System.out.println("1) Add another Multiple Choice question.");
									System.out.println("2) Quit.");
									option3 = in.nextInt();
								}while(option3 != 2);
								
							}
							break;
							case 3:
							{
								int option3 = 1;
								do
								{
									System.out.println("New Short Answer Question");
									ShortAns q = new ShortAns();
									q.addQuestion();
									current.add(q);
									
									System.out.println("1) Add another Short Answer question.");
									System.out.println("2) Quit.");
									option3 = in.nextInt();
								}while(option3 != 2);
								
							}
							break;
							case 4:
							{
								int option3 = 1;
								do
								{
									System.out.println("New Essay Question");
									Essay q = new Essay();
									q.addQuestion();
									current.add(q);
									
									System.out.println("1) Add another Essay question.");
									System.out.println("2) Quit.");
									option3 = in.nextInt();
								}while(option3 != 2);
								
							}
							break;
							case 5:
							{
								int option3 = 1;
								do
								{
									System.out.println("New Ranking Question");
									Ranking q = new Ranking();
									q.addQuestion();
									q.addPair();
									current.add(q);
									
									System.out.println("1) Add another Ranking question.");
									System.out.println("2) Quit.");
									option3 = in.nextInt();
								}while(option3 != 2);
								
							}
							break;
							case 6:
							{
								int option3 = 1;
								do
								{
									System.out.println("New Matching Question");
									Matching q = new Matching();
									q.addQuestion();
									q.addPair();
									current.add(q);
									
									System.out.println("1) Add another Matching question.");
									System.out.println("2) Quit.");
									option3 = in.nextInt();
								}while(option3 != 2);
								
							}
							break;
							case 7:
								return;
						}
					}
				}
				else
				{
					String c = new String();
					System.out.println("There are already questions on the current survey.");
					System.out.println("Would you like to replace it with a new one? Y/N : ");
					c = in.next();
					if(c.toLowerCase().equals("y"))
					{
						current = new Vector<Question>();
						menuTwo(1);
					}
					else
					{
						return;
					}
				}
		}
		break;
		
		//Creates a new test by adding questions to the Vector current
		//If the vector contains question then asks if the user would like to create a new set of questions
		//Asks for correct answers
		case 2:
		{
			int option1 = 0;
			
			if(current.size() == 0)
			{
				//Loops until user decides to return to previous menu
				//User can add multiple questions of the same type
				while(option1 != 7)
				{
					System.out.println("1) Add a new T/F question" + 
					'\n' + "2) " + "Add a new multiple choice question" + 
					'\n' + "3) Add a new short answer question" + 
					'\n' + "4) Add a new essay question" + 
					'\n' + "5) Add a new ranking question " + 
					'\n' + "6) Add a new matching question" +
					'\n' + "7) Return to previous menu");
					option1 = in.nextInt();	
					switch(option1)
					{
						case 1:
						{
							int option2 = 1;
							do
							{
								System.out.println("New True False Question");
								TrueFalse q = new TrueFalse();
								q.addQuestion();
								q.chooseCorrectAns();
								current.add(q);
								System.out.println("1) Add another True False question.");
								System.out.println("2) Quit.");
								option2 = in.nextInt();
							}while(option2 != 2);					
						}
						break;
						case 2:
						{
							int option3 = 1;
							do
							{
								System.out.println("New Multiple Choice Question");
								MultChoice q = new MultChoice();
								q.addQuestion();
								q.addOption();
								q.chooseCorrectAns();
								current.add(q);
								
								System.out.println("1) Add another Multiple Choice question.");
								System.out.println("2) Quit.");
								option3 = in.nextInt();
							}while(option3 != 2);
							
						}
						break;
						case 3:
						{
							int option3 = 1;
							do
							{
								System.out.println("New Short Answer Question");
								ShortAns q = new ShortAns();
								q.addQuestion();
								q.addCorrectAnswer();
								current.add(q);
								
								System.out.println("1) Add another Short Answer question.");
								System.out.println("2) Quit.");
								option3 = in.nextInt();
							}while(option3 != 2);
							
						}
						break;
						case 4:
						{
							int option3 = 1;
							do
							{
								System.out.println("New Essay Question");
								Essay q = new Essay();
								q.addQuestion();
								current.add(q);
								
								System.out.println("1) Add another Essay question.");
								System.out.println("2) Quit.");
								option3 = in.nextInt();
							}while(option3 != 2);
							
						}
						break;
						case 6:
						{
							int option3 = 1;
							do
							{
								System.out.println("New Matching Question");
								Matching q = new Matching();
								q.addQuestion();
								q.addPair();
								current.add(q);
								
								System.out.println("1) Add another Matching question.");
								System.out.println("2) Quit.");
								option3 = in.nextInt();
							}while(option3 != 2);
							
						}
						break;
						case 5:
						{
							int option3 = 1;
							do
							{
								System.out.println("New Ranking Question");
								Ranking q = new Ranking();
								q.addQuestion();
								q.addPair();
								current.add(q);
								
								System.out.println("1) Add another Ranking question.");
								System.out.println("2) Quit.");
								option3 = in.nextInt();
							}while(option3 != 2);
							
						}
						break;
						
						case 7:
							return;
					}
				}
			}
			else
			{
				String c = new String();
				System.out.println("There are already questions on the current test.");
				System.out.println("Would you like to replace it with a new one? Y/N : ");
				c = in.next();
				if(c.toLowerCase().equals("y"))
				{
					current = new Vector<Question>();
					menuTwo(2);
				}
				else
				{
					return;
				}
			}
		}
		break;
		
		//Calls the display function if the vector current contains questions
		//If it doesn't then asks if the user would like to create a new survey
		case 3:
			if(current.size() == 0)
			{
				String option = new String();
				System.out.println("Question list is empty. Create a new survey? Y\\N : ");
				option = in.nextLine();
				if(option.toLowerCase().equals("y"))
				{
					menuTwo(1);
				}
				else if(option.toLowerCase().equals("n"))
				{
					return;
				}
				else
				{
					System.out.println("Invalid input.");
					menuTwo(o);
				}
			}
			else
			{
				display(3, current);
			}
			break;
			
		//Calls the display function if the vector current contains questions
		//If it doesn't then asks if the user would like to create a new test
		case 4:
			if(current.size() == 0)
			{
				String option = new String();
				System.out.println("Question list is empty. Create a new test? Y\\N : ");
				option = in.nextLine();
				if(option.toLowerCase().equals("y"))
				{
					menuTwo(2);
				}
				else if(option.toLowerCase().equals("n"))
				{
					return;
				}
				else
				{
					System.out.println("Invalid input.");
					menuTwo(o);
				}
			}
			else
			{
				display(4, current);
			}
			break;
			
		//Loads a survey from a .ser file
		case 5:
		{
			System.out.println("Enter file name ( example.ser ): ");
			Global.inFile = in.next();

			File check = new File(Global.inFile);
			if(check.exists())
			{
				try
			      {
			         FileInputStream fileIn = new FileInputStream(Global.inFile);
			         ObjectInputStream out = new ObjectInputStream(fileIn);
			         current = (Vector<Question>) out.readObject();
			         fileIn.close();
			         System.out.println('\n' + "Survey is Loaded." + '\n');
			         s.addQuestions(current);
			         return;
			         
			      }catch(IOException i)
			      {
			         i.printStackTrace();
			         return;
			      }catch(ClassNotFoundException c)
			      {
			          System.out.println("Question class not found");
			          c.printStackTrace();
			          return;
			      }
			}
			else
			{
				System.out.println("File does not exist. Please try again." + '\n');
			}
		}
		break;
		
	//Loads a test from a .ser file
	case 6:
			System.out.println("Enter file name ( exmaple.ser ): ");
			Global.inFile2 = in.nextLine();
			File check = new File(Global.inFile2);
			if(check.exists())
			{
				try
			      {
			         FileInputStream fileIn = new FileInputStream(Global.inFile2);
			         ObjectInputStream out = new ObjectInputStream(fileIn);
			         current = (Vector<Question>) out.readObject();
			         t.addQuestions(current);
			         fileIn.close();
			         
			         System.out.println('\n' + "Test is Loaded." + '\n');
			         return;
			      }catch(IOException i)
			      {
			         i.printStackTrace();
			         return;
			      }catch(ClassNotFoundException c)
			      {
			          System.out.println("Question class not found");
			          c.printStackTrace();
			          return;
			       }			
			}
			else
			{
				System.out.println("File does not exist. Please try again." + '\n');
				
			}
			break;
		
		//Serializes the vector current
		case 7:
			if(current.size() == 0)
			{
				String option = new String();
				System.out.println("Question list is empty. Create a new survey? Y\\N : ");
				option = in.nextLine();
				if(option.toLowerCase().equals("y"))
				{
					menuTwo(1);
				}
				else if(option.toLowerCase().equals("n"))
				{
					return;
				}
				else
				{
					System.out.println("Invalid input.");
					menuTwo(o);
				}
			}
			else
			{
				String outFile = new String();
				System.out.println("Enter file name: ");
				outFile = in.next();
				
				try
			      {
				         FileOutputStream fileOut =
				         new FileOutputStream(outFile + ".ser");
				         
				         ObjectOutputStream out = new ObjectOutputStream(fileOut);
				         out.writeObject(current);
				         out.close();
				         fileOut.close();
				         System.out.printf("Saved survey data as : " + outFile + ".ser" + '\n');
					}
			      catch(IOException i)
			      {
			          i.printStackTrace();
			      }
				
			}
			
			break;
			
		//Serializes the vector current
		case 8:
			
			if(current.size() == 0)
			{
				String option = new String();
				System.out.println("Question list is empty. Create a new test? Y\\N : ");
				option = in.nextLine();
				if(option.toLowerCase().equals("y"))
				{
					menuTwo(2);
				}
				else if(option.toLowerCase().equals("n"))
				{
					return;
				}
				else
				{
					System.out.println("Invalid input.");
					menuTwo(o);
				}
			}
			else
			{
				String outFile = new String();
				System.out.println("Enter file name: ");
				outFile = in.next();

				try
			      {
			         FileOutputStream fileOut =
			         new FileOutputStream(outFile + ".ser");
			         ObjectOutputStream out = new ObjectOutputStream(fileOut);
			         out.writeObject(current);
			         out.close();
			         fileOut.close();
			         System.out.printf("Saved test data as: " + outFile + ".ser");
			      }catch(IOException i)
			      {
			          i.printStackTrace();
			      }
			}
			
			break;
		//Sets the current question list and allows user to modify the chosen question
		case 9:
			if(current.size() == 0)
			{
				System.out.println("No questions exists. Please load a survey.");
				menuTwo(5);
			}
			else
			{
				Question q = new Question();
				for(int i = 0; i < current.size(); i++)
				{
					q = current.get(i);
					System.out.print( (i+1) + ") " );
					q.printQuestion();
				}
				int n = 0;
				System.out.println("Enter the number of the question you wish to modify: ");
				n = in.nextInt() - 1;
				q = current.get(n);
				
				String choice = new String();
				System.out.println("Modify prompt? (Y/N)");
				choice = in.next();
				choice = choice.toLowerCase();
				if(choice.equals("y"))
				{
					System.out.println("Enter question: ");
					in = new Scanner(System.in);
					q.question = in.nextLine();
				}
				if(q.getClass() == MultChoice.class )
				{
					System.out.println("Modify options? (Y/N)");
					choice = in.next();
					choice = choice.toLowerCase();
					if(choice.equals("y"))
					{
						MultChoice mc = (MultChoice) q;
						for(int i = 0; i < mc.options.size(); i++)
						{
							System.out.println(i+1 + ") " + mc.options.get(i));
						}
						int m = 0;
						System.out.println("Enter the number of the option you wish to modify: ");
						m = in.nextInt() - 1;
						System.out.println("Enter new option: ");
						in = new Scanner(System.in);
						choice = in.nextLine();
						mc.options.set(m, choice);
						current.set(n, mc);
					}
				}
			}
			break;
		
			//Sets the current question list and allows user to modify the chosen question
		case 10:
			if(current.size() == 0)
			{
				System.out.println("No questions exists. Please load a survey.");
				menuTwo(5);
			}
			else
			{
				Question q = new Question();
				for(int i = 0; i < current.size(); i++)
				{
					q = current.get(i);
					System.out.print( (i+1) + ") " );
					q.printQuestion();
				}
				int n = 0;
				System.out.println("Enter the number of the question you wish to modify: ");
				n = in.nextInt() - 1;
				q = current.get(n);
				
				String choice = new String();
				System.out.println("Modify prompt? (Y/N)");
				choice = in.next();
				choice = choice.toLowerCase();
				if(choice.equals("y"))
				{
					System.out.println("Enter question: ");
					in = new Scanner(System.in);
					q.question = in.nextLine();
				}
				if(q.getClass() == MultChoice.class )
				{
					System.out.println("Modify options? (Y/N)");
					choice = in.next();
					choice = choice.toLowerCase();
					if(choice.equals("y"))
					{
						MultChoice mc = (MultChoice) q;
						Vector<String> index = new Vector<String>();
						for(int i = 0; i < mc.options.size(); i++)
						{
							System.out.println(i+1 + ") " + mc.options.get(i));
							index.addElement(Integer.toString(i));
						}
						
						String loop = new String();
						while(!loop.equals("done"))
						{
							int m = 0;
							System.out.println("Enter the number of the option you wish to modify, enter done when finished: ");
							loop = in.next();
							loop = loop.toLowerCase();
							if(index.contains(loop))
							{
								m = Integer.parseInt(loop);
								System.out.println("Enter new option: ");
								in = new Scanner(System.in);
								choice = in.nextLine();
								mc.options.set(m, choice);
							}
							else
							{
								if(!loop.equals("done"))
								{
									System.out.println("Invalid choice.");
								}
							}
						}
						System.out.println("Modify correct answer? (Y/N)");
						choice = in.next();
						choice = choice.toLowerCase();
						if(choice.equals("y"))
						{
							for(int i = 0; i < mc.options.size(); i++)
							{
								System.out.println(i+1 + ") " + mc.options.get(i));
							}
							int c = 0;
							in = new Scanner(System.in);
							System.out.println("Enter the number of the correct answer: ");
							c = in.nextInt();
							mc.correctAns = c - 1;
						}
						current.set(n, mc);
					}
				}
				else if(q.getClass() == ShortAns.class )
				{
					ShortAns s = (ShortAns) q;
					System.out.println("Modify correct answer? (Y/N)");
					choice = in.next();
					choice = choice.toLowerCase();
					if(choice.equals("y"))
					{
						System.out.println("Enter the new correct answer: ");
						String newAns = in.nextLine();
						s.correctAns = newAns;
					}
					current.set(n, s);
				}
				else if(q.getClass() == TrueFalse.class )
				{
					TrueFalse tf = (TrueFalse) q;
					System.out.println("Modify correct answer? (Y/N)");
					choice = in.next();
					choice = choice.toLowerCase();
					if(choice.equals("y"))
					{
						System.out.println("Enter the new correct answer (true/false): ");
						boolean newAns = in.nextBoolean();
						tf.correctAns = newAns;
					}
					current.set(n, tf);
				}
				else if(q.getClass() == Ranking.class )
				{
					Ranking r = (Ranking) q;
					System.out.println("Reorder options? (Y/N)");
					choice = in.next();
					choice = choice.toLowerCase();
					
					if(choice.equals("y"))
					{
						String order = new String();
						System.out.println("Enter the new correct order of options seperated by a comma: ");
						order = in.nextLine();
						order = order.replaceAll("\\s", "");
						String[] options = order.split(",");
						r.m.clear();
						for(int i = 0; i < options.length; i++)
						{
							r.m.put(i, options[i]);
						}
						
					}
					
					
				}
				else if(q.getClass() == Matching.class )
				{
					Matching match = (Matching) q;
					System.out.println("Replace a match? (Y/N)");
					choice = in.next();
					choice = choice.toLowerCase();
					ArrayList<String> keys = (ArrayList<String>) match.m.keySet();
					Vector<String> index = new Vector<String>();
					if(choice.equals("y"))
					{
						for(int i = 0; i < match.m.size(); i++)
						{
							System.out.println(i + 1 + ") " + "Key: " + keys.get(i) + " Match: " + match.m.get(keys.get(i)));
							index.addElement(Integer.toString(i));
						}
						int c = 0;
						String loop = new String();
						in = new Scanner(System.in);
						while(!loop.equals("done"))
						{
							System.out.println("Enter the number of the option you wish to replace, type done when finished: ");
							loop = in.next();
							if(index.contains(loop))
							{
								c = Integer.parseInt(loop);
								match.m.remove(keys.get(c));
								String newKey = new String();
								System.out.println("Enter new key: ");
								newKey = in.next();
								String newMatch = new String();
								System.out.println("Enter new match: ");
								newMatch = in.next();
								match.m.put(newKey, newMatch);
							}
							else
							{
								if(!loop.equals("done"))
								{
									System.out.println("Invalid choice.");
								}
							}
						}
						
						
					}
					
				}
			}
			break;
		//Allows user to take a survey by creating a survey from a serialized question list
		case 11:
			menuTwo(5);
			Survey s = new Survey();
			s.addQuestions(current);
			s.takeTest();
			Global.inFile = Global.inFile.replace(".ser", "");
			Global.inFile = Global.inFile.concat("_answers");
		
			try
		      {
			         FileOutputStream fileOut =
			         new FileOutputStream(Global.inFile + ".ser");
			         
			         ObjectOutputStream out = new ObjectOutputStream(fileOut);
			         out.writeObject(s);
			         out.close();
			         fileOut.close();
			         return;
		      }
		      catch(IOException i)
		      {
		          i.printStackTrace();
		      }
			
			
			break;
		//Allows user to take a test by creating a test from a serialized question list
		case 12:
			menuTwo(6);
			t.addQuestions(current);
			t.takeTest();
			t.grade();
			
			Global.inFile2 = Global.inFile2.replace(".ser", "");
			Global.inFile2 = Global.inFile2.concat("_answers");
			try
		      {
			         FileOutputStream fileOut =
			         new FileOutputStream(Global.inFile2 + ".ser");
			         
			         ObjectOutputStream out = new ObjectOutputStream(fileOut);
			         out.writeObject(t);
			         out.close();
			         fileOut.close();
			         return;
		      }
		      catch(IOException i)
		      {
		          i.printStackTrace();
		      }
			break;
		//Displays the Grades for the taken test
		//Works only after taking the test
		case 13:
			System.out.println("Enter file name ( example_answers.ser ): ");
			Global.inFile = in.next();

			File check_f = new File(Global.inFile);
			if(check_f.exists())
			{
				try
			      {
					 Test t_grade = new Test();
			         FileInputStream fileIn = new FileInputStream(Global.inFile);
			         ObjectInputStream out = new ObjectInputStream(fileIn);
			         t_grade = (Test) out.readObject();
			         out.close();
			         t_grade.grade();
			         System.out.println("Points Earned: " + t_grade.userPoints);
			         System.out.println("Points Possible: " + t_grade.totalPoints);
			         System.out.println("Percentage: " + ((t_grade.userPoints/t_grade.totalPoints) * 100) + "%");
			         
			         return;
			         
			      }catch(IOException i)
			      {
			         i.printStackTrace();
			         return;
			      }catch(ClassNotFoundException c)
			      {
			          System.out.println("Test class not found");
			          c.printStackTrace();
			          return;
			      }
			}
			else
			{
				System.out.println("File does not exist. Please try again." + '\n');
			}
			break;
		
		//Tabulates answers
		//Works only after taking the test
		case 14:
			tabulate();
			break;
		case 15:
			tabulate();
			break;
		default:
		break;
		}
	}



//Display function to show all questions, choices, and correct answers in a test or survey
//Uses the questions in the vector current and casts them to correct children classes to display more data.
	public static void display(int option, Vector<Question> qs){
	
	for(int i = 0; i < qs.size(); i++)
	{
		if(qs.get(i).getClass() == TrueFalse.class)
		{
			TrueFalse q = (TrueFalse) qs.get(i);
			q.printQuestion();
			if(option == 4)
			{
				q.printCorrectAns();
			}
		}
		else if(qs.get(i).getClass() == MultChoice.class)
		{
			MultChoice q = (MultChoice) qs.get(i);
			q.printQuestion();
			q.printOptions();
			if(option == 4)
			{
				q.printCorrectAns();
			}
		}
		else if(qs.get(i).getClass() == ShortAns.class)
		{
			ShortAns q = (ShortAns) qs.get(i);
			q.printQuestion();
			if(option == 4)
			{
				q.printCorrectAns();
			}
		}
		else if(qs.get(i).getClass() == Essay.class)
		{
			Essay q = (Essay) qs.get(i);
			q.printQuestion();
		}
		else if(qs.get(i).getClass() == Matching.class)
		{
			Matching q = (Matching) qs.get(i);
			q.printQuestion();
			if(option == 3)
			{
				q.printOptions();
			}
			if(option == 4)
			{
				q.printCorrectMatch();
			}
		}
		else if(qs.get(i).getClass() == Ranking.class)
		{
			Ranking q = (Ranking) qs.get(i);
			
			q.printQuestion();
			if(option == 3)
			{
				q.printOptions();
			}
			if(option == 4)
			{
				q.printCorrectOrder();
			}
				
		}
		
		}	
	}

//Tabulate function that counts the number of responses in a test
//Prints all essay answers and displays ranking and matching answers
public static void tabulate()
{
	System.out.println("Enter file name ( example_answers.ser ): ");
	Scanner in = new Scanner(System.in);
	Global.inFile = in .next();

	File check_t = new File(Global.inFile);
	if(check_t.exists())
	{
		int tCount = 0;
		int fCount = 0;
		int mCount = 0;
		int sCount = 0;
		int mrCount = 0;
		
		Test tabulate = new Test();
		try
	      {
		
	         FileInputStream fileIn = new FileInputStream(Global.inFile);
	         ObjectInputStream out = new ObjectInputStream(fileIn);
	         tabulate = (Test) out.readObject();
	         fileIn.close(); 
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	         return;
	      }catch(ClassNotFoundException c)
	      {
	          c.printStackTrace();
	          return;
	      }
		
		 for(int i = 0; i < tabulate.user_ans_list.size(); i++)
		 {
			 Object ans = tabulate.user_ans_list.get(i);
			 if(ans.equals(true))
			 {
				 tCount++;
			 }
			 else if (ans.equals(false))
			 {
				 fCount++;
			 }
			 else if (ans.getClass() == Integer.class)
			 {
				 mCount++;
			 }
			 else if (ans.getClass() == String.class && tabulate.q_list.get(i).getClass() != ShortAns.class)
			 {
				 sCount++;
			 }
			 else if (ans.getClass() == Map.class)
			 {
				 mrCount++;
			 } 
		 }
		 System.out.println("Total True Responses: " + tCount);
		 System.out.println("Total False Responses: " + fCount);
		 System.out.println("Total MultChoice Responses: " + mCount);
		 System.out.println("Total ShortAns Responses: " + sCount);
		 System.out.println("Total Matching/Ranking Responses: " + mrCount);

		 
		 int eCount = 1;
		 int rankCount = 1;
		 int matchingCount = 1;
		 for(int i = 0; i < tabulate.user_ans_list.size(); i++)
		 {
			 Object ans = tabulate.user_ans_list.get(i);
		
			 if(ans.getClass() == String.class && tabulate.q_list.get(i).getClass() != ShortAns.class)
			 {
				 System.out.println("Essay Answer" + eCount + ": ");
				 System.out.println(ans);
				 eCount++;
			 }
			 else if(ans.getClass() == Map.class && tabulate.q_list.get(i).getClass() == Ranking.class)
			 {
				 Map r = (Map) ans;
				 List keys = new ArrayList(r.keySet());
				 for(int k = 0; k < keys.size(); k++)
				 {
					System.out.println("Ranking Answer" + rankCount + ": ");
					System.out.println("Item: " + r.get(keys.get(k)).toString() + '\t' + '\t' + "Rank: " + (Integer.parseInt(keys.get(k).toString()) + 1));
				 }
						
			 }
			 else if(ans.getClass() == Map.class && tabulate.q_list.get(i).getClass() == Matching.class)
			 {
				 Map m = (Map) ans;
				 List keys = new ArrayList(m.keySet());
				 for(int k = 0; k < keys.size(); k++)
				 {
					 System.out.println("Matching Answer" + matchingCount + ": ");
					System.out.println("Item: " + m.get(keys.get(k)).toString() + '\t' + '\t' + "Match: " + keys.get(k).toString());
				 }
						
			 }
			 
		 }
		 
		 
		
	}
	else
	{
		System.out.println("File does not exist. Please try again." + '\n');
	}
	
	}
}
