import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import java.awt.event.MouseListener;
//import java.awt.event.MouseEvent; 

//import java.util.ArrayList;
//import java.util.Random;
//import java.util.Scanner;
//import java.awt.Graphics;
//import java.awt.Color;
//import java.awt.Font;

public class AmazonProductFrame extends JFrame implements ActionListener {
    private String searchString;
    private String categoryString;
    private String[] categoryList = {
    "All Departments", "Appliances", "Arts, Crafts & Sewing", "Automotive", "Baby", "Beauty", "Books",
    "Cell Phones & Accessories", "Computers", "Electronics", "Home & Kitchen", "Luggage & Travel Gear",
    "Office Products", "Patio, Lawn & Garden", "Pet Supplies", "Sports & Outdoors", "Tools & Home Improvement",
    "Toys & Games", "Video Games" };                        // Todo: Filter out the ones that are not needed

    private Container contentPane;
    private JPanel gridPanel;
    private JPanel buttonPanel;

    private JTextField textField;
    private JComboBox<String> comboBox;
    private JButton refreshButton;
    private JButton searchButton;

    public AmazonProductFrame() {
        setDefaultLookAndFeelDecorated(true);               // Todo: See if this does anything
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,800,800);                         // Todo: Make this relative to the size of the screen
        setTitle("Captialist Workbench");

        searchString = "";
        categoryString = "";

        contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        gridPanel = new JPanel(new GridLayout(10, 2));
        buttonPanel = new JPanel();

        refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(this);
        buttonPanel.add(refreshButton);

        searchButton = new JButton("Search");
        searchButton.addActionListener(this);
        buttonPanel.add(searchButton);

        textField = new JTextField(20);
        buttonPanel.add(textField);

        comboBox = new JComboBox<String>(categoryList);
        comboBox.setSelectedIndex(0);
        buttonPanel.add(comboBox);

        contentPane.add(gridPanel, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.NORTH);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == refreshButton) {
            // Todo: Add refresh functionality by loading each panel+
        }
        else if (e.getSource() == searchButton) {
            // Todo: Add search functionality using textField.getText() and comboBox.getSelectedItem();
        }
    }
}