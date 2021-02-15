/*
Carter Burzlaff - 10/6/2019
FaceDraw | A program that draws faces |
I made all of my calculations on where to draw the elements of the face in their respective
classes so that the FaceDraw, FaceFrame, and FacePanel classes were very simple and easy to 
understand, this way all of the calculations are done away from the user's sight.
*/

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

// The main class makes a FaceFrame and FacePanel, then puts the panel in the frame.
// When the panel is made it automatically makes a random amount of Faces inside of it
public class FaceDraw
{
    public static void main(String[] args)
    {
        System.out.println("FaceDraw has started...");
        
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Window Width (400 - 800): ");
        int frameWidth = input.nextInt();

        System.out.print("Enter Window Height (400 - 800): ");
        int frameHeight = input.nextInt();

        System.out.print("Enter Window Title: ");
        String faceTitle = input.next();

        FaceFrame myFaceFrame = new FaceFrame(100, 100, frameWidth, frameHeight, faceTitle);
        myFaceFrame.setVisible(true);
    }
}

// I made my own JFrame class which sets the bounds and title to whatever the parameters are
// It also sets some default values for the Frame
class FaceFrame extends JFrame
{
    public FaceFrame(int fPositionX, int fPositionY, int fWidth, int fHeight, String fTitle)
    {
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(fPositionX, fPositionY, fWidth, fHeight);
        setTitle(fTitle);
        
        add(new FacePanel(fWidth, fHeight));
    }
}

// When a FacePanel is constructed, a random number of faces (3-10) are made and put into the panel
class FacePanel extends JPanel
{
    private Random numGen = new Random();
    private int numOfFaces = numGen.nextInt(4) + 5;   // generates an integer 3-10

    private ArrayList<Face> faceList = new ArrayList<Face>();

    public FacePanel(int frameWidth, int frameHeight)
    {
        for(int i = 0; i < numOfFaces; i++)
        {
            faceList.add(new Face(frameWidth, frameHeight));
            System.out.println(faceList.get(i));
        }
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for (int i = 0; i < numOfFaces; i++)
        {
            Face currentFace = faceList.get(i);
            currentFace.paintComponent(g);
        }
    }
}