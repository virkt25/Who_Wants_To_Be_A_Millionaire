// Import Statements
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import layout.TableLayout;

/**
 * This Class creates the options Panel for the Game. The panel is where the game is played.
 * 
 * @author (Taranveer Virk && Gurbir Dhulla) 
 * @version (v.1 12JAN2011)
 */

public class Play_Panel extends Millionaire// name of the class
{
    // Variables Declared
    private static double size0 [][] = {{0.01, 0.035, 0.138, 0.27, 0.01, 0.03, 0.0255, 0.25, 0.02, TableLayout.FILL, 0.02}, 
            //**0*****1*****2******3******4******5******6******7*****8******9*****10****11*****12*****13****14****15****16*****17****18****
            {0.02, 0.023, 0.035, 0.035, 0.02, 0.005, 0.009, 0.025, 0.025, 0.03, 0.035, 0.009, 0.017, 0.03, 0.03, 0.03, 0.03, 0.009, 0.015, 
                /// *19****20****21****22*****23****24*****25****26****27****28***29*****30*****31****32**    
                0.01, 0.03, 0.03, 0.03, 0.024, 0.03, 0.049, 0.025, 0.01, 0.025, 0.06, 0.09, 0.005, 0.09}};

    static ImagePanel playP;

    static TransparentButton ansB [] = new TransparentButton [4];

    static TransparentButtonHandler handlerB = new TransparentButtonHandler (); 

    /**
     * This method sets up the variables and lays out the components on the Screen to create the Play Panel.
     * 
     * @return      Returns the Options Menu Panel --- ImagePanel
     */
    public static ImagePanel showPanel ()
    {
        // Creating Buttons and Adding Buttons to Handler
        for (int x=0; x<=3; x++)
        {
            ansB [x] = new TransparentButton ("");
            lifeB [x] = new TransparentButton ("");
            ansB [x].addActionListener (handlerB);
            lifeB [x].addActionListener (handlerB);
            cross [x] = new JLabel (new ImageIcon ("images/cross.png"));
            cross [x].setVisible (false);
        }   

        // Creating X Labels
        for (int x=0; x<=14; x++)
        {
            xL [x] = new JLabel ("X");
            xL [x].setFont (new Font("Serif", Font.BOLD, 10));
            xL [x].setForeground (Color.WHITE);
            xL [x].setVisible (false);
        }

        // Time Label
        time.setForeground (Color.WHITE);
        time.setFont (new Font ("Serif", Font.BOLD, 20));

        // Creating the Questions & Answers Labels -------- Move to Play Button Hnadler
        qaL [0] = new JLabel (questions [q][3], JLabel.CENTER);
        qaL [1] = new JLabel ("          ");
        qaL [2] = new JLabel ("    A:    " + questions [q][4]);
        qaL [3] = new JLabel ("    B:    " + questions [q][5]);
        qaL [4] = new JLabel ("    C:    " + questions [q][6]);
        qaL [5] = new JLabel ("    D:    " + questions [q][7]);
        
        // Creating X Labels
        for (int x=0; x<=5; x++)
        {
            qaL [x].setForeground (Color.WHITE);
            qaL [x].setVisible (true);
        }

        // Setting Properties of Play Panel
        playBG = "images/" + r + "R" + w + "W_" + bg + ".jpg";
        playP = new ImagePanel (new ImageIcon(playBG).getImage());
        playP.setLayout (new TableLayout (size0));            
        playP.setOpaque (false);
        playP.setVisible (false);

        //Adding Components to ImagePanel
        playP.add (lifeB [0], "2, 1, 2, 4");
        playP.add (lifeB [1], "2, 7, 2, 11");
        playP.add (lifeB [2], "2, 13, 2, 17");
        playP.add (lifeB [3], "2, 19, 2, 23");
        playP.add (cross [0], "2, 1, 2, 4");
        playP.add (cross [1], "2, 7, 2, 11");
        playP.add (cross [2], "2, 13, 2, 17");
        playP.add (cross [3], "2, 19, 2, 23");
        playP.add (dExp, "2, 19, 2, 23");
        dExp.setVisible (true);

        playP.add (ansB [0], "1, 30, 5, 30");
        playP.add (ansB [1], "6, 30, 9, 30");
        playP.add (ansB [2], "1, 32, 5, 32");
        playP.add (ansB [3], "6, 32, 9, 32");  

        playP.add (time, "5, 24, 6, 24, c, c");

        playP.add (xL[14], "8, 2, c, c");
        playP.add (xL[13], "8, 3, c, c");
        playP.add (xL[12], "8, 4, c, c");
        xL [11].setText (" X");
        playP.add (xL[11], "8, 5, 8, 7");
        playP.add (xL[10], "8, 8, c, c");
        playP.add (xL[9], "8, 9, c, c");
        playP.add (xL[8], "8, 10, c, c");
        xL [7].setText (" X");
        playP.add (xL[7], "8, 11, 8, 12");
        playP.add (xL[6], "8, 13, c, c");
        playP.add (xL[5], "8, 14, c, c");
        playP.add (xL[4], "8, 15, c, c");
        playP.add (xL[3], "8, 16, c, c");
        xL [2].setText (" X");
        playP.add (xL[2], "8, 17, 8, 19");
        playP.add (xL[1], "8, 20, c, c");
        playP.add (xL[0], "8, 21, c, c");

        playP.add (qaL [0], "2, 26, 9, 26");
        playP.add (qaL [1], "2, 28, 9, 28"); 
        playP.add (qaL [2], "2, 30, 5, 30");
        playP.add (qaL [3], "7, 30, 9, 30");
        playP.add (qaL [4], "2, 32, 5, 32");
        playP.add (qaL [5], "7, 32, 9, 32");  

        // Adding Panel to Main Display Panel
        return playP; 
    }

