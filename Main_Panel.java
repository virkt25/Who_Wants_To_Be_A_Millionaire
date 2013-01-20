// Import Statements
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import layout.TableLayout;

/**
 * This Class creates the Main Menu Panel for the Game. This Panel displays the Main Menu for the Game
 * 
 * @author (Taranveer Virk && Gurbir Dhulla) 
 * @version (v.1 12JAN2011)
 */

public class Main_Panel extends Millionaire         // name of the class
{
    // Variables Declared
    private static double size [][] = {{0.265, TableLayout.FILL, 0.26}, {0.51, 0.09, 0.015, 0.09, 0.025, 0.09, 0.025, 0.09}};

    static ImagePanel mainP;

    static TransparentButton playB = new TransparentButton ("");
    static TransparentButton optionsB = new TransparentButton ("");
    static TransparentButton exitB = new TransparentButton ("");
    static TransparentButton expertsB = new TransparentButton ("");

    static JLabel playL = new JLabel ("Play");
    static JLabel optionsL = new JLabel ("Options");
    static JLabel exitL = new JLabel ("Exit");
    static JLabel expertsL = new JLabel ("About the Experts");

    static TransparentButtonHandler handlerB = new TransparentButtonHandler (); 

    /**
     * This method sets up the variables and lays out the components on the Screen to create the Main Menu Panel.
     * 
     * @return mainP            Returns the Main Menu Panel --- ImagePanel
     */
    public static ImagePanel showPanel ()
    {
        introMP3.play();

        //         // Disabling the buttons
        //         playB.setEnabled (false);
        //         optionsB.setEnabled (false);
        //         helpB.setEnabled (false);
        //         expertsB.setEnabled (false);

        //         try 
        //         {
        //             Thread.sleep(2500); // do nothing for 1000 miliseconds (1 second)
        //         } 
        //         catch(InterruptedException e)
        //         {
        //             e.printStackTrace();
        //         }

        // Enabling the buttons
        playB.setEnabled (true);
        optionsB.setEnabled (true);
        exitB.setEnabled (true);
        expertsB.setEnabled (true);

        // Adding Buttons to ButtonHandler
        playB.addActionListener (handlerB);
        optionsB.addActionListener (handlerB);
        exitB.addActionListener (handlerB);
        expertsB.addActionListener (handlerB);

        // Setting properties of Main Menu Panel  
        introBackground = "images/IntroBackground_" + bg + ".jpg";
        mainP = new ImagePanel(new ImageIcon(introBackground).getImage());
        mainP.setLayout (new TableLayout (size));
        mainP.setOpaque (false);
        mainP.setVisible (true);

        // Setting Font Properties of Labels - Font, Font Size, Font Style, Color.
        playL.setFont (new Font("Serif", Font.BOLD, 20));
        playL.setForeground (Color.WHITE);
        optionsL.setFont (new Font("Serif", Font.BOLD, 20));
        optionsL.setForeground (Color.WHITE);
        exitL.setFont (new Font("Serif", Font.BOLD, 20));
        exitL.setForeground (Color.WHITE);
        expertsL.setFont (new Font("Serif", Font.BOLD, 20));
        expertsL.setForeground (Color.WHITE);  

        // Adding Components (Buttons and Labels) to ImagePanel
        mainP.add (playL, "1, 1, c, c");
        mainP.add (playB, "1, 1");
        mainP.add (optionsB, "1, 3");
        mainP.add (optionsL, "1, 3, c, c");
        mainP.add (exitB, "1, 7");
        mainP.add (exitL, "1, 7, c, c");
        mainP.add (expertsB, "1, 5");
        mainP.add (expertsL, "1, 5, c, c");

        // Return Statement
        return mainP;
    }

    /**
     * This class handles the events by the Buttons. Executes the Appropriate Code based on the Button clicked
     */
    private static class TransparentButtonHandler implements ActionListener 
    {
        public void actionPerformed (ActionEvent event) 
        {       
            // Play Button is Pressed, Execute
            if (event.getSource () == playB) 
            {
                //Stopping Sound
                introMP3.close();
                winningMP3.close();
                winner15MP3.close();

                // Setting Variable Properties
                for (int x=0; x<=14; x++)
                {
                    xL [x].setVisible (false);
                }                
                for (int x=0; x<=3; x++)
                {
                    cross [x].setVisible (false);
                    lifeB [x].setEnabled (true);
                }
                lifeB [3].setEnabled (false);
                dExp.setVisible (true);
                mainP.setVisible (false);     
                
                // Resetting Variables to default Values
                q = 0;
                r = 0;
                w = 0;
                timeBanked = 0;
                ddLL = false;
                qtry = 0;

                //Reading the Questions File
                try
                {
                    QuestionReader.main ();
                }
                catch (IOException j) {}

                // Updating Background on Play Panel
                playBG = "images/" + r + "R" + w + "W_" + bg + ".jpg";                
                playPan.update (new ImageIcon (playBG).getImage());
                playPan.updateUI();
                playPan.setVisible (true);    

                // Category Display Popup Called
                try
                {
                    Category_Disp.disp(questions [q][1], amount [q+1], amount [q]);
                } 
                catch (IOException e) {}

                // Setting Text for Questions & Answers
                qaL [0].setText(questions [q][3]);
                qaL [2].setText("    A:    " + questions [q][4]);
                qaL [3].setText("    B:    " + questions [q][5]);
                qaL [4].setText("    C:    " + questions [q][6]);
                qaL [5].setText("    D:    " + questions [q][7]);                           
            }

            // If the Options Buttons is Pressed, Execute
            else if (event.getSource () == optionsB)
            {
                //Stopping SOund
                introMP3.close();

                //Setting Panel Properties
                mainP.setVisible (false);
                optionsP.setVisible (true);
            }

            // If the Exit Button is Pressed
            else if (event.getSource () == exitB)
            {
                System.exit (0);            // Exit Game
            }

            // If The Experts Button is Pressed
            else if (event.getSource () == expertsB)
            {
                //Stopping Sound
                introMP3.close();

                //Setting Panel Properties
                mainP.setVisible (false);
                expertsMBG = "images/Experts_" + bg + ".jpg";
                expertsMP.update (new ImageIcon (expertsMBG).getImage());
                expertsMP.updateUI();
                expertsMP.setVisible (true);
            }
        }
    }
}