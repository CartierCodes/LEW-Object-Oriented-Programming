import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.ArrayList;
import java.util.Scanner;

public class VolleyFrame extends JFrame implements ActionListener {
    private Scanner input = new Scanner(System.in);
    private String teamServing = "null";

    private Team team1;
    private Team team2;

    private JButton leftScoredButton;
    private JButton rightScoredButton;
    private JButton resetButton;
    private JButton switchSidesButton;

    private Container contentPane;
    private JPanel courtPanel;
    private JPanel buttonPanel;

    private ScorePanel leftScorePanel;
    private ScorePanel rightScorePanel;

    public VolleyFrame() {
        setDefaultLookAndFeelDecorated(true);               // Todo: See if this does anything
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,800,800);                         // Todo: Make this relative to the size of the screen
        setTitle("Volleyball Book");

        team1 = new Team();
        team2 = new Team();

        fillPlayerNumbers();

        contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        courtPanel = new JPanel(new GridLayout(4, 4));
        buttonPanel = new JPanel();

        leftScorePanel = new ScorePanel();
        rightScorePanel = new ScorePanel();

        leftScoredButton = new JButton("Point Scored");
        leftScoredButton.addActionListener(this);
        buttonPanel.add(leftScoredButton);

        resetButton = new JButton("Reset");
        resetButton.addActionListener(this);
        buttonPanel.add(resetButton);

        switchSidesButton = new JButton("Switch Sides");
        switchSidesButton.addActionListener(this);
        buttonPanel.add(switchSidesButton);

        rightScoredButton = new JButton("Point Scored");
        rightScoredButton.addActionListener(this);
        buttonPanel.add(rightScoredButton);

        contentPane.add(courtPanel, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        fillCourtPanel();
    }

    public void fillCourtPanel() {
        courtPanel.add(new JPanel());
        courtPanel.add(leftScorePanel);
        courtPanel.add(new JPanel());
        courtPanel.add(rightScorePanel);
        courtPanel.add(new JPanel());
        
        courtPanel.add(new VolleyPanel(team1.getLineup().get(4)));
        courtPanel.add(new VolleyPanel(team1.getLineup().get(3)));
        courtPanel.add(new VolleyPanel("net"));
        courtPanel.add(new VolleyPanel(team2.getLineup().get(1)));
        courtPanel.add(new VolleyPanel(team2.getLineup().get(0)));

        courtPanel.add(new VolleyPanel(team1.getLineup().get(5)));
        courtPanel.add(new VolleyPanel(team1.getLineup().get(2)));
        courtPanel.add(new VolleyPanel("net"));
        courtPanel.add(new VolleyPanel(team2.getLineup().get(2)));
        courtPanel.add(new VolleyPanel(team2.getLineup().get(5)));

        courtPanel.add(new VolleyPanel(team1.getLineup().get(0)));
        courtPanel.add(new VolleyPanel(team1.getLineup().get(1)));
        courtPanel.add(new VolleyPanel("net"));
        courtPanel.add(new VolleyPanel(team2.getLineup().get(3)));
        courtPanel.add(new VolleyPanel(team2.getLineup().get(4)));
    }

    public void fillPlayerNumbers() {
        System.out.println("\nPlease enter each player's number");

        System.out.print("\nTEAM 1 - Player Number in Row 1: ");
        team1.addToLineup(input.next());
        System.out.print("TEAM 1 - Player Number in Row 2: ");
        team1.addToLineup(input.next());
        System.out.print("TEAM 1 - Player Number in Row 3: ");
        team1.addToLineup(input.next());
        System.out.print("TEAM 1 - Player Number in Row 4: ");
        team1.addToLineup(input.next());
        System.out.print("TEAM 1 - Player Number in Row 5: ");
        team1.addToLineup(input.next());
        System.out.print("TEAM 1 - Player Number in Row 6: ");
        team1.addToLineup(input.next());

        System.out.print("\nTEAM 2 - Player Number in Row 1: ");
        team2.addToLineup(input.next());
        System.out.print("TEAM 2 - Player Number in Row 2: ");
        team2.addToLineup(input.next());
        System.out.print("TEAM 2 - Player Number in Row 3: ");
        team2.addToLineup(input.next());
        System.out.print("TEAM 2 - Player Number in Row 4: ");
        team2.addToLineup(input.next());
        System.out.print("TEAM 2 - Player Number in Row 5: ");
        team2.addToLineup(input.next());
        System.out.print("TEAM 2 - Player Number in Row 6: ");
        team2.addToLineup(input.next());

        System.out.print("\nEnter which side has the first serve... ");
        teamServing = input.next();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == leftScoredButton) {
            leftScorePanel.awardPoint();
            if (teamServing.equalsIgnoreCase("right")) {
                team1.rotate();
            }
            teamServing = "left";

            courtPanel.removeAll();
            fillCourtPanel();
            repaint();
            revalidate();
        }
        else if (e.getSource() == rightScoredButton) {
            rightScorePanel.awardPoint();
            if (teamServing.equalsIgnoreCase("left")) {
                team2.rotate();
            }
            teamServing = "right";

            courtPanel.removeAll();
            fillCourtPanel();
            repaint();
            revalidate();
        }
        else if (e.getSource() == resetButton) {
            team1.resetLineup();
            team2.resetLineup();

            teamServing = "null";

            leftScorePanel.resetScore();
            rightScorePanel.resetScore();

            courtPanel.removeAll();
            fillCourtPanel();
            repaint();
            revalidate();
        }
        else if (e.getSource() == switchSidesButton) {
            Team tempTeam = team1;
            team1 = team2;
            team2 = tempTeam;

            ScorePanel tempPanel = leftScorePanel;
            leftScorePanel = rightScorePanel;
            rightScorePanel = tempPanel;

            courtPanel.removeAll();
            fillCourtPanel();
            repaint();
            revalidate();
        }
    }
}