package com.mathisgerlach;

public class Strategy {

    private boolean[] winningStrategyTable;
    private final int MATCHES_DRAWING_MAX = 3;
    private static final int MATCHES_LIMIT = 30;

    public int getMatches(int matchesRemaining) {
        return getMatchesFromStrategyTable(matchesRemaining);
    }

    public int getStartingNumber(int matchesTotal ) {
        return getStartingNumberFromStrategyTable( matchesTotal );
    }

    private int getStartingNumberFromStrategyTable(int matchesMax) {
        int result;
        do{
            result = getRandomInt(MATCHES_DRAWING_MAX, matchesMax );
        } while (!isWinningNumber( result ));

        return result;
    }

    private int getMatchesFromStrategyTable( int matchesRemaining ) {
        int number = 1;
        for (int i = number; i <= MATCHES_DRAWING_MAX; i++) {
            int numberToCheck = matchesRemaining - i;
            if( isWinningNumber(numberToCheck) ){
                return i;
            }
        }
        return getRandomInt(1, 3);
    }

    private void preparewinningStrategyTable( int tableSize ) {

        winningStrategyTable = new boolean[tableSize + 1];
        winningStrategyTable[0] = false;
        winningStrategyTable[1] = false;
        winningStrategyTable[2] = true;
        winningStrategyTable[3] = true;

        int i = MATCHES_DRAWING_MAX;

        while (i < tableSize) {
            i = i + 1;

            if( winningStrategyTable[i-3] == winningStrategyTable[i-2] == winningStrategyTable[i-1] == true ){
                winningStrategyTable[i] = false;
            } else {
                winningStrategyTable[i] = true;
            }
        }
    }

    private boolean isWinningNumber( int number ) {
        return !winningStrategyTable[number];
    }

    private int getRandomInt(int min, int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }

    public Strategy() {
        preparewinningStrategyTable(MATCHES_LIMIT);
    }
}
