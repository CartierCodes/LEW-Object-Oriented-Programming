/******************************************************************************
 * @author Carter Burzlaff
 * 
 * 24 November 2019
 * 
 * Much of this file was used from Eric Pogue's ThunderbirdLite application
 * 
 * This application utilizes the HttpRequest.java library developed by Eric Pogue

 *****************************************************************************/
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Container; 
import java.awt.GridLayout;
import java.awt.BorderLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

import java.util.ArrayList;

class ContactTile extends JPanel {
    private ThunderbirdContact contactInSeat = null;

    private Boolean isAnAisle = true;
    public void setDesk() { isAnAisle = false; }

    ContactTile() {
        super();

        // Todo: Remove everything to do with random colors.
        // Todo: Implement visually appealing colors for aisles and seats.
        // CJB: Completed
    }

    ContactTile(ThunderbirdContact contactInSeatIn) {
        super();
        contactInSeat = contactInSeatIn;
    }

     public void paintComponent(Graphics g) {
        super.paintComponent(g); 

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        if (isAnAisle) {
            g.setColor(new Color(190,190,190)); // Light Gray
        } else {
            g.setColor(new Color(173,216,230)); // Light Blue
        }
        
        g.fillRect (1, 1, panelWidth - 1, panelHeight - 1);

        g.setColor(new Color(0,0,0));

        final int fontSize=18;
        g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
        if (contactInSeat != null) {
            String seatName = contactInSeat.getPreferredName();
            int stringX = (panelWidth/2) - (seatName.length() * 2);
            int stringY = (panelHeight/2);
            // Todo: Dispay preferred name instead of first and last name.
            // CJB: Completed
            g.drawString(seatName,stringX,stringY);
        }
    }
}

class ThunderbirdLiteFrame extends JFrame implements ActionListener {
    private ArrayList<ContactTile> tileList;

    public ThunderbirdLiteFrame() {
        setBounds(200,200,1200,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        JButton reverseView = new JButton("Reverse View");
        buttonPanel.add(reverseView);
        reverseView.addActionListener(this);

        JPanel contactGridPanel = new JPanel();
        contentPane.add(contactGridPanel, BorderLayout.CENTER);

        contactGridPanel.setLayout(new GridLayout(11,9));

        ThunderbirdModel tbM = new ThunderbirdModel();
        tbM.LoadIndex();
        tbM.LoadContactsThreaded();

        // Todo: Review ThunderbirdModel in detail and implement a multithreaded version of loading contacts. 
        // CJB: Completed
        // Hint: Review LoadContact() and LoadContactsThreaded() in detail.

        System.out.println("Printing Model:");
        System.out.println(tbM);
        tbM.ValidateContacts();   


        tileList = new ArrayList<ContactTile>();
        
        int[] deskNumbers = new int[] {10,12,13,15,16,19,24,25,28,30,31,33,34,37,46,48,49,51,52,55,60,61,64,66,67,69,70,84,85,93,94};
        ArrayList<Integer> deskNumbersList = new ArrayList<Integer>();
        for(int i : deskNumbers) {
            deskNumbersList.add(i);
        }

        for(int i=0; i<99; i++) {
            ThunderbirdContact contactInSeat = tbM.findContactInSeat(i);
            if (contactInSeat != null) {
                System.out.println(contactInSeat);
            }

            ContactTile tile = new ContactTile(contactInSeat);

            // Todo: Place all the aisle seats in a array or an ArrayList instead of hard coding them. 
            // CJB: Completed
            if (deskNumbersList.contains(i)) {
                tile.setDesk();
            }

            tileList.add(tile);
            contactGridPanel.add(tile);
        }
    }

    public void actionPerformed(ActionEvent e) {
        for(ContactTile tile : tileList) {
            // Todo: Remove randomization functionality and implement a visually appealing view of seats and aisles.
            // CJB: Completed

            // Todo: Implement reverse view where it looks like you are looking at the room from the back instead of the front of the room. 
            // CJB: Can't figure out how to do this
        }

        repaint();
    }
}

// Todo: Rename the following class to Thunderbird.
// CJB: Completed
// Hint: This will also require you to rename the Java file.
public class Thunderbird {
    public static void main(String[] args) {

        // Todo: Update the following line so that it reflects the name change to Thunderbird.
        // CJB: Completed
        System.out.println("Thunderbird Starting...");

        ThunderbirdLiteFrame myThunderbirdLiteFrame = new ThunderbirdLiteFrame();
        myThunderbirdLiteFrame.setVisible(true);
    }
}