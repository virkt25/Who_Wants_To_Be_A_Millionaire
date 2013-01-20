// Import Statements
import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import layout.TableLayout;
import javax.swing.Timer;

/**
 * This class creates and displays the Dialog box for the User to see the Category of the Upcoming Questions and 
 * the amount it is worth and the amount they have won. 
 * 
 * @author (Taranveer Virk && Gurbir Dhulla) 
 * @version (v.1 12JAN2011)
 */

public class Category_Disp extends Millionaire      // name of the class
{
    // Variables Declared
    static ImagePanel catP;

    static JDialog catDisp = new JDialog ();

    static String catBG = "images/Category.jpg";
    
    private static double size [][] = {{0.07, TableLayout.FILL, 0.07}, {0.05, 0.09, 0.005, 0.09, 0.005, 0.09, 0.005, 0.1, 0.15, 0.175, 0.0199, 0.175}};

    static TransparentButton continueB = new TransparentButton ("");
    static TransparentButton walkAwayB = new TransparentButton ("");

    static JLabel continueL = new JLabel ("Continue");
    static JLabel walkAwayL = new JLabel ("Walk Away");
    static JLabel catL = new JLabel ("");
    static JLabel amtL = new JLabel ("");
    static JLabel bankL = new JLabel ("");

    static TransparentButtonHandler handlerC = new TransparentButtonHandler ();   

    /**
     * This method is used create the Dialog and display it on the Screen
     * 
     * @param cat       String that contains the Category of the Next Upcoming Question
     * @param amt       String Containing the Amount the Next Question is Worth
     * @param bank      String containing the Amount the user has won.
     */
    public static void disp (String cat, String amt, String bank) throws IOException
    {
        {
            // Adding Buttons to ButtonHandler
            continueB.addActionListener (handlerC);
            walkAwayB.addActionListener (handlerC);

            // Setting properties of Main Menu Panel  
            catP = new ImagePanel(new ImageIcon(catBG).getImage());
            catP.setLayout (new TableLayout (size));
            catP.setOpaque (false);
            catP.setVisible (true);

            // Setting Font Properties of Labels - Font, Font Size, Font Style, Color.
            catL.setText ("Category: " + cat);
            amtL.setText ("Amount: " + amt);
            bankL.setText ("Bank: " + bank);

            continueL.setFont (new Font("Serif", Font.BOLD, 20));
            continueL.setForeground (Color.WHITE);
            walkAwayL.setFont (new Font("Serif", Font.BOLD, 20));
            walkAwayL.setForeground (Color.WHITE);
            catL.setFont (new Font("Serif", Font.BOLD, 20));
            catL.setForeground (Color.WHITE);
            amtL.setFont (new Font("Serif", Font.BOLD, 20));
            amtL.setForeground (Color.WHITE);
            bankL.setFont (new Font("Serif", Font.BOLD, 20));
            bankL.setForeground (Color.WHITE);

            // Adding Components (Buttons and Labels) to ImagePanel
            catP.add (catL, "1, 1, c, c");
            catP.add (amtL, "1, 3, c, c");
            catP.add (bankL, "1, 7, c, c");
            catP.add (continueB, "1, 9");
            catP.add (continueL, "1, 9, c, c");
            catP.add (walkAwayB, "1, 11");
            catP.add (walkAwayL, "1, 11, c, c");
        }

        /*
         * Setting Up the Dialog and Displaying It
         */
        {
            catDisp.setUndecorated(true);       // Hides the Top Bar
            catDisp.setContentPane (catP);          // Adding Panel to Dialog
            catDisp.pack();             // Packs the Dialog
            catDisp.validate();      // Validates the Dialog
            catDisp.setModal (true);
            catDisp.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);          // Disables the Close Button  
            catDisp.setLocationRelativeTo(null);    // Centers Panel on Screen
            catDisp.setVisible(true);            // Makes Dialog Visible
            catDisp.setResizable (false);     // Disables the Maximize Button :)
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
                if (q <= 4)
                    timeRemaining = 15;
                else if (q > 4 && q <= 9)
                    timeRemaining = 30;
                else if (q > 9 && q < 14)
                    timeRemaining = 45;
                else if (q == 14)
                    timeRemaining = timeBanked;
                time.setText(String.valueOf(timeRemaining));
                timer.start();
                catDisp.dispose();
            }

            else if (event.getSource () == walkAwayB)           // Walk Away Button
            {
                user = 0;
                playPan.setVisible (false);
                winningL.setText (amount [q]);
                winningBG = "images/Winning_" + bg + ".jpg";
                winningP.update (new ImageIcon (winningBG).getImage());
                winningP.updateUI();
                winningP.setVisible (true);   
                winningMP3.play();
                catDisp.dispose();     
            }
        }
    }
}
