package com.mathisgerlach;

public class MatchesGame {
    private int remainingMatches;
    private static final int MATCHES_LIMIT = 30;
    private static final int MATCHES_DRAWING_MAX = 3;
    private HumanPlayer human = new HumanPlayer();
    private ComputerPlayer computer = new ComputerPlayer();
    private Player currentPlayer;

    public void startGame() {
        setRandomStartingPlayer();
        setNumberOfTotalMatches();
        gameLoop();
        informAboutResult();
    }

    private void setRandomStartingPlayer() {
        currentPlayer = getRandomPlayer();
    }

    private void setNumberOfTotalMatches() {
        remainingMatches = currentPlayer.getMatchesTotal( MATCHES_LIMIT );
    }

    private void gameLoop() {
        while( isRunning() ) {
            nextPlayer();
            makeMove( currentPlayer );
        }
    }

    private void makeMove(Player player) {
        player.informAboutMove();
        drawMatches( player );

        if( !isRunning() ){
            setWinningPlayer();
        }
    }

    private boolean isValidMove( int matchesToDraw ) {
        if( matchesToDraw <= 0
                || matchesToDraw > MATCHES_DRAWING_MAX
                || matchesToDraw > remainingMatches ) {
            System.out.println( matchesToDraw + " is not valid.\n" );
            return false;
        }
        return true;
    }

    private boolean isRunning() {
        if( remainingMatches > 1 ) {
            return true;
        }
        return false;
    }

    private void nextPlayer() {
        if(!currentPlayer.isWinner) {
            currentPlayer = getNextPlayer();
        }
    }

    private void drawMatches(Player player){
        int matchesToDraw;

        do {
            matchesToDraw = player.getMatchesToDraw( remainingMatches );
        } while ( !isValidMove( matchesToDraw ) );

        remainingMatches -= matchesToDraw;

        System.out.println( currentPlayer.getName() + " has drawn " + matchesToDraw + " match(es).\n"
                + remainingMatches + " match(es) left in the game.\n" );
    }

    private void setWinningPlayer() {
        if( remainingMatches == 1 ) {
            currentPlayer.isWinner = true;
        } else if(remainingMatches == 0) {
            getNextPlayer().isWinner = true;
        }
    }

    private Player getWinningPlayer() {
        return currentPlayer.isWinner ? currentPlayer : getNextPlayer();
    }

    private void informAboutResult( ) {
        System.out.println(getWinningPlayer().getName() + " has won the game.");
    }

    private Player getNextPlayer() {
        return ( currentPlayer == human ? computer : human );
    }

    private Player getRandomPlayer() {
        int result = getRandomNumber(0, 2);
        if(result == 0){
            return human;
        }else{
            return computer;
        }
    }

    private int getRandomNumber(int min, int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }
}
