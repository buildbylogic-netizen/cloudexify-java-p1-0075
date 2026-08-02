package com.mycompany.numberguessinggame.game;

import java.util.Random;


public class GameLogic {

    private int secretNumber;
    private int attemptsLeft;
    private int score;

    private Difficulty difficulty;


    public GameLogic(Difficulty difficulty) {

        this.difficulty = difficulty;

        startNewGame();

    }


    public void startNewGame() {

        Random random = new Random();


        secretNumber = random.nextInt(
                difficulty.getMaxNumber()
        ) + 1;


        attemptsLeft = difficulty.getAttempts();


        score = 0;

    }


    public String checkGuess(int guess) {


        if (attemptsLeft <= 0) {

            return "GAME_OVER";

        }


        attemptsLeft--;



        if (guess == secretNumber) {

            calculateScore();

            return "CORRECT";

        }



        if (attemptsLeft == 0) {

            return "GAME_OVER";

        }



        if (guess < secretNumber) {

            return "TOO_LOW";

        }


        return "TOO_HIGH";

    }


    private void calculateScore() {


        int baseScore;


        switch (difficulty) {


            case EASY:

                baseScore = 50;

                break;



            case MEDIUM:

                baseScore = 100;

                break;



            case HARD:

                baseScore = 150;

                break;



            default:

                baseScore = 50;

        }



        score = baseScore + (attemptsLeft * 10);

    }



    public int getAttemptsLeft() {

        return attemptsLeft;

    }



    public int getScore() {

        return score;

    }



    public int getSecretNumber() {

        return secretNumber;

    }



    public Difficulty getDifficulty() {

        return difficulty;

    }



    public void resetGame() {

        startNewGame();

    }

}
