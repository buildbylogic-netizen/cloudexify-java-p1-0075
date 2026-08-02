package com.mycompany.numberguessinggame.ui;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class package com.mycompany.numberguessinggame.ui;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class PlayerNameFrame extends JFrame {

    private JLabel titleLabel;
    private JLabel nameLabel;

    private JTextField nameField;

    private JButton continueButton;
    private JButton backButton;


    public PlayerNameFrame() {

        setTitle("Player Name");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        titleLabel = new JLabel("ENTER YOUR NAME");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setBounds(180, 60, 400, 40);
        add(titleLabel);


        nameLabel = new JLabel("Player Name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        nameLabel.setBounds(180, 160, 150, 30);
        add(nameLabel);


        nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.PLAIN, 18));
        nameField.setBounds(320, 160, 200, 35);
        add(nameField);


        continueButton = new JButton("Continue");
        continueButton.setFont(new Font("Arial", Font.BOLD, 18));
        continueButton.setBounds(250, 250, 180, 45);
        add(continueButton);


        backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 18));
        backButton.setBounds(250, 320, 180, 45);
        add(backButton);



        continueButton.addActionListener(e -> {

            String playerName = nameField.getText().trim();


            if (playerName.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter your name."
                );

            } else {

                dispose();

                new MenuFrame(playerName).setVisible(true);

            }

        });



        backButton.addActionListener(e -> {

            dispose();

            new WelcomeFrame().setVisible(true);

        });

    }
}
 extends JFrame {

    private JLabel titleLabel;
    private JLabel nameLabel;

    private JTextField nameField;

    private JButton continueButton;
    private JButton backButton;


    public PlayerNameFrame() {

        setTitle("Player Name");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        titleLabel = new JLabel("ENTER YOUR NAME");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setBounds(180, 60, 400, 40);
        add(titleLabel);


        nameLabel = new JLabel("Player Name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        nameLabel.setBounds(180, 160, 150, 30);
        add(nameLabel);


        nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.PLAIN, 18));
        nameField.setBounds(320, 160, 200, 35);
        add(nameField);


        continueButton = new JButton("Continue");
        continueButton.setFont(new Font("Arial", Font.BOLD, 18));
        continueButton.setBounds(250, 250, 180, 45);
        add(continueButton);


        backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 18));
        backButton.setBounds(250, 320, 180, 45);
        add(backButton);



        continueButton.addActionListener(e -> {

            String playerName = nameField.getText().trim();


            if (playerName.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter your name."
                );

            } else {

                dispose();

                new MenuFrame(playerName).setVisible(true);

            }

        });



        backButton.addActionListener(e -> {

            dispose();

            new WelcomeFrame().setVisible(true);

        });

    }
}
