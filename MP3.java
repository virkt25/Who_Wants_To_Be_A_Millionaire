// Import Statements
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import javazoom.jl.player.*;

/**
 * This class creates an MP3 object. It is used to play MP3 files for sound effects during the game.
 * 
 * @author (Taranveer Virk && Gurbir Dhulla)
 * @version (1.0, 20JAN2011)
 */
public class MP3  
{
    // Variables Declared
    private String filename;
    private Player player; 

    // constructor that takes the name of an MP3 file
    /**
     * Constructor for this Class
     * 
     * @param       A String containing the Filename & path for the MP3 file.
     */
    public MP3(String filename)
    {
        this.filename = filename;
    }

    /**
     * This method stops playing the MP3 file if it is playing.
     */
    public void close() 
    { 
        if (player != null) 
            player.close(); 
    }

    /**
     * This method plays the MP3 file to the Sound Card
     */
    public void play() 
    {
        try 
        {
            FileInputStream fis     = new FileInputStream(filename);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player = new Player(bis);
        }
        catch (Exception e) 
        {
            System.out.println("Problem playing file " + filename);
            System.out.println(e);
        }

        // run in new thread to play in background
        new Thread() 
        {
            public void run() 
            {
                try 
                { 
                    player.play(); 
                }
                catch (Exception e) 
                { 
                    System.out.println(e); 
                }
            }
        }.start();
    }

    // test client
    //     public static void main(String[] args) {
    //         String filename = "audio/01 - Kamli.mp3";
    //         MP3 mp3 = new MP3(filename);
    //         mp3.play();
    // 
    // do whatever computation you like, while music plays
    //         int N = 4000;
    //         double sum = 0.0;
    //         for (int i = 0; i < N; i++) {
    //             for (int j = 0; j < N; j++) {
    //                 sum += Math.sin(i + j);
    //             }
    //         }
    //         System.out.println(sum);
    // 
    // when the computation is done, stop playing it
    //         mp3.close();
    // 
    // play from the beginning
    //         mp3 = new MP3(filename);
    //         mp3.play();
    // 
    //     }

}
