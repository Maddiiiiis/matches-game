package com.mathisgerlach.matches;

public class Main {
    private static MatchesGame matchesGame = new MatchesGame();

    /**
     * Starts the matches game
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the matches game!");
        matchesGame.startGame();
    }
}
