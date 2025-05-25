package com.interview.tictactoe.controller;

import com.interview.tictactoe.entity.Board;
import com.interview.tictactoe.entity.Player;
import com.interview.tictactoe.entity.Position;
import com.interview.tictactoe.entity.Symbol;
import com.interview.tictactoe.state.*;
import com.interview.tictactoe.strategy.PlayerStrategy;

public class TicTacToeGame implements BoardGame {
    public Board board;
    public Player playerX;
    public Player playerO;
    public Player currentPlayer;
    public GameContext gameContext;

    public TicTacToeGame(PlayerStrategy playerStrategyX, PlayerStrategy playerStrategyO, int rows, int cols) {
        this.board = new Board(rows, cols);
        this.playerX = new Player(playerStrategyX, Symbol.X);
        this.playerO = new Player(playerStrategyO, Symbol.O);
        this.currentPlayer = playerX;
        this.gameContext = new GameContext(new XTurnState());
    }

    @Override
    public void play() {
        do {
            board.printBoard();
            // make move;
            Position move = currentPlayer.playerStrategy.makeMove(board);
            // set the move to board
            board.setMove(move, currentPlayer.symbol);
            // check state of board
            board.checkGameState(gameContext);
            // switch player
            switchPlayer();
        } while (!gameContext.gameState.isGameOver());

        // announce game result
        announceResult();
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }

    // Displays the outcome of the game based on the final game state.
    private void announceResult() {
        GameState state = gameContext.gameState;
        board.printBoard();
        if (state instanceof XWonState) {
            System.out.println("Player X wins!");
        } else if (state instanceof OWonState) {
            System.out.println("Player O wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }
}
