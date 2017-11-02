package com.mathisgerlach;

public abstract class Player {

    private String name;
    public boolean isWinner = false;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void informAboutMove() {
        System.out.println( getName() + "s turn." );
    }

    abstract int getMatchesTotal(int matchesMax);
    abstract int getMatchesToDraw(int remainingMatches);
}
