// Import Statements
import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import layout.TableLayout;

/**
 * This clas creates the Dislog for Wrong Answer.  
 * 
 * @author (Taranveer Virk && Gurbir Dhulla) 
 * @version (v.1 12JAN2011)
 */

public class Wrong_Ans extends Millionaire     // name of the class
{
    // Variables Declared
    static ImagePanel waP;

    static JDialog ansWDisp = new JDialog ();

    static JPanel display = new JPanel ();

    static String correctAB = "images/AnsWRONG.png";

    private static double size[][] = {{TableLayout.FILL}, {0.05, 0.1, 0.45, 0.1, TableLayout.FILL}};
    private static double size3 [][] = {{0.605, 0.35, 0.05}, {0.865, 0.095, 0.1}};

    static JLabel continueL = new JLabel ("Continue");
    static JLabel wrongL = new JLabel ("WRONG");

    static TransparentButton continueB = new TransparentButton ("");

    static TransparentButtonHandler handlerC = new TransparentButtonHandler ();

    /**
     * This class creates the dialog and displays it on the screen.
     */
    public static void wrong_Ans_Disp () throws IOException
    {
        // Adding Button To Handler
        continueB.addActionListener (handlerC);

        //Setting Up Labels
        continueL.setFont (new Font("Serif", Font.BOLD, 20));
        continueL.setForeground (Color.WHITE);
        wrongL.setFont (new Font("Serif", Font.BOLD, 24));
        wrongL.setForeground (Color.RED);

        // Setting properties of Main Panel  
        waP = new ImagePanel(new ImageIcon(correctAB).getImage());
        waP.setLayout (new TableLayout (size));
        waP.setOpaque (false);
        waP.setVisible (true);

        // Setting Invisible Display Panel for Holding Continue Button / Label
        display.setLayout (new TableLayout (size3));
        display.setOpaque (false);
        display.setVisible (true);
        display.add (continueB, "1, 1");
        display.add (continueL, "1, 1, c, b");

        // Adding Components to Main Panel
        waP.add (display, "0, 0, 0, 4");
        waP.add (wrongL, "0, 1, c, c");

        // Dialog Box Setup and Display        
        ansWDisp.setUndecorated(true);       // Hides the Top Bar
        ansWDisp.setContentPane (waP);          // Adding Panel to Dialog
        ansWDisp.pack();             // Packs the Dialog
        ansWDisp.validate();      // Validates the Dialog
        ansWDisp.setModal(true);
        ansWDisp.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);          // Disables the Close Button  
        ansWDisp.setLocationRelativeTo(null);    // Centers Panel on Screen
        ansWDisp.setVisible(true);            // Makes Dialog Visible
        ansWDisp.setResizable (false);     // Disables the Maximize Button :)
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
                wrongMP3.close();
                playPan.setVisible (false);
                if (q < 4)
                    winningL.setText (amount [0]);
                else if (q > 4 && q < 9)
                    winningL.setText (amount [5]);
                else if (q > 9 && q < 14)
                    winningL.setText (amount [10]);
                else if (q == 14)
                    winningL.setText (amount [15]);
                winningL.setVisible (true);
                winningBG = "images/Winning_" + bg + ".jpg";
                winningP.update (new ImageIcon (winningBG).getImage());
                winningP.setVisible (true);
                
                winningMP3.play();
                ansWDisp.dispose();                
            }
        }
    }
}

