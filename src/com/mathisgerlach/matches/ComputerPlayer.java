package com.mathisgerlach.matches;

public class ComputerPlayer extends Player {

    private Strategy strategy = new Strategy();

    @Override
    int getMatchesToDraw(int remainingMatches) {
        return strategy.getMatches( remainingMatches );
    }

    @Override
    int getMatchesTotal(int matchesLimit) {
        int totalMatches = strategy.getStartingMatches( matchesLimit );
        System.out.println(this.getName() + " chose " + totalMatches + " matches for the current game.");
        return totalMatches;
    }

    public ComputerPlayer() {
        super("Computer");
    }
}
