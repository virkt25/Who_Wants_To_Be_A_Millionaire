// Import Statements
import javax.swing.*;
import java.awt.*;

/**
 * This clas creates Transparent Button for the Program.
 * 
 * This class was taken from an Internet resource. 
 * 
 * LINK: http://www.dreamincode.net/code/snippet2193.htm
 */
public class TransparentButton extends JButton 
{
    public TransparentButton(String text) 
    { 
        super(text);
        setOpaque(false); 
    } 

    public void paint(Graphics g) 
    { 
        Graphics2D g2 = (Graphics2D) g.create(); 
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.0f)); 
        super.paint(g2); 
        g2.dispose(); 
    } 
}