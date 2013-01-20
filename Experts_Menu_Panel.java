// Import Statements
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import layout.TableLayout;

/**
 * This class creates the Experts Menu Panel. The Experts Menu Panel displays Experts so you can learn more about them. 
 * 
 * @author (Taranveer Virk && Gurbir Dhulla) 
 * @version (v.1 12JAN2011)
 */

public class Experts_Menu_Panel extends Millionaire// name of the class
{
    // Variables Declared
    private static double size3 [][] = {{0.015, TableLayout.FILL, 0.015}, 
            {0.05, 0.085, 0.005, 0.08, 0.005, 0.075, 0.005, 0.08, 0.005, 0.08, 0.005, 0.08, 0.005, 0.075, 0.005, 0.08, 0.005, 0.08, 0.005, 0.08, 0.005, TableLayout.FILL, 0.005}};
            
    static int a;           // Used to add Components to the Panel
    static int exp;

    static ImagePanel expertsMP;

    static TransparentButton expB [] = new TransparentButton [10];
    
    static TransparentButton doneEMB = new TransparentButton ("");
    
    static String location [] = new String [2];
    
    static JLabel doneEML = new JLabel ("Main Menu                        ");
    
    static JLabel expL [] = new JLabel [10];
        
    static Dimension d1 = new Dimension (340, 55);
    
    static TransparentButtonHandler handlerB = new TransparentButtonHandler ();     

    /**
     * This method sets up the variables and lays out the components on the Screen to create the Experts Menu Panel.
     * 
     * @return      Returns the Experts Menu Panel --- ImagePanel
     */
    public static ImagePanel showPanel ()
    {     
        // Setting up the Buttons and Labels
        for (int x=0; x<=9; x++)
        {
            expB [x] = new TransparentButton ("");
            expB [x].addActionListener (handlerB);
            expL [x] = new JLabel (expNames [x]);
            expL [x].setFont (new Font ("Serif", Font.BOLD, 20));
            expL [x].setForeground (Color.WHITE);
        }
        doneEMB.setPreferredSize (d1);
        doneEMB.addActionListener (handlerB);
        doneEML.setFont (new Font ("Serif", Font.BOLD, 20));
        doneEML.setForeground (Color.WHITE);
        
        expertsMBG = "images/Experts_" + bg + ".jpg";           // Background 
        
        // Setting Properties of Experts Menu Panel
        expertsMBG = "images/Experts_" + bg + ".jpg";
        expertsMP = new ImagePanel (new ImageIcon(expertsMBG).getImage());
        expertsMP.setLayout (new TableLayout (size3));            
        expertsMP.setOpaque (false);
        expertsMP.setVisible (false);

        // Adding Components (Buttons and Labels) to ImagePanel
        a = 1;
        for (int x=0; x<=9; x++)
        {
            location [0] = "1, " + a + ", c, c";
            location [1] = "1, " + a;
            expertsMP.add (expL [x], location [0]);
            expertsMP.add (expB [x], location [1]);
            a = a+2;
        }            
        expertsMP.add (doneEMB, "1, 21, r, t");
        expertsMP.add (doneEML, "1, 21, r, c");

        // Return Statement
        return expertsMP;
    }

    /**
     * This class handles the events by the Buttons. Executes the Appropriate Code based on the Button clicked
     */
    private static class TransparentButtonHandler implements ActionListener 
    {
        public void actionPerformed (ActionEvent event) 
        {       
            // One of the Expert Buttons is Pressed                
            for (int x=0; x<=9; x++)
            {
                if (event.getSource () == expB [x])
                {
                    exp = x+1;
                    expertsDisp (exp);
                }
            }
            
            // The Done Button is Pressed            
            if (event.getSource () == doneEMB)
            {
                expertsMP.setVisible (false);
                mainP.setVisible (true);
            }
        }
    }
    
    /**
     * This class updates the Expert Display Panel to show the Expert that was selected.
     * It also makes the Expert Panel Visible.
     */
    private static void expertsDisp (int exp)
    {
        expertsBG = "images/Exp" + exp + "_" + bg + ".jpg";
        expertsP.update (new ImageIcon (expertsBG).getImage());
        expertsP.updateUI();
        expertsMP.setVisible (false);
        expertsP.setVisible (true);
    }
}