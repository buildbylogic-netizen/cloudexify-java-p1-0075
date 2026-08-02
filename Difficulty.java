package com.mycompany.numberguessinggame.game;

public enum Difficulty {

    EASY(100, 10),
    MEDIUM(300, 7),
    HARD(500, 5);

    private final int maxNumber;
    private final int attempts;


    Difficulty(int maxNumber, int attempts) {

        this.maxNumber = maxNumber;
        this.attempts = attempts;

    }


    public int getMaxNumber() {

        return maxNumber;

    }


    public int getAttempts() {

        return attempts;

    }

}
