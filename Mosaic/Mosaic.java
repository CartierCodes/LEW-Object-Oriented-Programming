// Carter Burzlaff 10/20/2019

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent; 

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class Mosaic
{
    public static void main(String[] args)
    {
        System.out.println("Starting...");

        MosaicFrame myFrame = new MosaicFrame();
        myFrame.setVisible(true);
    }
}

class MosaicPanel extends JPanel implements MouseListener
{
    private Face myFace;
    private Random numGen = new Random();
    private int red, green, blue;
    private String letter;
    private boolean isCircle;
    private boolean drawFace;
    private int faceType;

    public void setDrawFace(boolean b) { drawFace = b; }

    public MosaicPanel()
    {
        randomizeValues();
        addMouseListener(this);

        drawFace = false;
    }

    public void randomizeValues()
    {
        red = numGen.nextInt(256);
        green = numGen.nextInt(256);
        blue = numGen.nextInt(256);

        if (numGen.nextInt(2) == 0) { isCircle = true; }
        else { isCircle = false; }

        String allLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int index = numGen.nextInt(26);
        letter = allLetters.substring(index, index + 1);

        faceType = numGen.nextInt(4);

        System.out.println(this);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        if (drawFace == true)
        {
            myFace = new Face(getWidth(), getHeight(), faceType);
            myFace.paintComponent(g);
        }

        else
        {
            g.setColor(new Color(red, green, blue));
            if (isCircle == true)
            {
                g.fillOval(0, 0, panelWidth, panelHeight);
            }
            else
            {
                g.fillRect(0, 0, panelWidth, panelHeight);
            }

            g.setColor(new Color((red + 128) % 256, (green + 128) % 256, (blue + 128) % 256));
            g.setFont(new Font("Ariel", Font.PLAIN, (panelWidth + panelHeight) / 4));
            g.drawString(letter, (panelWidth / 2) - (g.getFont().getSize() / 3), (panelHeight / 2) + (g.getFont().getSize() / 3));
        }
    }

    public String toString()
    {
        String shape;
        if (drawFace)
        {
            return String.format("Face");
        }

        else
        {
            if (isCircle)
                shape = "Circle";
            else
                shape = "Rectangle";
        
            return String.format("%s - %s - %d, %d, %d", shape, letter, red, green, blue);
        }
    }

    public void mouseClicked(MouseEvent e)
    {
        drawFace = true;
        repaint();
    }
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
}

class MosaicFrame extends JFrame implements ActionListener
{
    private int tilesX;
    private int tilesY;

    Container contentPane;
    JPanel gridPanel;
    JPanel buttonPanel;

    private JButton randomButton;
    private JButton resetButton;
    private JButton changeSizeButton;

    private ArrayList<MosaicPanel> panelList;

    public MosaicFrame()
    {
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 800);
        setTitle("Mosaic");

        tilesX = 12;
        tilesY = 12;

        System.out.println("Start Paint*****************************************");

        contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        
        gridPanel = new JPanel(new GridLayout(tilesX, tilesY));
        buttonPanel = new JPanel();

        randomButton = new JButton("Randomize");
        randomButton.addActionListener(this);
        buttonPanel.add(randomButton);

        resetButton = new JButton("Reset");
        resetButton.addActionListener(this);
        buttonPanel.add(resetButton);

        changeSizeButton = new JButton("Change Size");
        changeSizeButton.addActionListener(this);
        buttonPanel.add(changeSizeButton);

        contentPane.add(gridPanel, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        fillGridPanel();
    }

    public void fillGridPanel()
    {
        panelList = new ArrayList<MosaicPanel>();
        for (int i = 0; i < tilesX * tilesY; i++)
        {
            MosaicPanel tile = new MosaicPanel();
            gridPanel.add(tile);
            panelList.add(tile);
        }
    }

    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == randomButton) 
        {
            System.out.println("Start Paint***");
            for (MosaicPanel p : panelList)
            {
                p.randomizeValues();
            }
            repaint();
        }
        
        else if (e.getSource() == resetButton) 
        {
            System.out.println("Start Paint***");
            for (MosaicPanel p : panelList)
            {
                p.setDrawFace(false);
                p.randomizeValues();
            }
            repaint();
        }

        else if (e.getSource() == changeSizeButton) 
        {
            Scanner input = new Scanner(System.in);
            String ans;

            System.out.print("Would you like to change the number of horizontal tiles? ");
            ans = input.next();
            if (ans.equals("YES") || ans.equals("Yes") || ans.equals("yes") || ans.equals("Y") || ans.equals("y"))
            {
                System.out.print("Enter amount of tiles: ");
                tilesX = input.nextInt();
            }

            System.out.print("Would you like to change the number of vertical tiles? ");
            ans = input.next();
            if (ans.equals("YES") || ans.equals("Yes") || ans.equals("yes") || ans.equals("Y") || ans.equals("y"))
            {
                System.out.print("Enter amount of tiles: ");
                tilesY = input.nextInt();
            }

            System.out.println("Start Paint***");

            gridPanel.removeAll();
            gridPanel.setLayout(new GridLayout(tilesX, tilesY));

            fillGridPanel();
            revalidate();
        }
    }
}