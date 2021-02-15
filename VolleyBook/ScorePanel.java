import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//import java.awt.event.MouseListener;
//import java.awt.event.MouseEvent; 

public class ScorePanel extends JPanel {
    private int score;

    public ScorePanel() {
        score = 0;
    }

    public void awardPoint() {
        score ++;
    }

    public void resetScore() {
        score = 0;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        g.setColor(new Color(0, 0, 0));
        g.drawRect(0, 0, panelWidth - 1, panelHeight - 1);

        g.setColor(new Color(255, 0, 0));
        g.setFont(new Font("Ariel", Font.PLAIN, (panelWidth + panelHeight) / 4));
        g.drawString(Integer.toString(score), (panelWidth / 2) - (g.getFont().getSize() / 3), (panelHeight / 2) + (g.getFont().getSize() / 3));
    }
}