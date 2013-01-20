// Import Statements
import java.io.*;
import java.util.*;

/**
 * This class is used to read a text file, pick 14 random questions and an expert and store all the data in an Array.
 * 
 * Questions Levels in File
 * Level 1 - # 1 - 225      Game Questions # 1 & 2
 * Level 2 - # 226 - 375    Game Questions # 3 - 5
 * Level 3 - # 376 - 592    Game Questions # 6 & 7
 * Level 4 - # 593 - 709    Game Questions # 8 - 10
 * Level 5 - # 710 - 857    Game Questions # 11 & 12
 * Level 6 - # 858 - 892    Game Questions # 13 - 15
 * 
 * Data Stored in Array (ORDER)
 * Question #, Category, Difficulty, Question, Option A, Option B, Option C, Option D, Answer, Expert Response (after the $1000 question) 
 * 
 * @author (Taranveer Virk) 
 * @version (v.1 10JAN2010)
 */

public class QuestionReader extends Millionaire     // name of the class
{
    // Variables Declared
    private static int [] numbers = new int [15];
    
    private static int min, max, tempNum, a, q;
    
    private static String temp;

    static String info [] = new String [9];

    /**
     * The main method of the QuestionReaader class. This method automatically generates the appropriate number of questions for each Level (easiest to hardest) and 
     * stores them in an Array. An expert is also selected and his/her responses are stored in the Array as well.
     * 
     * @return (questions)      Returns a Double Array Holding the Data from the File
     */
    public static void main () throws IOException, NullPointerException
    {
        a = 0;      // default value

        for (int x=0; x<=1; x++)        // Loop runs to generate Lv. 1, 3, 5 questions.
        {
            numGen (1, 225);
            a++;
            numGen (376, 592);
            a++;
            numGen (710, 857);
            a++;
        }

        for (int x=0; x<=2; x++)        // Loop runs to generate Lv. 2, 4, 6 questions.
        {
            numGen (226, 375);
            a++;
            numGen (593, 709);
            a++;
            numGen (858, 892);
            a++;
        }

        Arrays.sort (numbers);          // Sorts the array Storing the questions number

        expert = (int)((Math.random()*10));           // Generates an expert number
        expertName = expNames[expert];

        // opening a channel for input from the keyboard
        BufferedReader c = new BufferedReader(new FileReader("Questions.txt"));
        temp = null;        // default value;
        q = 0;          // default value

        //read each line of text file & store the ones to be used in an array
        for (int x=1; x<=892; x++)
        {
            temp = c.readLine (); 
            if (q > 14)
                break;

            else if (x == numbers [q])
            {

                try
                {
                    info = temp.split (";");
                }
                catch (NullPointerException r)
                {
                    System.out.println ("OOOPS ... you just won a Million Dollars because of");
                    System.out.println ("an error in the game.");
                    System.out.println ("Congratulations, but please read on ...");
                    System.out.println ();
                    System.out.println ("ACTUALLY .... ");
                    System.out.println ("There has been a little problem, ");
                    System.out.println ("Sorry for any inconvenience but you should restart the ");
                    System.out.println ("game to avoid more problems if you continue playing.");
                    System.out.println ("                   OR");
                    System.out.println ("Stop the Game you are playing (Use the Walk Away Button)");
                    System.out.println ("And press play again.");
                    System.out.println ();
                    System.out.println ("Thankyou");
                }
                catch (ArrayIndexOutOfBoundsException t)
                {
                    System.out.println ("OOOPS ... you just won a Million Dollars because of");
                    System.out.println ("an error in the game.");
                    System.out.println ("Congratulations, but please read on ...");
                    System.out.println ();
                    System.out.println ("ACTUALLY .... ");
                    System.out.println ("There has been a little problem, ");
                    System.out.println ("Sorry for any inconvenience but you should restart the ");
                    System.out.println ("game to avoid more problems if you continue playing.");
                    System.out.println ("                   OR");
                    System.out.println ("Stop the Game you are playing (Use the Walk Away Button)");
                    System.out.println ("And press play again.");
                    System.out.println ();
                    System.out.println ("Thankyou");
                }

                for (int y=0; y<=8; y++)
                {
                    try 
                    {
                        questions [q][y] = info [y];
                    }
                    catch (NullPointerException e)
                    {
                        System.out.println ("OOOPS ... you just won a Million Dollars because of");
                        System.out.println ("an error in the game.");
                        System.out.println ("Congratulations, but please read on ...");
                        System.out.println ();
                        System.out.println ("ACTUALLY .... ");
                        System.out.println ("There has been a little problem, ");
                        System.out.println ("Sorry for any inconvenience but you should restart the ");
                        System.out.println ("game to avoid more problems if you continue playing.");
                        System.out.println ("                   OR");
                        System.out.println ("Stop the Game you are playing (Use the Walk Away Button)");
                        System.out.println ("And press play again.");
                        System.out.println ();
                        System.out.println ("Thankyou");
                    }
                }
                if (numbers [q] > 375)          // Stores the response of your expert.
                    questions [q][9] = info [8+expert];
                q++;
            }
        }
    }

    /**
     * This method generates an int between the specified values and if it is not already in the array, it stores it there.
     * 
     * @param min           The smallest number that can be generated
     * @param max           The largest number that can be generated
     */
    private static void numGen (int min, int max)
    {
        // This loop runs till an acceptable number has been generated
        while (true)
        {
            tempNum = min + (int)(Math.random()*((max-min)+1));         // generates the random number between the specified values & stores it
            if ((Arrays.binarySearch(numbers,tempNum))<0)  // Checks if the num generated is already in the Array, execute if it doesn't exist
            {
                numbers [a] = (tempNum);     //   Add number to Array
                break;          // Stop the while loop
            }
        }   // While loop
    } 
}