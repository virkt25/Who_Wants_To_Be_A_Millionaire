// Import Statement
import java.util.*;

/**
 * This class can be used to generate Random Words and numbers. There are addiotional features for each method
 * like ensuring no two words or numbers are the same and sorting (numbers) or specifying good and bad numbers for the 
 * number generator. Please read the description of each class for more information.
 * 
 * NOTE: This class does not yet check if the required options & parameters are valid. i.e. The program can get stuck in an 
 * infinity loop if you ask it to generate more numbers / words than the parameters allow!. 
 *  Ex. Generate 10 numbers between 5-8, with no repeat numbers allowed --> The program will get stuck in a infinity loop!
 * 
 * @author (Taranveer Virk) 
 * @version (v 1.0 Dec.09, 2010)
 */

public class RandomGenerator
{  
    /**
     * The RandomGenerator Constructor
     */
    public RandomGenerator()
    {
    }
    
    // Variables Declared
    // String array storing the alphabets
    private static String alpha [] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z"};
    // int that stores the random number generated to pull a letter from the alphabet array
    private static int loc;
    // Used to store the random words generated
    private static ArrayList <String> words = new ArrayList <String> ();
    // Used to store the random numbers generated
    private static ArrayList <Integer> numbers = new ArrayList <Integer> ();
    // Used to store the good numbers 
    private static ArrayList <Integer> goodNums = new ArrayList <Integer> ();
    // Used to store the bad numbers 
    private static ArrayList <Integer> badNums = new ArrayList <Integer> ();
    // Used to Store Integers converted from the String Array
    private static ArrayList <Integer> tempInt = new ArrayList <Integer> ();
    // Used to store the random words temporarily till they are Stored in ArrayList
    private static String temp = "";
    // Used to store the random number temporarily till it is stored in the ArrayList
    private static int tempNum = 0;

    /**
     * This method generates the specified number of random words of the specified length.
     * 
     * @param numOfWords    Number of random words to be Generated
     * @param length        Length of each random word Generated
     * 
     * @return words        ArrayList <String> containing all the random words generated
     */
    public static ArrayList<String> wordGen (int numOfWords, int length)
    {
        words.clear();      // Clears the words ArrayList if it had previous content in it

        // loop runs for number of words to be generated -- used to generate all the random words
        for (int x=0; x<=numOfWords-1; x++)
        {
            // loop runs for the number of characters in each word -- used to generate 1 random word
            temp = "";
            for (int y=1; y<=length; y++)
            {
                loc = ((int)(Math.random () * 26));     // Generating a random number used to pull a character from the alphabet array
                temp = temp + alpha [loc];              // Adding the random character to the temp string
            }

            words.add (temp);                           // Adding the word stored in temp to the ArrayList
        }        

        return words;       // Returns the ArrayList after all words have been generated and Stored
    }

    /**
     * This method generates the specified number of random words of the specified length. Allows you to specify if two words can be same or not.
     * 
     * @param numOfWords    Number of random words to be Generated
     * @param length        Length of each random word Generated
     * @param notSame       If true, two random words will not be the same. If false, two random words can be the same
     * 
     * @return words        ArrayList <String> containing all the random words generated
     */
    public static ArrayList<String> wordGen (int numOfWords, int length, boolean notSame)
    {
        words.clear();      // Clears the words ArrayList if it had previous content in it

        // loop runs for number of words to be generated
        for (int x=0; x<=numOfWords-1; x++)
        { 
            // This loop runs till an acceptable word has been generated
            while (true)
            {
                // loop runs for the number of characters in each word -- used to generate 1 random word
                temp = "";
                for (int y=1; y<=length; y++)
                {
                    loc = ((int)(Math.random () * 26)); // Generating a random number used to pull a character from the alphabet array
                    temp = temp + alpha [loc];          // Adding the random character to the temp string
                }

                if (notSame == true)    // Checks to see if two words are not allowed to be same, if true then execute
                {
                    if (!words.contains (temp))     // Executes if the word generated is not already in the ArrayList
                    {
                        words.add (temp);               // Adding the word stored in temp to the ArrayList
                        break;                  // Stop the while loop
                    }
                }

                else                    // If two words can be the same, then execute
                {
                    words.add (temp);                   // Adding the word stored in temp to the ArrayList
                    break;                  // Stop the while loop
                }
            }   // while loop
        }   // for loop       

        return words;       // Returns the ArrayList after all words have been generated and Stored
    }

