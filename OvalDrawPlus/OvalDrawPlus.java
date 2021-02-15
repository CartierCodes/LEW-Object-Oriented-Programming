// Author: Carter Burzlaff
// Notes:  Drawing some ovals and rectangles. My favorite color is purple.

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Container; 
import java.awt.Color;

public class OvalDrawPlus
{
    public static void main(String[] args)
    {
        System.out.println("OvalDraw Starting...");

        OvalFrame myOvalFrame = new OvalFrame();
        myOvalFrame.setVisible(true);
    }
}

class Oval extends JPanel {
    // OVAL CONSTRUCTORS
    Oval()
    {
        setColor(255,0,0);
    }

    Oval(int red, int green, int blue)
    {
        setColor(red,green,blue);       
    }

    // COLOR FIELD + GET/SET METHOD
    private Color myColor;
    private Color blueColor = new Color(0,0,139);
    public Color getColor() { return myColor; }
    public void setColor(int red, int green, int blue) { myColor = new Color(red,green,blue); }

    // PAINT COMPONENT METHOD
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        g.setColor(blueColor);
        g.fillRect(0,0,panelWidth,panelHeight);
        g.setColor(myColor);
        g.fillOval(0,0,panelWidth,panelHeight);
    }
}

class OvalFrame extends JFrame
{
    //OVAL FRAME CONSTRUCTOR
    OvalFrame()
    {
        setTitle("OvalDraw");
        setBounds(200,200,300,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Oval myOval = new Oval(128,0,128);
        Container contentPane = getContentPane();
        contentPane.add(myOval);     
    }
}