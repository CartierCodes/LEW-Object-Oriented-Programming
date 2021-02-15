import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ActionListenerPlus
{
    public static void main(String[] args)
    {
        System.out.println("Hello ActionListenerPlus!");

        ButtonFrame myButtonFrame = new ButtonFrame();
        myButtonFrame.setVisible(true);
    }
}

class ButtonFrame extends JFrame implements ActionListener
{
    JButton button1;
    JButton button4;

    public ButtonFrame()
    {
        setBounds(100, 100, 600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel myButtonPanel = new JPanel();
        myButtonPanel.setLayout(new FlowLayout());

        button1 = new JButton("Button 1");
        button1.addActionListener(this);

        JButton button2 = new JButton("Button 2");
        button2.addActionListener(new SeperateActionListener());

        JButton button3 = new JButton("Button 3");
        button3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("Anonymous::actionPerformed");
            }
        });

        button4 = new JButton("Button 4");
        button4.addActionListener(this);

        myButtonPanel.add(button1);
        myButtonPanel.add(button2);
        myButtonPanel.add(button3);
        myButtonPanel.add(button4);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(myButtonPanel, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == button1)
            System.out.println("myButtonFrame::actionPerformed!");
        else if (e.getSource() == button4)
            System.out.println("myButtonFrome::actionPerformed...Button4!");
    }
}

class SeperateActionListener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        System.out.println("SeperateActionListener::actionPerformed!");
    }
}