// Import Statements
import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import layout.TableLayout;

/**
 * This is the class to Create and display the Out of Time Dialog. 
 * 
 * @author (Taranveer Virk && Gurbir Dhulla) 
 * @version (v.1 20JAN2011)
 */

public class OutOfTime extends Millionaire     // name of the class
{
    // Variables Declared
    static ImagePanel tP;

    static JDialog tDisp = new JDialog ();

    static JPanel display = new JPanel ();

    static String correctAB = "images/AnsWRONG.png";

    private static double size[][] = {{TableLayout.FILL}, {0.05, 0.1, 0.45, 0.1, TableLayout.FILL}};
    private static double size3 [][] = {{0.605, 0.35, 0.05}, {0.865, 0.095, 0.1}};

    static JLabel continueL = new JLabel ("Continue");
    static JLabel wrongL = new JLabel ("OUT OF TIME");
    static JLabel bL = new JLabel ("Better Luck Next Time");

    static TransparentButton continueB = new TransparentButton ("");

    static TransparentButtonHandler handlerC = new TransparentButtonHandler ();

    /**
     * This method creates and displays the Out of Time Dialog.
     */
    public static void disp () throws IOException
    {
        // Adding Button To Handler
        continueB.addActionListener (handlerC);

        //Setting Up Labels
        continueL.setFont (new Font("Serif", Font.BOLD, 20));
        continueL.setForeground (Color.WHITE);
        wrongL.setFont (new Font("Serif", Font.BOLD, 24));
        wrongL.setForeground (Color.RED);
        bL.setFont (new Font("Serif", Font.BOLD, 24));
        bL.setForeground (Color.WHITE);

        // Setting properties of Main Panel  
        tP = new ImagePanel(new ImageIcon(correctAB).getImage());
        tP.setLayout (new TableLayout (size));
        tP.setOpaque (false);
        tP.setVisible (true);

        // Setting Invisible Display Panel for Holding Continue Button / Label
        display.setLayout (new TableLayout (size3));
        display.setOpaque (false);
        display.setVisible (true);
        display.add (continueB, "1, 1");
        display.add (continueL, "1, 1, c, b");

        // Adding Components to Main Panel
        tP.add (display, "0, 0, 0, 4");
        tP.add (wrongL, "0, 1, c, c");
        tP.add (bL, "0, 3, c, c");

        // Dialog Box Setup and Display        
        tDisp.setUndecorated(true);       // Hides the Top Bar
        tDisp.setContentPane (tP);          // Adding Panel to Dialog
        tDisp.pack();             // Packs the Dialog
        tDisp.validate();      // Validates the Dialog
        tDisp.setModal(true);
        tDisp.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);          // Disables the Close Button  
        tDisp.setLocationRelativeTo(null);    // Centers Panel on Screen
        tDisp.setVisible(true);            // Makes Dialog Visible
        tDisp.setResizable (false);     // Disables the Maximize Button :)
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
                playPan.setVisible (false);
                
                // Setting The Amount the User has Won
                if (q < 4)
                    winningL.setText (amount [0]);
                else if (q > 4 && q < 9)
                    winningL.setText (amount [5]);
                else if (q > 9 && q < 14)
                    winningL.setText (amount [10]);
                else if (q == 14)
                    winningL.setText (amount [14]);
                winningL.setVisible (true);
                winningBG = "images/Winning_" + bg + ".jpg";
                winningP.update (new ImageIcon (winningBG).getImage());
                winningP.setVisible (true);
                winningMP3.play();
                winningP.setVisible (true);
                tDisp.dispose();                
            }
        }
    }
}

