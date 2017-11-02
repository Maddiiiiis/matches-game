package com.mathisgerlach;

import java.util.Scanner;

public class HumanPlayer extends Player {

    private static Scanner userInput = new Scanner(System.in);

    @Override
    int getMatchesToDraw(int matchesRemaining) {
        System.out.println("Please enter how many matches you want to draw:\n");
        return userInput.nextInt();
    }

    @Override
    int getMatchesTotal(int matchesLimit) {
        System.out.println("Please enter the amount of matches you want to play with (max " + matchesLimit + "):\n");
        return userInput.nextInt();
    }

    public HumanPlayer() {
        super("Player");
    }

}
