// Import Statements
import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import layout.TableLayout;

/**
 * This class creates and displays the Confirm Answer Dialog. It gives
 * the user the option to confirm their answer -- avoid accidental button click
 * or the option to WalkAway if they are not sure of the answer. 
 * 
 * @author (Taranveer Virk && Gurbir Dhulla) 
 * @version (v.1 12JAN2011)
 */

public class Confirm_Ans extends Millionaire     // name of the class
{
    // Variables Declared
    static ImagePanel cP;

    static JDialog cDisp = new JDialog ();

    static String correctB = "images/ConfirmAnswer.jpg";

    private static double size[][] = {{0.5, 0.5}, {0.05, 0.1, 0.05, 0.1, 0.3, 0.14, 0.05, 0.17}};
    private static double size3 [][] = {{0.605, 0.35, 0.05}, {0.865, 0.095, 0.1}};

    static JLabel confirmL = new JLabel ("Are you sure the answer is:", JLabel.CENTER);
    static JLabel confirm2L = new JLabel (questions [q][3+user], JLabel.CENTER);
    static JLabel yesL = new JLabel ("YES");
    static JLabel noL = new JLabel ("NO");
    static JLabel walkAwayL = new JLabel ("WALK AWAY", JLabel.CENTER);

    static TransparentButton yesB = new TransparentButton ("");
    static TransparentButton noB = new TransparentButton ("");
    static TransparentButton walkAwayB = new TransparentButton ("");

    static TransparentButtonHandler handlerC = new TransparentButtonHandler ();

    /**
     * This class creates the Confirm Answer Dialog and displays it on the screen
     */
    public static void disp () throws IOException
    {
        // Adding Button To Handler
        yesB.addActionListener (handlerC);
        noB.addActionListener (handlerC);
        walkAwayB.addActionListener (handlerC);

        //Setting Up Labels
        confirmL.setFont (new Font("Serif", Font.BOLD, 24));
        confirmL.setForeground (Color.WHITE);
        confirm2L.setText(questions [q][3+user]);
        confirm2L.setFont (new Font("Serif", Font.BOLD, 24));
        confirm2L.setForeground (Color.WHITE);
        yesL.setFont (new Font("Serif", Font.BOLD, 20));
        yesL.setForeground (Color.WHITE);
        noL.setFont (new Font("Serif", Font.BOLD, 20));
        noL.setForeground (Color.WHITE);
        walkAwayL.setFont (new Font("Serif", Font.BOLD, 20));
        walkAwayL.setForeground (Color.WHITE);

        // Setting properties of Main Panel  
        cP = new ImagePanel(new ImageIcon(correctB).getImage());
        cP.setLayout (new TableLayout (size));
        cP.setOpaque (false);
        cP.setVisible (true);

        // Adding Components to Main Panel
        cP.add (confirmL, "0, 1, 1, 1");
        cP.add (confirm2L, "0, 3, 1, 3");
        cP.add (yesL, "0, 5, c, c"); 
        cP.add (yesB, "0, 5");
        cP.add (noL, "1, 5, c, c"); 
        cP.add (noB, "1, 5");
        cP.add (walkAwayL, "0, 7, 1, 7");
        cP.add (walkAwayB, "0, 7, 1, 7");

        // Dialog Box Setup and Display        
        cDisp.setUndecorated(true);       // Hides the Top Bar
        cDisp.setContentPane (cP);          // Adding Panel to Dialog
        cDisp.pack();             // Packs the Dialog
        cDisp.validate();      // Validates the Dialog
        cDisp.setModal(true);
        cDisp.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);          // Disables the Close Button  
        cDisp.setLocationRelativeTo(null);    // Centers Panel on Screen
        cDisp.setVisible(true);            // Makes Dialog Visible
        cDisp.setResizable (false);     // Disables the Maximize Button :)
    }

    /**
     * This class handles the events by the Buttons. Executes the Appropriate Code based on the Button clicked
     */
    private static class TransparentButtonHandler implements ActionListener 
    {
        public void actionPerformed (ActionEvent event) 
        {       
            if (event.getSource () == yesB)            // Yes Button
            {
                try
                {
                        Check_Answer.ans();
                } 
                catch (IOException e) {}
                cDisp.dispose();
            }
            
            else if (event.getSource () == noB)            // NO Button
            {
                user = 0;
                timer.start();
                cDisp.dispose();
            }
            
            else if (event.getSource () == walkAwayB)            // WalkAway Button
            {
                playPan.setVisible (false);
                winningL.setText (amount [q]);
                winningBG = "images/Winning_" + bg + ".jpg";
                winningP.update (new ImageIcon (winningBG).getImage());
                winningP.updateUI();
                winningP.setVisible (true);   
                winningMP3.play();
                cDisp.dispose();    
            }
        }
    }
}

