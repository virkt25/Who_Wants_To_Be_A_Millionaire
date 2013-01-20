// Import Statements
import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import layout.TableLayout;
import javax.swing.Timer;

/**
 * This is the SuperClass for the Millionaire Game. This Method creates the Frames and Displays it and
 * creates Objects of other classes that are required to run the Game. All Global Variables are Declared in this Class.
 * 
 * To Play this Game, run an instance of this class. 
 * Follow on screen instructions or the External Documentation 
 * 
 * OTHER PROGRAMMING NOTES:
 * All Dialogs are destroyed once Closed to free up RAM.
 * Panels are Hidden and Updated
 * Only the Required Image is Loaded
 * The Timer does stop when there is a Dialog open
 * 
 * OTHER NOTES:
 * 
 *  ***** NO COPYRIGHT INFRINGEMENT INTENDED *****
 *  ***** All rights reserved by respective Owners
 *  ***** The idea was just used to complete this game for School Project
 *  ***** NO COPYRIGHT INFRINGEMENT INTENDED *****
 *   
 * @author (Taranveer Virk && Gurbir Dhulla) 
 * @version (v.1 12JAN2011)
 */

public class Millionaire            // name of the class
{
    // Variables Declared
    static JFrame mainMenuF = new JFrame ("Who Wants To Be A Millionarire");        // Main Frame
    
    static JPanel display = new JPanel ();              // Main Display Panel
    
    static String introBackground, expertsMBG, optionsBG, expertsBG, playBG, winningBG;         // String to Store Baground File Names
    static String expertName;           // Name of Your Expert
    
    static String questions [][] = new String [15][10];         // Stores the Questions for the Game
    static String amount [] = {"$0", "$100", "$200", "$300", "$500", "$1,000", "$2,000", "$4,000", "$8,000",            // Different Amounts Levels 
            "$16,000", "$25,000", "$50,000", "$100,000", "$250,000", "$500,000", "$1 MILLION"};
    static String expNames [] = {"Ashleigh Banfield", "Bill Finan", "Jeff Gross", "Eric Kiehl", "Pat Kiernan", "Laura Nemeth", "Ogi Ogas", "Ben Seitelman", "Tom Spencer", "Joel Stein"};       // Name of Experts
    
    static ImagePanel mainP, optionsP, expertsMP, expertsP, playPan, winningP;          // ImagePanels to hold Objects returned from Other Classes
    
    static JLabel time = new JLabel ("", JLabel.CENTER);            // Varaible to Display the Time for Timer
    static JLabel dExp = new JLabel (new ImageIcon ("images/ExpertDisabled.png"));          // Stores the Disabled Expert Button
    static JLabel winningL = new JLabel ("", JLabel.CENTER);        // Used to Display the Amount You Won
    
    static JLabel qaL [] = new JLabel [6];          // Used to stoer questions and answers to be displayed on Screen    
    static JLabel xL [] = new JLabel [15];          // Stores the X to show beside Amount for which Questions has been Answered    
    static JLabel cross [] = new JLabel [4];            // Stores the Cross for the LifeLines
    
    static int bg = 1;              // Bagkground Variable --- Determines Which Background is Displayed    
    static int exp = 1;             // Variables Stores the Expert Location --- Value Reassigned by QuestionReader    
    static int q, bank, qtry, expert;           // Stres the question number, money earned, # of tries for Double Dip, expert Name locating Variable respectively
    static int r = 0;           // Used to Determine Play Panel Background Image    
    static int w = 0;           // Used to deermine Play Panel Background Image    
    static int ans, user, timeBanked, timeRemaining;    // Stores the answer, User answer, time accumulated for last question, and time remaining on clock
    
    static boolean ddLL;            // Boolean to see if Double Dip is Activated   
    
    static Timer timer = new Timer(1000, new CountdownTimerListener());        //       Timer to CountDown
    
    static TransparentButton lifeB [] = new TransparentButton [4];          // The Life Line Buttons    
    
    // Sound Effects
    static MP3 introMP3 = new MP3("audio/OpeningTitles.mp3");
    static MP3 correctMP3 = new MP3("audio/Correct.mp3");
    static MP3 wrongMP3 = new MP3("audio/Wrong.mp3");
    static MP3 winningMP3  = new MP3("audio/TotalWinning.mp3");
    static MP3 audienceMP3 = new MP3("audio/AskAudience.mp3");
    static MP3 phoneMP3 = new MP3("audio/AskTheExpertIntro.mp3");
    static MP3 expertMP3 = new MP3 ("audio/AskTheExpertIntro.mp3");
    static MP3 wrong15MP3 = new MP3 ("audio/Q15 Wrong.mp3");
    static MP3 winner15MP3 = new MP3 ("audio/Q15 Winner.mp3");
    static MP3 dd1MP3 = new MP3 ("audio/DoubleDipFirst.mp3");
    static MP3 dd2MP3 = new MP3 ("audio/DoubleDipSecond.mp3");

    /**
     * This is the Constructor for the Millionaire Class. This sets the defauls on some variables
     * and initializes other variables and creates the Frame in which the Class runs.
     */
    public Millionaire ()
    {
        // Creating the Panels
        mainP = Main_Panel.showPanel();
        optionsP = Options_Panel.showPanel ();
        expertsMP = Experts_Menu_Panel.showPanel ();
        expertsP = Experts_Panel.showPanel ();
        playPan = Play_Panel.showPanel ();
        winningP = Winning_Panel.showPanel ();

        // Adding Panels to Main Display Screen
        display.add (mainP);
        display.add (optionsP);
        display.add (expertsMP);
        display.add (expertsP);
        display.add (playPan);
        display.add (winningP);
        
        //Setting Default Properties for Visibility
        optionsP.setVisible (false);
        expertsMP.setVisible (false);
        expertsP.setVisible (false);
        mainP.setVisible (true);
        playPan.setVisible (false);
        winningP.setVisible (false);

        /*
         * Frame Setup and Display
         */
        {
            mainMenuF.setContentPane (display);
            mainMenuF.setResizable (false);    // Disables the Maximize Button :)
            mainMenuF.pack();
            mainMenuF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainMenuF.setLocationRelativeTo(null); 
            mainMenuF.setVisible(true);
        }
    }

    /**
     * This is the ActionListener for the Timer. This Handles the Events for the Timer.
     */
    static class CountdownTimerListener implements ActionListener {     
        public void actionPerformed(ActionEvent e)
        {          
            if (--timeRemaining > 0)        // Updates the Timer Display Label
            {           
                time.setText(String.valueOf(timeRemaining));     
            } 
            
            else        // When Time Runs Out
            {   
                time.setText("0");   
                timer.stop(); 
                try
                {
                    OutOfTime.disp ();
                } catch (IOException i) {}
            }    
        }
    }
}