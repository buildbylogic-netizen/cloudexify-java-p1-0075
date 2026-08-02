package com.mycompany.numberguessinggame.ui;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

import com.mycompany.numberguessinggame.util.ScoreManager;
import com.mycompany.numberguessinggame.game.Difficulty;

public class MenuFrame extends JFrame {

    private String playerName;

    private JLabel titleLabel;
    private JLabel welcomeLabel;

    private JPanel easyPanel;
    private JPanel mediumPanel;
    private JPanel hardPanel;

    private JButton easyButton;
    private JButton mediumButton;
    private JButton hardButton;

    private JButton scoreButton;
    private JButton howToPlayButton;
    private JButton mainMenuButton;

    public MenuFrame(String playerName) {

        this.playerName = playerName;

        setTitle("Choose Your Challenge");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        titleLabel = new JLabel("SELECT YOUR CHALLENGE");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setBounds(210, 30, 450, 40);
        add(titleLabel);

        welcomeLabel = new JLabel("Welcome, " + playerName);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setBounds(300, 80, 300, 30);
        add(welcomeLabel);

        easyPanel = new JPanel();
        easyPanel.setLayout(null);
        easyPanel.setBounds(70, 150, 200, 180);
        add(easyPanel);

        JLabel easyText = new JLabel(
                "<html>EASY MODE<br>Range: 1-100<br>Attempts: 10</html>");
        easyText.setFont(new Font("Arial", Font.BOLD, 16));
        easyText.setBounds(35, 20, 150, 60);
        easyPanel.add(easyText);

        easyButton = new JButton("PLAY EASY");
        easyButton.setBounds(30, 110, 140, 35);
        easyPanel.add(easyButton);

     
        mediumPanel = new JPanel();
        mediumPanel.setLayout(null);
        mediumPanel.setBounds(300, 150, 200, 180);
        add(mediumPanel);

        JLabel mediumText = new JLabel(
                "<html>MEDIUM MODE<br>Range: 1-300<br>Attempts: 7</html>");
        mediumText.setFont(new Font("Arial", Font.BOLD, 16));
        mediumText.setBounds(35, 20, 150, 60);
        mediumPanel.add(mediumText);

        mediumButton = new JButton("PLAY MEDIUM");
        mediumButton.setBounds(30, 110, 140, 35);
        mediumPanel.add(mediumButton);
        
        hardPanel = new JPanel();
        hardPanel.setLayout(null);
        hardPanel.setBounds(530, 150, 200, 180);
        add(hardPanel);

        JLabel hardText = new JLabel(
                "<html>HARD MODE<br>Range: 1-500<br>Attempts: 5</html>");
        hardText.setFont(new Font("Arial", Font.BOLD, 16));
        hardText.setBounds(35, 20, 150, 60);
        hardPanel.add(hardText);

        hardButton = new JButton("PLAY HARD");
        hardButton.setBounds(30, 110, 140, 35);
        hardPanel.add(hardButton);



        scoreButton = new JButton("Previous Scores");
        scoreButton.setBounds(90, 400, 180, 40);
        add(scoreButton);

        howToPlayButton = new JButton("How to Play");
        howToPlayButton.setBounds(310, 400, 180, 40);
        add(howToPlayButton);

        mainMenuButton = new JButton("Main Menu");
        mainMenuButton.setBounds(530, 400, 180, 40);
        add(mainMenuButton);

     

        scoreButton.addActionListener(e -> {

            String scores = ScoreManager.getScores();

            JOptionPane.showMessageDialog(
                    this,
                    scores,
                    "Previous Scores",
                    JOptionPane.INFORMATION_MESSAGE
            );

        });



        howToPlayButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    this,

                    "HOW TO PLAY\n\n"

                    + "1. Choose a difficulty level.\n\n"

                    + "Easy\n"
                    + "• Range: 1-100\n"
                    + "• Attempts: 10\n\n"

                    + "Medium\n"
                    + "• Range: 1-300\n"
                    + "• Attempts: 7\n\n"

                    + "Hard\n"
                    + "• Range: 1-500\n"
                    + "• Attempts: 5\n\n"

                    + "GAME RULES\n\n"

                    + "• Enter one number at a time.\n"
                    + "• If your guess is too low, the game will tell you to try a higher number.\n"
                    + "• If your guess is too high, the game will tell you to try a lower number.\n"
                    + "• Guess the secret number before your attempts run out.\n"
                    + "• Your score is calculated based on your performance.\n"
                    + "• Winning scores are saved automatically.\n"
                    + "• You can view your saved scores by clicking \"Previous Scores\".\n\n"

                    + "Good Luck and Have Fun!",

                    "How to Play",

                    JOptionPane.INFORMATION_MESSAGE

            );

        });

        
        easyButton.addActionListener(e -> {

            dispose();
            new GameFrame(playerName, Difficulty.EASY).setVisible(true);

        });

        mediumButton.addActionListener(e -> {

            dispose();
            new GameFrame(playerName, Difficulty.MEDIUM).setVisible(true);

        });

        hardButton.addActionListener(e -> {

            dispose();
            new GameFrame(playerName, Difficulty.HARD).setVisible(true);

        });

        
        mainMenuButton.addActionListener(e -> {

            dispose();
            new WelcomeFrame().setVisible(true);

        });

    }

}
