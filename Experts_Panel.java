// Import Statements
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import layout.TableLayout;

/**
 * This Class creates the options Panel for the Game. The panel gives the user the Option to change the Background.  
 * 
 * @author (Taranveer Virk && Gurbir Dhulla) 
 * @version (v.1 12JAN2011)
 */

public class Experts_Panel extends Millionaire// name of the class
{
    // Variables Declared
    private static double size4 [][] = {{0.015, TableLayout.FILL, TableLayout.FILL, 0.015}, {TableLayout.FILL, 0.09, 0.025}};

    static ImagePanel expertsP;

    static TransparentButton backEB = new TransparentButton ("");
    static TransparentButton doneEB = new TransparentButton ("");

    static JLabel backEL = new JLabel ("Back");
    static JLabel doneEL = new JLabel ("Main Menu");

    static TransparentButtonHandler handlerB = new TransparentButtonHandler (); 

    /**
     * This method sets up the variables and lays out the components on the Screen to create the Options Menu Panel.
     * 
     * @return      Returns the Options Menu Panel --- ImagePanel
     */
    public static ImagePanel showPanel ()
    {
        // Adding Button to Handler
        backEB.addActionListener (handlerB);
        doneEB.addActionListener (handlerB);

        //Setting Up JLabels
        doneEL.setFont (new Font ("Serif", Font.BOLD, 20));
        doneEL.setForeground (Color.WHITE);
        backEL.setFont (new Font ("Serif", Font.BOLD, 20));
        backEL.setForeground (Color.WHITE);

        // Setting Properties of Experts Menu Panel
        expertsBG = "images/Exp" + exp + "_" + bg + ".jpg";
        expertsP = new ImagePanel (new ImageIcon(expertsBG).getImage());
        expertsP.setLayout (new TableLayout (size4));            
        expertsP.setOpaque (false);
        expertsP.setVisible (false);

        // Adding Components (Buttons and Labels) to ImagePanel
        expertsP.add (backEL, "1, 1, c, c");
        expertsP.add (backEB, "1, 1");
        expertsP.add (doneEL, "2, 1, c, c");
        expertsP.add (doneEB, "2, 1");

        // Return Statement
        return expertsP;
    }

    /**
     * This class handles the events by the Buttons. Executes the Appropriate Code based on the Button clicked
     */
    private static class TransparentButtonHandler implements ActionListener 
    {
        public void actionPerformed (ActionEvent event) 
        {       
            // If Done, Go To Main Screen
            if (event.getSource () == doneEB)           // Main Menu Button
            {
                expertsP.setVisible (false);
                mainP.setVisible (true);
            }

            // Back One Screen
            else if (event.getSource () == backEB)      // Back Button
            {
                expertsP.setVisible (false);
                expertsMP.setVisible (true);
            }
        }
    }
}