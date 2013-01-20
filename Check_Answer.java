// Import Statements
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import layout.TableLayout;

/**
 * This Class is used to check the answer. It matches the User answer to the 
 * Answer on file and calls the appropriate Method to Handle the Response based 
 * on if the Answer is Correct or Wrong. 
 * 
 * @author (Taranveer Virk && Gurbir Dhulla) 
 * @version (v.1 15JAN2011)
 */

public class Check_Answer extends Millionaire      // name of the class
{
    /**
     * This method checks the Answer the user has selected
     * with the answer on File (ARRAY) and takes the appropriate Action.
     */
    public static void ans () throws IOException
    {
        // Reads the Correct Answer into Variables
        if (q <= 14)
        {
            try
            {
                ans = Integer.parseInt (questions [q][8]);
            }
            catch (NullPointerException e) {}
        }

        // Checks if Double Dip is activated -- Execute if it is
        if (ddLL == true)
        {
            DD_Check_Answer.ans();
        }

        // If Double Dip is not activated -- This Executes
        else if (ddLL == false)
        {
            // Checks the User Answer
            if (ans == user)
            {
                correctMP3.play();      // Play Sound
                
                // Updates Image
                r = ans;
                playBG = "images/" + r + "R" + w + "W_" + bg + ".jpg";                
                playPan.update (new ImageIcon (playBG).getImage());
                playPan.updateUI();
                
                // Puts X beside question Value
                if (q <= 14)
                    xL[q].setVisible (true);
                q++;
                
                // TimeBanked is Calculated
                timeBanked = timeBanked + timeRemaining;

                if (q <= 14)
                {
                    if (q < 15)
                        Correct_Ans.correct_Ans_Disp (timeBanked);          // Displays the Correct Answer Dialog

                    // Activates the Ask An Expert LifeLine
                    if (q == 5)
                    {
                        dExp.setVisible (false);
                        lifeB [3].setEnabled (true);
                        Expert_Unlocked.disp();
                    }

                    //Update Questions
                    qaL [0].setText(questions [q][3]);
                    qaL [2].setText("    A:    " + questions [q][4]);
                    qaL [3].setText("    B:    " + questions [q][5]);
                    qaL [4].setText("    C:    " + questions [q][6]);
                    qaL [5].setText("    D:    " + questions [q][7]);

                    // Hides the New Question from User
                    for (int x=0; x<=5; x++)
                        qaL [x].setVisible (false);

                    // Reset Variables
                    r=0;
                    w=0;
                    user = 0;

                    // Update Background
                    playBG = "images/" + r + "R" + w + "W_" + bg + ".jpg";                
                    playPan.update (new ImageIcon (playBG).getImage());
                    playPan.updateUI();
                    playPan.setVisible (true);
                    
                    // Category Display Dialog is Called
                    Category_Disp.disp(questions [q][1], amount [q+1], amount [q]);
                }

                else if (q > 14)        // If the User answer the $1Million Question Correctly
                {
                    playPan.setVisible (false);
                    winningL.setText (amount [15]);
                    winningBG = "images/Winning_" + bg + ".jpg";
                    winningP.update (new ImageIcon (winningBG).getImage());
                    winningP.updateUI();
                    winningP.setVisible (true);
                    winner15MP3.play();
                }  

                // Displays the Question & Answer
                for (int x=0; x<=5; x++)
                    qaL [x].setVisible (true);
            }

            // If the Answer is Not Right
            else if (ans != user && user > 0)
            {
                wrongMP3.play();        // Sound File
                
                // Background Update
                r = ans;
                w = user;
                user = 0;
                playBG = "images/" + r + "R" + w + "W_" + bg + ".jpg";                
                playPan.update (new ImageIcon (playBG).getImage());
                playPan.updateUI();     
                
                // Displays the Wrong Answer Display Panel
                if (q < 15)
                Wrong_Ans.wrong_Ans_Disp ();
            }
        }
    }
}