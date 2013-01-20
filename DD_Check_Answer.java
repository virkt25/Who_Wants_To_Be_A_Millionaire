// Import Statements
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import layout.TableLayout;

/**
 * This class checks the answer if Double Dip was activated and calls the appropriate 
 * methods. It doesn't display the WRONG answer dialog if the answer was wrong. It 
 * only checks the First Answer for Double Dip. Second One is checked by Normal Check_Answer
 * 
 * @author (Taranveer Virk && Gurbir Dhulla) 
 * @version (v.1 21JAN2011)
 */

public class DD_Check_Answer extends Millionaire      // name of the class
{
    /**
     * This method checks the answer if Double Dip was Activated.
     */
    public static void ans () throws IOException
    {
        // Reading Answe and changing Value of Double Dip Activated Boolean
        ans = Integer.parseInt (questions [q][8]);
        ddLL = false;

        if (ans == user)        // If the Answe is right
        {
            correctMP3.play();  // Sound
            
            // Image Update
            r = ans;
            playBG = "images/" + r + "R" + w + "W_" + bg + ".jpg";                
            playPan.update (new ImageIcon (playBG).getImage());
            playPan.updateUI();
            xL[q].setVisible (true);
            
            // Variables Changed
            q++;
            timeBanked = timeBanked + timeRemaining;

            if (q <= 14)
            {
                if (q < 15)
                Correct_Ans.correct_Ans_Disp (timeBanked);

                if (q == 5)         // Activate Ask An Expert
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

                // Hide the Questions
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
                Category_Disp.disp(questions [q][1], amount [q+1], amount [q]);
            }

            else if (q > 14)
            {
                Correct_Ans.correct_Ans_Disp (0);
                playPan.setVisible (false);
                winningL.setText (amount [q]);
                winningBG = "images/Winning_" + bg + ".jpg";
                winningP.update (new ImageIcon (winningBG).getImage());
                winningP.updateUI();
                winningP.setVisible (true);   
                winner15MP3.play();
            }  

            // Displays the Questions
            for (int x=0; x<=5; x++)
                qaL [x].setVisible (true);
        }

        // If the Answer if Not Right
        else if (ans != user && user > 0)
        {
            wrongMP3.play();        // Sound
            r = 0;
            w = user;
            user = 0;
            playBG = "images/" + r + "R" + w + "W_" + bg + ".jpg";                
            playPan.update (new ImageIcon (playBG).getImage());
            playPan.updateUI();

            if (qtry == 1)
                DD_Wrong_Ans.disp();        // Display Double Dip Wrong First!!
        }
    }
}