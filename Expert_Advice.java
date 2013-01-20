// Import Statements
import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import layout.TableLayout;

/**
 * This class displays the Expert Response for Ask An Expert Lifeline. The 
 * class determines the correct Image to display for the Expert's picture and his / her response for the question
 * user needs Help with. The response is based on the Expert's field of expertise. If it's not their field of expertise, 
 * the answer they give might not be helpful. Only Valid for Q#6 and up! -- Handled by Answer Checker.  
 * 
 * @author (Taranveer Virk && Gurbir Dhulla) 
 * @version (v.1 12JAN2011)
 */

public class Expert_Advice extends Millionaire     // name of the class
{
    // Variables Declared
    static ImagePanel expMP, expP;

    static JDialog expDisp = new JDialog ();

    static JPanel display = new JPanel ();

    static ArrayList arr = new ArrayList ();

    static String exp_img;
    static String introBackground = "images/ll_bg.png";

    static String questions [][] = new String [15][10];

    static int q, question_num;

    private static double size[][] = {{TableLayout.FILL}, {TableLayout.FILL}};
    private static double size2 [][] = {{0.15, TableLayout.FILL}, {0.3, TableLayout.FILL}};
    private static double size3 [][] = {{0.605, 0.35, 0.05}, {0.865, 0.095, 0.1}};

    static JLabel temp_label;

    static JLabel continueL = new JLabel ("Continue");

    static TransparentButton continueB = new TransparentButton ("");

    static TransparentButtonHandler handlerC = new TransparentButtonHandler ();
    static MP3 expMP3 = new MP3("audio/AskTheExpertIntro.mp3");

    /**
     * This class creates a Jdialog with the Expert's Response and display's it on the 
     * screen.
     * 
     * @param questions         Double String Array contining the question set being used for the current game.
     * @param question_num      Int containing the Question number for which the user needs help.
     * @param exp               Int containing the Expert # for the expert that was Assigned to the Player.
     */
    public static void expDisp (String [][] questions, int question_num, int exp) throws IOException
    {
        expMP3.play();      // Play Sound

        exp_img = "images/ex_"+(exp+1)+".png";      // Image Path

        // Adding Button To Handler
        continueB.addActionListener (handlerC);

        //Setting Up Labels
        continueL.setFont (new Font("Serif", Font.BOLD, 20));
        continueL.setForeground (Color.WHITE);

        // Setting properties of Main Panel  
        expMP = new ImagePanel(new ImageIcon(introBackground).getImage());
        expMP.setLayout (new TableLayout (size));
        expMP.setOpaque (false);
        expMP.setVisible (true);

        // Setting Up The Sub Panel
        expP = new ImagePanel(new ImageIcon(exp_img).getImage());
        expP.setLayout (new TableLayout (size2));
        expP.setOpaque (false);
        expP.setVisible (true);

        // Setting Invisible Display Panel for Holding Continue Button / Label
        display.setLayout (new TableLayout (size3));
        display.setOpaque (false);
        display.setVisible (true);
        display.add (continueB, "1, 1");
        display.add (continueL, "1, 1, c, c");

        // Adding Components to Main Panel
        expMP.add (expP, "0, 0");
        expMP.add (display, "0, 0");

        // Generating Expert Response
        temp_label = new JLabel("<html><div align=\"center\" style=\"width: 80%\"><p>"+expNames[exp].toUpperCase()+": "+questions[question_num][9]+"</p></div></html>");

        // Setting Response Properties and Adding to panel
        temp_label.setFont (new Font("Serif", Font.BOLD, 15));
        temp_label.setForeground (Color.WHITE);
        expP.add(temp_label, "1, "+Integer.toString(1)+", c, TOP");    

        // Dialog Box Setup and Display        
        expDisp.setUndecorated(true);       // Hides the Top Bar
        expDisp.setContentPane (expMP);          // Adding Panel to Dialog
        expDisp.pack();             // Packs the Dialog
        expDisp.validate();      // Validates the Dialog
        expDisp.setModal(true);         // Makes it Compulsory for User to go through the Dialog
        expDisp.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);          // Disables the Close Button  
        expDisp.setLocationRelativeTo(null);    // Centers Panel on Screen
        expDisp.setVisible(true);            // Makes Dialog Visible
        expDisp.setResizable (false);     // Disables the Maximize Button :)
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
                expMP3.close();             // Stops the MP3 File
                expDisp.dispose();          // Destroys the Dialog
            }
        }
    }
}

