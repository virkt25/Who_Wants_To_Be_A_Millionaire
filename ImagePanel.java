// Import Statements
import javax.swing.*;
import java.awt.*;

/**
 * This creates the ImagePanel for our Game
 * 
 * This was taken from an Internet Resource. 
 * 
 * LINK: http://www.java2s.com/Code/Java/Swing-JFC/Panelwithbackgroundimage.htm
 */
class ImagePanel extends JPanel 
{

    private Image img;

    public ImagePanel(String img) 
    {
        this(new ImageIcon(img).getImage());
    }

    public ImagePanel(Image img) 
    {
        this.img = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    public void paintComponent(Graphics g) 
    {
        g.drawImage(img, 0, 0, null);
    }
    
    public void update (Image img)
    {
        this.img = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }
}