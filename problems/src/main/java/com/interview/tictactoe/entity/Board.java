package com.interview.tictactoe.entity;

import com.interview.tictactoe.state.GameContext;
import com.interview.tictactoe.state.GameStateEnum;

public class Board {
    private int rows, cols;
    private Symbol[][] grid;

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new Symbol[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = Symbol.EMPTY;
            }
        }
    }

    public boolean isValidMove(Position move) {
        return move.row >= 0 && move.row < rows && move.col >= 0 && move.col < cols && grid[move.row][move.col] == Symbol.EMPTY;
    }

    public void setMove(Position move, Symbol symbol) {
        grid[move.row][move.col] = symbol;
    }

    public void printBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == Symbol.X) {
                    System.out.print(" X ");
                } else if (grid[i][j] == Symbol.O) {
                    System.out.print(" O ");
                } else {
                    System.out.print(" . ");
                }
                if (j != cols - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i != rows - 1) {
                System.out.println("---+---+---");
            }
        }
        System.out.println();
    }

    public void checkGameState(GameContext context) {
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] != Symbol.EMPTY && isWinningLine(grid[i])) {
                context.next(GameStateEnum.WON);
                return;
            }
        }
        for (int i = 0; i < cols; i++) {
            Symbol[] column = new Symbol[rows];
            for (int j = 0; j < rows; j++) {
                column[j] = grid[j][i];
            }
            if (column[0] != Symbol.EMPTY && isWinningLine(column)) {
                context.next(GameStateEnum.WON);
                return;
            }
        }
        Symbol[] diagonal1 = new Symbol[Math.min(rows, cols)];
        Symbol[] diagonal2 = new Symbol[Math.min(rows, cols)];
        for (int i = 0; i < Math.min(rows, cols); i++) {
            diagonal1[i] = grid[i][i];
            diagonal2[i] = grid[i][cols - 1 - i];
        }
        if (diagonal1[0] != Symbol.EMPTY && isWinningLine(diagonal1)) {
            context.next(GameStateEnum.WON);
            return;
        }
        if (diagonal2[0] != Symbol.EMPTY && isWinningLine(diagonal2)) {
            context.next(GameStateEnum.WON);
            return;
        }

        if (countMoveLeft() == 0) {
            context.next(GameStateEnum.DRAW);
        }
    }

    public int countMoveLeft() {
        int moveLeft = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == Symbol.EMPTY) {
                    moveLeft++;
                }
            }

        }
        return moveLeft;
    }

    private boolean isWinningLine(Symbol[] line) {
        Symbol first = line[0];
        for (Symbol s : line) {
            if (s != first) {
                return false;
            }
        }
        return true;
    }
}