    /**
     * This method generates the specified number of integers between the values (min-max inclusive) specified. Numbers can be repeated.
     * 
     * @param min           The smallest number that can be generated
     * @param max           The largest number that can be generated
     * @param num           The number of integers to be generated
     * 
     * @return numbers      ArrayList <Integer> containg all the random numbers generated
     */
    public static ArrayList<Integer> numGen (int min, int max, int num)
    {
        numbers.clear();            // Used to clear the ArrayList of previous data

        // Loop runs for number of NUMBERS to be generated
        for (int x=0; x<=num-1; x++)
        {
            tempNum = (int)(Math.random()*max)+min;         // generates the random number between the specified values
            numbers.add (tempNum);              // Adds the number to the ArrayList
        }

        return numbers;         // Returns the ArrayList after all the numbers have been generated
    }

    /**
     * This method generates the specified number of integers between the values (min-max inclusive) specified. You can specify if
     * two numbers can be the same or not
     * 
     * @param min           The smallest number that can be generated
     * @param max           The largest number that can be generated
     * @param num           The number of integers to be generated
     * @param noRepeat      If true, no two random numbers generated can be the same. If false, two numbers generated can be the same.
     * 
     * @return numbers      ArrayList <Integer> containg all the random numbers generated
     */
    public static ArrayList<Integer> numGen (int min, int max, int num, boolean noRepeat)
    {
        numbers.clear();        // Used to clear the ArrayList of previous data
        // Loop runs for number of NUMBERS to be generated
        for (int x=0; x<=num-1; x++)
        {
            // This loop runs till an acceptable number has been generated
            while (true)
            {
                tempNum = (int)(Math.random()*max)+min;         // generates the random number between the specified values & stores it
                if (noRepeat == true)           // Checks to see if two numbers cannot be the same, if true then execute
                {
                    if (!numbers.contains (tempNum))  // Checks if the num generated is already in the ArrayList, execute if it doesn't exist
                    {
                        numbers.add (tempNum);     //   Add number to ArrayList
                        break;          // Stop the while loop
                    }
                }

                else  
                {
                    numbers.add (tempNum);      // Add the number to the ArrayList
                    break;      // Stop the while Loop
                }
            }   // While loop
        }   // For Loop

        return numbers;            // Returns the ArrayList after all the numbers have been generated
    }

    /**
     * This method generates the specified number of integers between the values (min-max inclusive) specified. You can specify if
     * two numbers can be the same or not. You can also specifiy if you would like the ArrayList to be sorted.
     * 
     * @param min           The smallest number that can be generated
     * @param max           The largest number that can be generated
     * @param num           The number of integers to be generated
     * @param noRepeat      If true, no two random numbers generated can be the same. If false, two numbers generated can be the same.
     * @param sort          If true, the ArrayList is sorted after all the numbers have been generated. If false, the ArrayList is not sorted.
     * 
     * @return numbers      ArrayList <Integer> containg all the random numbers generated
     */
    public static ArrayList<Integer> numGen (int min, int max, int num, boolean noRepeat, boolean sort)
    {
        numbers.clear();        // Used to clear the ArrayList of previous data

        // Loop runs for number of NUMBERS to be generated
        for (int x=0; x<=num-1; x++)
        {
            // This loop runs till an acceptable number has been generated
            while (true)
            {
                tempNum = (int)(Math.random()*max)+min;         // generates the random number between the specified values & stores it
                if (noRepeat == true)           // Checks to see if two numbers cannot be the same, if true then execute
                {
                    if (!numbers.contains (tempNum))  // Checks if the num generated is already in the ArrayList, execute if it doesn't exist
                    {
                        numbers.add (tempNum);     //   Add number to ArrayList
                        break;          // Stop the while loop
                    }
                }

                else  
                {
                    numbers.add (tempNum);      // Add the number to the ArrayList
                    break;      // Stop the while Loop
                }
            }   // While loop
        }   // For Loop

        if (sort == true)       // Checks to see if the ArrayList is to be sorted, execute if true
            sort (numbers);     // Calls the sort procedure to Sort the ArrayList

        return numbers;         // Returns the ArrayList after all the numbers have been generated
    }

