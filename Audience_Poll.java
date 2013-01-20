// Import Statements
import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import layout.TableLayout;

/**
 * This class displays a JDialog to display the Audience Poll Results in. This class
 * calculates and determins the correct answer and creates the graph based on 
 * diffculty. 
 * 
 * @author (Taranveer Virk && Gurbir Dhulla) 
 * @version (v.1 12JAN2011)
 */

public class Audience_Poll extends Millionaire     // name of the class
{
    // Variables Declared
    static ImagePanel pollMP, pollP;

    static JPanel display = new JPanel ();

    static JDialog pollDisp = new JDialog ();

    static ArrayList arr = new ArrayList ();

    static String introBackground = "images/ll_bg.png";
    static String poll = "images/poll.png";    
    static String temp_pos = "";
    static String bad_arr;

    static String good_arr[] = new String [1];

    static int q, count;

    private static double size[][] = {{0.295, TableLayout.FILL, 0.295}, {0.19, 0.81, 0.015, 0.09, 0.025, 0.09, 0.025, 0.09}};
    private static double size2 [][] = {{0.11, 0.18, 0.21, 0.21, 0.20}, {TableLayout.FILL, 0.395}};
    private static double size3 [][] = {{0.605, 0.35, 0.05}, {0.6455, 0.08, 0.1}};

    static JLabel[][] poll_arr = new JLabel [4][5];

    static JLabel pollL = new JLabel ("Audience Poll", JLabel.CENTER);
    static JLabel continueL = new JLabel ("Continue");
    static TransparentButton continueB = new TransparentButton ("");

    static TransparentButtonHandler handlerC = new TransparentButtonHandler ();
    
    /**
     * This class creates the JDialog and Displays it on the Screen.
     * 
     * @param questions         A double String that contains the questions that are being used for the current game play.
     * @param question_num      An int that tells the current question number with which the user needs help.
     */
    public static void pollDisp (String [][] questions, int question_num) throws IOException
    {   
        audienceMP3.play();
        
        // Addiong Button To Handler
        continueB.addActionListener (handlerC);

        //Setting Up The Labels
        pollL.setFont (new Font("Serif", Font.BOLD, 20));
        pollL.setForeground (Color.WHITE);
        continueL.setFont (new Font("Serif", Font.BOLD, 20));
        continueL.setForeground (Color.WHITE);

        // Setting properties of Main Panel  
        pollMP = new ImagePanel(new ImageIcon(introBackground).getImage());
        pollMP.setLayout (new TableLayout (size));
        pollMP.setOpaque (false);
        pollMP.setVisible (true);

        //Setting Properties of Sub Panel 
        pollP = new ImagePanel(new ImageIcon(poll).getImage());
        pollP.setLayout (new TableLayout (size2));
        pollP.setOpaque (false);
        pollP.setVisible (true);       

        // Setting Invisible Display Panel for Holding Button / Label
        display.setOpaque (false);
        display.setVisible (true);
        display.setLayout (new TableLayout (size3));
        pollMP.add (display, "0, 0, 2, 7");
        display.add (continueB, "1, 1");
        display.add (continueL, "1, 1, c, c");

        // Adding Poll Panel to Main Poll Panel
        pollMP.add (pollP, "1, 1");
        pollMP.add (pollL, "0, 0, 2, 0");

        // Assigning Images to Array - Labels
        for (int x=1; x<=3; x++)
        {
            for (int y = 1; y<=4; y++)
            {
                poll_arr[x][y] = new JLabel(new ImageIcon("images/poll_"+(x)+"_"+(y)+".png"));
            }
        }

        // Generating the Graph
        if (questions[question_num][2].equals("1") || questions[question_num][2].equals("2"))
            q = 1;

        else if (questions[question_num][2].equals("3") || questions[question_num][2].equals("4"))
            q = 2;

        else if (questions[question_num][2].equals("5") || questions[question_num][2].equals("6"))
            q = 3;

        // Adding Correct Answer Bar to Graph
        pollP.add(poll_arr[q][1], questions[question_num][8]+", 0, c, B");

        // Storing Answer to String
        bad_arr = questions[question_num][8];

        // Generating Random Number for the Remaining Bars
        arr = RandomGenerator.numGen(1, 4, 3, true, false, good_arr, bad_arr  );

        // This Loop Runs to Add the Remaining Bars to the Graph
        count = 2;
        for (int y = 0; y<=2; y++)
        {
            temp_pos = arr.get(y)+"";
            pollP.add(poll_arr[q][count], temp_pos+",0, c, B");
            count++;
        }

        /*
         * Setting Up the Dialog and Displaying It
         */
        {
            pollDisp.setUndecorated(true);       // Hides the Top Bar
            pollDisp.setContentPane (pollMP);          // Adding Panel to Dialog
            pollDisp.pack();             // Packs the Dialog
            pollDisp.validate();      // Validates the Dialog
            pollDisp.setModal(true);        // Makes it necessary to go through this Dialog 
            pollDisp.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);          // Disables the Close Button  
            pollDisp.setLocationRelativeTo(null);    // Centers Panel on Screen
            pollDisp.setVisible(true);            // Makes Dialog Visible
            pollDisp.setResizable (false);     // Disables the Maximize Button :)
        } 
    }

    /**
     * This class handles the events by the Buttons. Executes the Appropriate Code based on the Button clicked
     */
    private static class TransparentButtonHandler implements ActionListener 
    {
        public void actionPerformed (ActionEvent event) 
        {       
            if (event.getSource () == continueB)            // Continue Button
            {
                audienceMP3.close();            // Stop the Music
                pollDisp.dispose();             // Destroy the Dialog
            }
        }
    }
}

