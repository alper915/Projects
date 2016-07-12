import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;


public class Test extends Assessments{
	public static double userPoints = 0; 
	
	
	//Checks if the user's answers are correct
	//Increases points by 10 for every correct question
	public void grade(){
		for(int i = 0; i < q_list.size(); i++)
		{
			Question q = q_list.get(i);
			if(q.getClass() == TrueFalse.class)
			{
				TrueFalse tf = (TrueFalse) q;
				boolean answer = (boolean) user_ans_list.get(i);
				if(answer == tf.correctAns)
				{
					userPoints += 10;
				}
			}
			else if(q.getClass() == MultChoice.class)
			{
				MultChoice mc = (MultChoice) q;
				int answer = (int) user_ans_list.get(i);
				if(answer == mc.correctAns)
				{
					userPoints += 10;
				}
			}
			else if(q.getClass() == ShortAns.class)
			{
				ShortAns sa = (ShortAns) q;
				String answer = (String) user_ans_list.get(i);
				if(answer.equals(sa.correctAns))
				{
					userPoints += 10;
				}
				
			}
			else if(q.getClass() == Matching.class)
			{
				Matching match = (Matching) q;
				Map answer = (Map) user_ans_list.get(i);
				List answer_keys = new ArrayList(answer.keySet());

				int key;
				for(key = 0; key < answer_keys.size() ; key++)
				{
					if(!match.m.get(answer_keys.get(key)).equals(answer.get(answer_keys.get(key))))
					{
						key = answer_keys.size() + 1;
					}
				}

				if(key == answer_keys.size())
				{
					userPoints += 10;
				}
											
			}
			else if(q.getClass() == Ranking.class)
			{
				Ranking rank = (Ranking) q;
				List<String> answers = (ArrayList<String>) user_ans_list.get(i);
				int key;
				for(key = 0; key < answers.size() ; key++)
				{
					if(!rank.m.get(key).equals(answers.get(key)))
					{
						key = answers.size() + 1;
					}
				}

				if(key == answers.size())
				{
					userPoints += 10;
				}
				
				
			}
			
		}	
	}
}








