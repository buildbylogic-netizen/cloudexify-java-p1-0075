package com.mycompany.numberguessinggame.ui;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import com.mycompany.numberguessinggame.game.Difficulty;
import com.mycompany.numberguessinggame.game.GameLogic;
import com.mycompany.numberguessinggame.util.ScoreManager;

public class GameFrame extends JFrame {

    private String playerName;
    private Difficulty difficulty;

    private GameLogic gameLogic;

    private JLabel titleLabel;
    private JLabel playerLabel;
    private JLabel difficultyLabel;
    private JLabel attemptsLabel;
    private JLabel scoreLabel;
    private JLabel instructionLabel;
    private JLabel messageLabel;

    private JTextField guessField;

    private JButton guessButton;
    private JButton tryAgainButton;
    private JButton mainMenuButton;

    public GameFrame(String playerName, Difficulty difficulty) {

        this.playerName = playerName;
        this.difficulty = difficulty;

        gameLogic = new GameLogic(difficulty);

        setTitle("Number Guessing Game");
        setSize(700, 550);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        titleLabel = new JLabel("GUESS THE SECRET NUMBER");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setBounds(140, 30, 500, 40);
        add(titleLabel);

        playerLabel = new JLabel("Player: " + playerName);
        playerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        playerLabel.setBounds(70, 100, 250, 30);
        add(playerLabel);

        difficultyLabel = new JLabel("Difficulty: " + difficulty);
        difficultyLabel.setFont(new Font("Arial", Font.BOLD, 18));
        difficultyLabel.setBounds(400, 100, 200, 30);
        add(difficultyLabel);

        attemptsLabel = new JLabel("Attempts Left: " + gameLogic.getAttemptsLeft());
        attemptsLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        attemptsLabel.setBounds(70, 150, 250, 30);
        add(attemptsLabel);

        scoreLabel = new JLabel("Score: " + gameLogic.getScore());
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        scoreLabel.setBounds(400, 150, 200, 30);
        add(scoreLabel);

        instructionLabel = new JLabel(
                "Enter a number between 1 and " + difficulty.getMaxNumber());
        instructionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        instructionLabel.setBounds(180, 220, 400, 30);
        add(instructionLabel);

        guessField = new JTextField();
        guessField.setFont(new Font("Arial", Font.PLAIN, 18));
        guessField.setBounds(250, 260, 200, 40);
        add(guessField);

        guessButton = new JButton("GUESS");
        guessButton.setFont(new Font("Arial", Font.BOLD, 16));
        guessButton.setBounds(250, 320, 200, 40);
        add(guessButton);

        messageLabel = new JLabel("Good Luck! Start Guessing.");
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        messageLabel.setBounds(200, 370, 400, 30);
        add(messageLabel);

        tryAgainButton = new JButton("Try Again");
        tryAgainButton.setBounds(150, 440, 150, 35);
        add(tryAgainButton);

        mainMenuButton = new JButton("Main Menu");
        mainMenuButton.setBounds(380, 440, 150, 35);
        add(mainMenuButton);

        guessButton.addActionListener(e -> checkGuess());

        tryAgainButton.addActionListener(e -> {

            gameLogic.startNewGame();

            updateLabels();

            guessField.setText("");

            guessField.setEnabled(true);

            guessButton.setEnabled(true);

            messageLabel.setText("New Game Started! Good Luck.");

        });

        mainMenuButton.addActionListener(e -> {

            dispose();

            new MenuFrame(playerName).setVisible(true);

        });

    }
    private void checkGuess() {

        try {

            int guess = Integer.parseInt(guessField.getText());

            String result = gameLogic.checkGuess(guess);

            if (result.equals("CORRECT")) {

                messageLabel.setText(" Congratulations! You Win!");

                // Save score automatically
                ScoreManager.saveScore(
                        playerName,
                        difficulty.toString(),
                        gameLogic.getScore()
                );

                JOptionPane.showMessageDialog(
                        this,
                        "Congratulations " + playerName
                        + "!\n\n"
                        + "Your Score: "
                        + gameLogic.getScore()
                );

                endGame();

            }

            else if (result.equals("TOO_LOW")) {

                messageLabel.setText("Try a higher number!");

            }

            else if (result.equals("TOO_HIGH")) {

                messageLabel.setText("Try a lower number!");

            }

            else if (result.equals("GAME_OVER")) {

                messageLabel.setText(" You Lost! Better Luck Next Time.");

                JOptionPane.showMessageDialog(
                        this,
                        "Game Over!\n\n"
                        + "The correct number was: "
                        + gameLogic.getSecretNumber()
                        + "\n\nClick Try Again to play again."
                );

                endGame();

            }

            updateLabels();

            guessField.setText("");

        }

        catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid number."
            );

        }

    }
    private void endGame() {

        guessButton.setEnabled(false);
        guessField.setEnabled(false);

    }



    private void updateLabels() {

        attemptsLabel.setText(
                "Attempts Left: "
                + gameLogic.getAttemptsLeft()
        );

        scoreLabel.setText(
                "Score: "
                + gameLogic.getScore()
        );

    }

}
