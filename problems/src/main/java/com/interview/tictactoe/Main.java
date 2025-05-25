package com.interview.tictactoe;

import com.interview.tictactoe.controller.BoardGame;
import com.interview.tictactoe.controller.TicTacToeGame;
import com.interview.tictactoe.strategy.HumanPlayerStrategy;
import com.interview.tictactoe.strategy.PlayerStrategy;

public class Main {
    public static void main(String[] args) {
        PlayerStrategy playerStrategyX = new HumanPlayerStrategy("Player X");
        PlayerStrategy playerStrategyO = new HumanPlayerStrategy("Player O");

        BoardGame boardGame = new TicTacToeGame(playerStrategyX, playerStrategyO, 3, 3);
        boardGame.play();
    }
}
