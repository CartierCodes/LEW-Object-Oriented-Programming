import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//import java.awt.event.MouseListener;
//import java.awt.event.MouseEvent; 

public class VolleyPanel extends JPanel {
    private String playerNumber;

    public VolleyPanel(String s) {
        playerNumber = s;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int panelWidth = getWidth();
        int panelHeight = getHeight();
        
        g.setFont(new Font("Ariel", Font.PLAIN, (panelWidth + panelHeight) / 4));
        if (playerNumber.equalsIgnoreCase("net")) {
            g.setColor(new Color(0, 0, 0));
            g.drawLine(panelWidth / 2, 0, panelWidth / 2, panelHeight);
        }
        else {
            g.setColor(new Color(255, 0, 0));
            g.drawString(playerNumber, (panelWidth / 2) - (g.getFont().getSize() / 3), (panelHeight / 2) + (g.getFont().getSize() / 3));
        }
    }
}