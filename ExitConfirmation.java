package com.mycompany.numberguessinggame.util;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ExitConfirmation {

    public static boolean confirmExit(JFrame frame) {

        int choice = JOptionPane.showConfirmDialog(
                frame,
                "Are you sure you want to exit the game?",
                "Exit Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        return choice == JOptionPane.YES_OPTION;
    }
}
