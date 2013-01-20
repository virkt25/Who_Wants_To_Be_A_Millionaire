// Import Statements
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import layout.TableLayout;

/**
 * This Class creates the Winner Display Panel for the Game. This panel displays the winner for the game at the end of it.
 * It shows how much money you have won.
 * 
 * @author (Taranveer Virk && Gurbiur Dhulla) 
 * @version (v.1 12JAN2011)
 */

public class Winning_Panel extends Millionaire// name of the class
{
    // Variables Declared
    private static double size2 [][] = {{0.2, 0.07, 0.48, 0.2, 0.1}, {0.66, 0.1, 0.1, 0.08}};

    static ImagePanel winP;

    static TransparentButton doneB = new TransparentButton ("");

    static JLabel doneL = new JLabel ("Main Menu");

    static TransparentButtonHandler handlerB = new TransparentButtonHandler (); 

    /**
     * This method sets up the variables and lays out the components on the Screen to create the Winning Panel
     * 
     * @return      Returns the Options Menu Panel --- ImagePanel
     */
    public static ImagePanel showPanel ()
    {
        // Initializing the Buttons and Ading them to the Button Handler
        doneB.addActionListener (handlerB);

        // Setting Properties of Options Panel
        winningBG = "images/Winning_" + bg + ".jpg";
        winP = new ImagePanel (new ImageIcon(winningBG).getImage());
        winP.setLayout (new TableLayout (size2));            
        winP.setOpaque (false);
        winP.setVisible (false);

        // Setting Font Properties of Labels - Font, Font Size, Font Style, Color.
        doneL.setFont (new Font ("Serif", Font.BOLD, 20));
        doneL.setForeground (Color.WHITE);
        winningL.setFont (new Font ("Serif", Font.BOLD, 24));
        winningL.setForeground (Color.YELLOW);

        //Adding Components to Panel
        winP.add (winningL, "0, 1, 4, 1");
        winP.add (doneB, "2, 3");
        winP.add (doneL, "2, 3, c, c");

        // Returning Panel to Main Program
        return winP;
    }

    /**
     * This class handles the events by the Buttons. Executes the Appropriate Code based on the Button clicked
     */
    private static class TransparentButtonHandler implements ActionListener 
    {
        public void actionPerformed (ActionEvent event) 
        {       
            if (event.getSource () == doneB)          // Main Menu Button
            {
                winningMP3.close();
                winner15MP3.close();

                winningP.setVisible (false);
                mainP.setVisible (true);
            } 
        }
    }
}