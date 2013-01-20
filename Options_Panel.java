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

public class Options_Panel extends Millionaire// name of the class
{
    // Variables Declared
    private static double size2 [][] = {{0.12, 0.2475, 0.13, 0.12, 0.2475, 0.115}, {0.425, 0.14, 0.25, 0.066, 0.09}};
    
    static ImagePanel optionsP;
    
    static TransparentButton doneOMB = new TransparentButton ("");
    
    static TransparentButton bgB [] = new TransparentButton [2];
    
    static JLabel bgTitleL = new JLabel ("Background Selector");
    static JLabel doneOML = new JLabel ("                         Main Menu");

    static TransparentButtonHandler handlerB = new TransparentButtonHandler (); 

    /**
     * This method sets up the variables and lays out the components on the Screen to create the Options Menu Panel.
     * 
     * @return      Returns the Options Menu Panel --- ImagePanel
     */
    public static ImagePanel showPanel ()
    {
        // Initializing the Buttons and Ading them to the Button Handler
        for (int x=0; x<=1; x++)
        {
            bgB [x] = new TransparentButton ("");
            bgB [x].addActionListener (handlerB);
        }
        doneOMB.addActionListener (handlerB);

        // Setting Properties of Options Panel
        optionsBG = "images/BGSelector_" + bg + ".jpg";
        optionsP = new ImagePanel (new ImageIcon(optionsBG).getImage());
        optionsP.setLayout (new TableLayout (size2));            
        optionsP.setOpaque (false);
        optionsP.setVisible (false);

        // Setting Font Properties of Labels - Font, Font Size, Font Style, Color.
        doneOML.setFont (new Font ("Serif", Font.BOLD, 20));
        doneOML.setForeground (Color.WHITE);
        bgTitleL.setFont (new Font ("Serif", Font.BOLD, 24));
        bgTitleL.setForeground (Color.WHITE);

        //Setting Button Property
        bgB [0].setOpaque (false);
        bgB [1].setOpaque (false);

        //Adding Components to Panel
        optionsP.add (bgTitleL, "2, 1, 4, 1");
        optionsP.add (doneOMB, "3, 4, 5, 4");
        optionsP.add (bgB[0], "1, 2");
        optionsP.add (bgB[1], "4, 2");
        optionsP.add (doneOML, "3, 4, 5, 4");

        // Returning Panel to Main Program
        return optionsP;
    }

    /**
     * This class handles the events by the Buttons. Executes the Appropriate Code based on the Button clicked
     */
    private static class TransparentButtonHandler implements ActionListener 
    {
        public void actionPerformed (ActionEvent event) 
        {       
            // Play Button is Pressed, Execute
            if (event.getSource () == doneOMB)          // Main Menu Button
            {
                optionsP.setVisible (false);
                mainP.setVisible (true);
            } 

            else if (event.getSource () == bgB [0])         // Background 1 Button - Light Background
            {
                bg=1;
                optionsBG = ("images/BGSelector_" + bg + ".jpg");
                optionsP.update (new ImageIcon (optionsBG).getImage());
                introBackground = ("images/introBackground_" + bg + ".jpg");
                mainP.update (new ImageIcon (introBackground).getImage());
                display.updateUI ();
            }

            else if (event.getSource () == bgB [1])         // Background 2 Button - Dark Background
            {
                bg=2;
                optionsBG = ("images/BGSelector_" + bg + ".jpg");
                optionsP.update (new ImageIcon (optionsBG).getImage());
                introBackground = ("images/introBackground_" + bg + ".jpg");
                mainP.update (new ImageIcon (introBackground).getImage());
                display.updateUI ();
            }
        }
    }
}