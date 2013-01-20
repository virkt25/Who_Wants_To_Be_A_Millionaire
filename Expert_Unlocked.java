// Import Statements
import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import layout.TableLayout;

/**
 * This class creates a Dialog which states the Expert that you have Unlocked. 
 * 
 * @author (Taranveer Virk && Gurbir Dhulla) 
 * @version (v.1 22JAN2011)
 */

public class Expert_Unlocked extends Millionaire     // name of the class
{
    // Variables Declared
    static ImagePanel ddP;

    static JPanel display = new JPanel ();

    static JDialog ddDisp = new JDialog ();

    static String introBackground = "images/ExpertUnlocked.png";

    private static double size[][] = {{TableLayout.FILL}, {0.05, 0.1, 0.5, 0.1, TableLayout.FILL}};
    private static double size3 [][] = {{0.605, 0.35, 0.05}, {0.865, 0.095, 0.1}};

    static JLabel ddL = new JLabel ("EXPERT UNLOCKED", JLabel.CENTER);
    static JLabel continueL = new JLabel ("Continue");
    static JLabel actL = new JLabel ("");
    static TransparentButton continueB = new TransparentButton ("");

    static TransparentButtonHandler handlerC = new TransparentButtonHandler ();

    /**
     * This creates the Dialog and Display it on the Screen
     */
    public static void disp () throws IOException
    {   
        dd1MP3.play();
        // Adding Button To Handler
        continueB.addActionListener (handlerC);

        //Setting Up The Labels
        ddL.setFont (new Font("Serif", Font.BOLD, 20));
        ddL.setForeground (Color.WHITE);
        continueL.setFont (new Font("Serif", Font.BOLD, 20));
        continueL.setForeground (Color.WHITE);
        actL.setFont (new Font("Serif", Font.BOLD, 20));
        actL.setForeground (Color.WHITE);
        actL.setText ("Your Expert is: " + expertName);

        // Setting properties of Main Panel  
        ddP = new ImagePanel(new ImageIcon(introBackground).getImage());
        ddP.setLayout (new TableLayout (size));
        ddP.setOpaque (false);
        ddP.setVisible (true);       

        // Setting Invisible Display Panel for Holding Button / Label
        display.setOpaque (false);
        display.setVisible (true);
        display.setLayout (new TableLayout (size3));
        ddP.add (display, "0, 0, 0, 4");
        display.add (continueB, "1, 1");
        display.add (continueL, "1, 1, c, c");

        // Adding Poll Panel to Main Poll Panel
        ddP.add (ddL, "0, 1, c, c");
        ddP.add (actL, "0, 3, c, c");

        /*
         * Setting Up the Dialog and Displaying It
         */
        {
            ddDisp.setUndecorated(true);       // Hides the Top Bar
            ddDisp.setContentPane (ddP);          // Adding Panel to Dialog
            ddDisp.pack();             // Packs the Dialog
            ddDisp.validate();      // Validates the Dialog
            ddDisp.setModal(true);
            ddDisp.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);          // Disables the Close Button  
            ddDisp.setLocationRelativeTo(null);    // Centers Panel on Screen
            ddDisp.setVisible(true);            // Makes Dialog Visible
            ddDisp.setResizable (false);     // Disables the Maximize Button :)
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
                dd1MP3.close();
                timer.start();
                ddDisp.dispose();
            }
        }
    }
}

