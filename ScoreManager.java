package com.mycompany.numberguessinggame.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;


public class ScoreManager {


    private static final String FILE_NAME = "scores.txt";
    public static void saveScore(String playerName, String difficulty, int score) {
        try {


            FileWriter writer = new FileWriter(FILE_NAME, true);


            writer.write(
                    "Player: " + playerName +
                    " | Difficulty: " + difficulty +
                    " | Score: " + score +
                    "\n"
            );


            writer.close();


        } catch (IOException e) {


            System.out.println("Error saving score.");

        }

    }

    public static String getScores() {


        StringBuilder scores = new StringBuilder();


        try {


            File file = new File(FILE_NAME);


            if (!file.exists()) {

                return "No previous scores found.";

            }



            Scanner scanner = new Scanner(file);



            while(scanner.hasNextLine()) {

                scores.append(scanner.nextLine());
                scores.append("\n");

            }



            scanner.close();



        } catch (IOException e) {


            return "Unable to read scores.";

        }



        return scores.toString();

    }

}
