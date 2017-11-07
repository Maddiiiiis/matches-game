package com.mathisgerlach.matches;

public class Strategy {

    private final int MATCHES_DRAWING_MAX = 3;

    public int getMatches(int matchesRemaining) {
        return getMatchesWithStrategy( matchesRemaining );
    }

    public int getStartingMatches(int matchesLimit ) {
        return getRandomMatchesWithStrategy( matchesLimit );
    }

    private int getRandomMatchesWithStrategy(int matchesMax) {
        int result;
        do{
            result = getRandomInt(MATCHES_DRAWING_MAX, matchesMax );
        } while (!isWinningNumber( result ));

        return result;
    }

    private int getMatchesWithStrategy( int matchesRemaining ) {
        int number = 1;
        for (int i = number; i <= MATCHES_DRAWING_MAX; i++) {
            int numberToCheck = matchesRemaining - i;
            if( isWinningNumber(numberToCheck) ){
                return i;
            }
        }
        return getRandomInt(1, 3);
    }

    private boolean isWinningNumber( int number ) {
       return  (number - 1)  % 4 == 0;
    }

    private int getRandomInt(int min, int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }

    public Strategy() {
    }
}
