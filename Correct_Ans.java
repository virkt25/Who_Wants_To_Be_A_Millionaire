// Import Statements
import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import layout.TableLayout;

/**
 * This class creates the correct answer dialog and displays it on the screen. 
 * 
 * @author (Taranveer Virk && Gurbir Dhulla) 
 * @version (v.1 12JAN2011)
 */

public class Correct_Ans extends Millionaire     // name of the class
{
    // Variables Declared
    static ImagePanel caP;

    static JDialog ansCDisp = new JDialog ();

    static JPanel display = new JPanel ();

    static String correctAB = "images/AnsRight.png";

    private static double size[][] = {{TableLayout.FILL}, {0.05, 0.1, 0.45, 0.1, TableLayout.FILL}};
    private static double size3 [][] = {{0.605, 0.35, 0.05}, {0.865, 0.095, 0.1}};

    static JLabel continueL = new JLabel ("Continue");
    static JLabel correctL = new JLabel ("CORRECT");
    static JLabel timeL = new JLabel ("");

    static TransparentButton continueB = new TransparentButton ("");

    static TransparentButtonHandler handlerC = new TransparentButtonHandler ();

    /**
     * This creates the Correct answer Dialog and displays it on the screen
     * 
     * @param time          An int that stores the time that the user has banked so far.
     */
    public static void correct_Ans_Disp (int time) throws IOException
    {
        // Adding Button To Handler
        continueB.addActionListener (handlerC);

        //Setting Up Labels
        continueL.setFont (new Font("Serif", Font.BOLD, 20));
        continueL.setForeground (Color.WHITE);
        correctL.setFont (new Font("Serif", Font.BOLD, 24));
        correctL.setForeground (Color.GREEN);
        timeL.setText ("You have banked " + time + " seconds");
        timeL.setFont (new Font("Serif", Font.BOLD, 20));
        timeL.setForeground (Color.WHITE);

        // Setting properties of Main Panel  
        caP = new ImagePanel(new ImageIcon(correctAB).getImage());
        caP.setLayout (new TableLayout (size));
        caP.setOpaque (false);
        caP.setVisible (true);

        // Setting Invisible Display Panel for Holding Continue Button / Label
        display.setLayout (new TableLayout (size3));
        display.setOpaque (false);
        display.setVisible (true);
        display.add (continueB, "1, 1");
        display.add (continueL, "1, 1, c, b");

        // Adding Components to Main Panel
        caP.add (display, "0, 0, 0, 4");
        caP.add (correctL, "0, 1, c, c");
        caP.add (timeL, "0, 3, c, c");        

        // Dialog Box Setup and Display        
        ansCDisp.setUndecorated(true);       // Hides the Top Bar
        ansCDisp.setContentPane (caP);          // Adding Panel to Dialog
        ansCDisp.pack();             // Packs the Dialog
        ansCDisp.validate();      // Validates the Dialog
        ansCDisp.setModal(true);        // Makes it Compulsory for User to go through the Dialog
        ansCDisp.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);          // Disables the Close Button  
        ansCDisp.setLocationRelativeTo(null);    // Centers Panel on Screen
        ansCDisp.setVisible(true);            // Makes Dialog Visible
        ansCDisp.setResizable (false);     // Disables the Maximize Button :)
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
                correctMP3.close();
                ansCDisp.dispose();
            }
        }
    }
}