    /**
     * This method generates the specified number of integers between the values (min-max inclusive) specified. You can 
     * specify if two numbers can be the same or not. You can also specifiy if you would like the ArrayList to be sorted.
     * You can also provide an Array containing good numbers to be included in the ArrayList and bad numbers to be avoided 
     * so they are not in the ArrayList
     * 
     * @param min           The smallest number that can be generated
     * @param max           The largest number that can be generated
     * @param num           The number of integers to be generated
     * @param noRepeat      If true, no two random numbers generated can be the same. If false, two numbers generated can be the same.
     * @param sort          If true, the ArrayList is sorted after all the numbers have been generated. If false, the ArrayList is not sorted.
     * @param good          An Array storing the good numbers as a String to be included in the ArrayList. Empty spots in Array should be null.
     * @param bad           An Array storing the bad numbers as a String to be excluded from the ArrayList. Empty spots in Array should be null.
     * 
     * @return numbers      ArrayList <Integer> containg all the random numbers generated
     */
    public static ArrayList<Integer> numGen (int min, int max, int num, boolean noRepeat, boolean sort, String good[], String bad)
    {
        // Clearing previous data from the ArrayLists
        numbers.clear ();
        goodNums.clear ();
        badNums.clear ();

        // Converting String to ArrayList - Method Call
        goodNums = converter(good);
        //badNums = converter (bad);

        // Loop runs for number of NUMBERS to be generated        
        for (int x=0; x<=num-1; x++)
        {
            if (x <= goodNums.size()-1 && goodNums.get(x)>= min && goodNums.get(x)<=max)
            {
                numbers.add (goodNums.get(x));
            }

            else
            {
                // This loop runs till an acceptable number has been generated
                while (true)
                {
                    tempNum = (int)(Math.random()*max)+min;         // generates the random number between the specified values & stores it

                    if (noRepeat == true && !numbers.contains (tempNum) && !bad.equals(Integer.toString(tempNum))) 
                    {
                        numbers.add (tempNum);     //   Add number to ArrayList
                        break;        // Stop the while loop   
                    }

                    else if (noRepeat == false && !badNums.contains (tempNum))     // Check to see if the number isn't part of bad array, if not part of it, execute                       
                    {
                        numbers.add (tempNum);      // Add the number to the ArrayList
                        break;      // Stop the while Loop
                    }                            
                }   // While loop
            }
        }   // For Loop

        if (sort == true)       // Checks to see if the ArrayList is to be sorted, execute if true
            sort (numbers);     // Calls the sort procedure to Sort the ArrayList

        return numbers;         // Returns the ArrayList after all the numbers have been generated
    }

    /**
     * This method is used to Sort an ArrayList in ascending order.
     * 
     * @param toBeSorted            ArrayList to be sorted
     * 
     * @return toBeSorted           Returns the sorted ArrayList
     */
    private static ArrayList <Integer> sort (ArrayList <Integer> toBeSorted)
    {
        // Sorts the ArrayList using the Collections sort
        Collections.sort (toBeSorted);
        return toBeSorted;      // Returns the Sorted ArrayList
    }

    /**
     * This method is used by the numGen class to convert the string Array containg numbers to an Integer ArrayList.
     * 
     * @param tempArray []          String containing Integers as String to be converted
     * 
     * @return temp                 Returns an ArrayList<Integer> containging the Integers from the String Array
     */
    private static ArrayList <Integer> converter (String tempArray[])
    {
        tempInt.clear();                // Clears the ArrayList
        // Loop runs for the length of the Array containing the numbers as String
        for (int x=0; x<=tempArray.length-1; x++)
        {
            if (tempArray[x] != null)           // If the Array is not Empty - Convert to Integer & save in ArrayList
            {
                tempInt.add (Integer.parseInt (tempArray[x]));
            }
        }

        return tempInt;         // Returns the ArrayList containing the converted numbers.
    }
}
