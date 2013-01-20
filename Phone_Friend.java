// Import Statements
import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import layout.TableLayout;

/**
 * This class creates a JDialog for the phone a Friend helpline and displays it on the screen.
 * It determines the question difficulty and picks a response statement based on that and displays it.
 * The answer given is always right even though the response may suggest something else. 
 * 
 * @author (Taranveer Virk && Gurbir Dhulla) 
 * @version (v.1 12JAN2011)
 */

public class Phone_Friend extends Millionaire     // name of the class
{
    // Variables Declared
    static ImagePanel phoneMP, phoneP;

    static JDialog phoneDisp = new JDialog ();

    static JPanel display = new JPanel ();

    static ArrayList arr = new ArrayList ();

    static String option = "";
    static String introBackground = "images/ll_bg.png";
    static String phone = "images/phone.png";

    static String questions [][] = new String [15][10];
    static String[] names = {"Kyle Arscott", "Rick Prins", "Wesley Plitz", "Hashim Muhammad", "Dimitry Walters", 
            "Bilal Amode", "Sharad Goyal", "Vignesh Vivek", "Rishita Apsani", "Jasmine Mundi" };

    static int q, question_num;

    private static double size[][] = {{TableLayout.FILL}, {TableLayout.FILL}};
    private static double size2 [][] = {{TableLayout.FILL}, {0.4, 0.15, 0.05, 0.08, 0.08, 0.08, 0.0}};
    private static double size3 [][] = {{0.605, 0.35, 0.05}, {0.865, 0.095, 0.1}};

    static JLabel[] temp_label = new JLabel [4];

    static JLabel continueL = new JLabel ("Continue");

    static TransparentButton continueB = new TransparentButton ("");

    static TransparentButtonHandler handlerC = new TransparentButtonHandler ();

    public static void phoneDisp (String [][] questions, int question_num) throws IOException
    {
        // Playing the Sound
        phoneMP3.play();
        
        // Adding Button To Handler
        continueB.addActionListener (handlerC);

        //Setting Up Labels
        continueL.setFont (new Font("Serif", Font.BOLD, 20));
        continueL.setForeground (Color.WHITE);

        // Setting properties of Main Panel  
        phoneMP = new ImagePanel(new ImageIcon(introBackground).getImage());
        phoneMP.setLayout (new TableLayout (size));
        phoneMP.setOpaque (false);
        phoneMP.setVisible (true);

        // Setting Up The Sub Panel
        phoneP = new ImagePanel(new ImageIcon(phone).getImage());
        phoneP.setLayout (new TableLayout (size2));
        phoneP.setOpaque (false);
        phoneP.setVisible (true);

        // Setting Invisible Display Panel for Holding Continue Button / Label
        display.setLayout (new TableLayout (size3));
        display.setOpaque (false);
        display.setVisible (true);
        display.add (continueB, "1, 1");
        display.add (continueL, "1, 1, c, c");

        // Adding Components to Main Panel
        phoneMP.add(phoneP, "0, 0");
        phoneMP.add (display, "0, 0");

        // Setting the Options Value
        if (questions[question_num][8].equals("1") )
            option = "A";
        else if (questions[question_num][8].equals("2"))
            option = "B";
        else if (questions[question_num][8].equals("3"))
            option = "C";
        else if (questions[question_num][8].equals("4"))
            option = "D";

        // Generating Random Friend
        arr = RandomGenerator.numGen(0, 9, 1, true, false);
        q = Integer.parseInt(arr.get(0)+"");
        temp_label[3] = new JLabel(names[q].toUpperCase());

        // Setting Label Properties and Adding to Panel
        temp_label[3].setFont (new Font("Serif", Font.BOLD, 15));
        temp_label[3].setForeground (Color.WHITE);
        phoneP.add(temp_label[3], "0, 1, c, B");

        // Selecting the Response
        if (questions[question_num][2].equals("1"))
        {
            temp_label[0] = new JLabel("Good question! I'm 100% sure I can answer this gem.");
            temp_label[1] = new JLabel("The answer is definitely "+option+", \"" +questions[question_num][3+Integer.parseInt(questions[question_num][8])]+"\"");
            temp_label[2] = new JLabel("");
        } 
        
        else if (questions[question_num][2].equals("2")){ 
            temp_label[0] = new JLabel("I read about this somewhere, I am pretty sure, ");
            temp_label[1] = new JLabel("answer to this one is "+option+", \"" +questions[question_num][3+Integer.parseInt(questions[question_num][8])]+"\"");
            temp_label[2] = new JLabel("");
        } 
        
        else if (questions[question_num][2].equals("3")){ 
            temp_label[0] = new JLabel("This seems like a trick question, but I am");
            temp_label[1] = new JLabel("80% sure the answer is "+option+", \"" +questions[question_num][3+Integer.parseInt(questions[question_num][8])]+"\"");
            temp_label[2] = new JLabel("");
        } 
        
        else if (questions[question_num][2].equals("4")){ 
            temp_label[0] = new JLabel("This one seems like a sticky wicket but i can");
            temp_label[1] = new JLabel("take a 60% guess that the answer is ");
            temp_label[2] = new JLabel(option+", \"" +questions[question_num][3+Integer.parseInt(questions[question_num][8])]+"\"");
        } 
        
        else if (questions[question_num][2].equals("5")){ 
            temp_label[0] = new JLabel("I think my friend mentioned something about "+questions[question_num][3+Integer.parseInt(questions[question_num][8])]);
            temp_label[1] = new JLabel("once. I am willing to take a 50% guess with");
            temp_label[2] = new JLabel(option+", \"" +questions[question_num][3+Integer.parseInt(questions[question_num][8])]+"\"");
        } 
        
        else if (questions[question_num][2].equals("6")) {
            temp_label[0] = new JLabel("Hmmmm. This one is really hard, I am not sure");
            temp_label[1] = new JLabel("of the answer. But if you really want, I would");
            temp_label[2] = new JLabel("recommend going with "+option+", \"" +questions[question_num][3+Integer.parseInt(questions[question_num][8])]+"\"");
        }

        // Setting Response Properties and Adding to panel
        for (int x=0; x<=2; x++)
        {
            temp_label[x].setFont (new Font("Serif", Font.BOLD, 15));
            temp_label[x].setForeground (Color.WHITE);
            phoneP.add(temp_label[x], "0, "+Integer.toString(x+3)+", c, TOP");
        }         

        // Dialog Box Setup and Display        
        phoneDisp.setUndecorated(true);       // Hides the Top Bar
        phoneDisp.setContentPane (phoneMP);          // Adding Panel to Dialog
        phoneDisp.pack();             // Packs the Dialog
        phoneDisp.validate();      // Validates the Dialog
        phoneDisp.setModal(true);       // Makes it Compulsory for User to go through the Dialog
        phoneDisp.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);          // Disables the Close Button  
        phoneDisp.setLocationRelativeTo(null);    // Centers Panel on Screen
        phoneDisp.setVisible(true);            // Makes Dialog Visible
        phoneDisp.setResizable (false);     // Disables the Maximize Button :)
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
                phoneMP3.close();
                phoneDisp.dispose();        // Destroys the JDialog to free up space
            }
        }
    }
}

