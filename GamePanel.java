
package com.mycompany.numberguessinggame.ui;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GamePanel extends JPanel {

    private JLabel titleLabel;
    private JLabel instructionLabel;
    private JTextField guessField;
    private JButton guessButton;
    private JLabel resultLabel;

    private int secretNumber;

    public GamePanel() {

        setLayout(new FlowLayout());

        Random random = new Random();
        secretNumber = random.nextInt(100) + 1;

        titleLabel = new JLabel("Number Guessing Game");
        instructionLabel = new JLabel("Guess a number between 1 and 100:");

        guessField = new JTextField(10);

        guessButton = new JButton("Guess");

        resultLabel = new JLabel(" ");

        add(titleLabel);
        add(instructionLabel);
        add(guessField);
        add(guessButton);
        add(resultLabel);

        guessButton.addActionListener(e -> {

            try {

                int guess = Integer.parseInt(guessField.getText());

                if (guess < secretNumber) {
                    resultLabel.setText("Too Low!");
                } else if (guess > secretNumber) {
                    resultLabel.setText("Too High!");
                } else {
                    resultLabel.setText("Congratulations! You guessed it!");
                }

            } catch (NumberFormatException ex) {

                resultLabel.setText("Please enter a valid number.");

            }

        });

    }

}