    /**
     * This class handles the events by the Buttons. Executes the Appropriate Code based on the Button clicked
     */
    private static class TransparentButtonHandler implements ActionListener 
    {
        public void actionPerformed (ActionEvent event) 
        {       
            // Line Line 1 -- Audience Poll
            if (event.getSource () == lifeB[0])
            {
                timer.stop();
                try
                {
                    Audience_Poll.pollDisp (questions, q);
                }
                catch (IOException e) {}
                lifeB [0].setEnabled (false);
                cross [0].setVisible (true);
                timer.start();
            }

            else if (event.getSource () == lifeB[1])            // Life Line 2 --- Double Dip
            {
                timer.stop();
                ddLL = true;
                try
                {
                    Double_Dip.disp();
                }
                catch (IOException e) {}
                lifeB [1].setEnabled (false);
                cross [1].setVisible (true);
                timer.start();
            }

            else if (event.getSource () == lifeB[2])        // Life Line 3 --- Phone a Friend
            {
                timer.stop();               
                try
                {
                    Phone_Friend.phoneDisp (questions, q);
                }
                catch (IOException e) {}
                lifeB [2].setEnabled (false);
                cross [2].setVisible (true);
                timer.start();
            }

            else if (event.getSource () == lifeB[3])        // LifeLine 4 ---- Ask An Expert
            {
                timer.stop();                
                try
                {
                    Expert_Advice.expDisp (questions, q, expert);
                }
                catch (IOException e) {}
                lifeB [3].setEnabled (false);
                cross [3].setVisible (true);
                timer.start();                
            }

            else if (event.getSource () == ansB [0])        // --- Answer --- Option A
            {
                user = 1;
                timer.stop();
                try
                {
                    Confirm_Ans.disp();
                } 
                catch (IOException e) {}
            }

            else if (event.getSource () == ansB [1])        // --- Answer --- Option B
            {
                user = 2;
                timer.stop();
                try
                {
                    Confirm_Ans.disp();
                } 
                catch (IOException e) {}
            }

            else if (event.getSource () == ansB [2])        // --- Answer --- Option C
            {
                user = 3;
                timer.stop();
                try
                {
                    Confirm_Ans.disp();
                } 
                catch (IOException e) {}
            }

            else if (event.getSource () == ansB [3])        // --- Answer --- Option D
            {
                user = 4;
                timer.stop();
                try
                {
                    Confirm_Ans.disp();
                } 
                catch (IOException e) {}
            }
        }
    }
}