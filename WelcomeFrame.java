
package com.mycompany.numberguessinggame.ui;

import java.awt.*;
import javax.swing.*;
import com.mycompany.numberguessinggame.util.ExitConfirmation;
public class WelcomeFrame extends JFrame {

    private JButton startButton;
    private JButton exitButton;
    private JLabel titleLabel;
    private JLabel subtitleLabel;

    public WelcomeFrame() {

        setTitle("Number Guessing Game");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLayout(null);

        titleLabel = new JLabel("NUMBER GUESSING GAME");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setBounds(120, 70, 500, 40);
        add(titleLabel);

        subtitleLabel = new JLabel("Guess the Secret Number and Win!");
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        subtitleLabel.setBounds(180, 130, 350, 30);
        add(subtitleLabel);

        startButton = new JButton("Start Game");
        startButton.setFont(new Font("Arial", Font.BOLD, 18));
        startButton.setBounds(240, 220, 200, 50);
        add(startButton);

        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 18));
        exitButton.setBounds(240, 300, 200, 50);
        add(exitButton);

        startButton.addActionListener(e -> {
            dispose();
            new PlayerNameFrame().setVisible(true);
        });
        exitButton.addActionListener(e -> {

        if (ExitConfirmation.confirmExit(WelcomeFrame.this)) {
           System.exit(0);
    }

});
     addWindowListener(new java.awt.event.WindowAdapter() {

    @Override
    public void windowClosing(java.awt.event.WindowEvent e) {

        if (ExitConfirmation.confirmExit(WelcomeFrame.this)) {
            System.exit(0);
        }

    }

});
    }
}
