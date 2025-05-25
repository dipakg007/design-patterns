package com.interview.tictactoe.strategy;

import com.interview.tictactoe.entity.Board;
import com.interview.tictactoe.entity.Position;

import java.util.Scanner;

public class HumanPlayerStrategy implements PlayerStrategy {
    private Scanner scanner;
    private String playerName;

    public HumanPlayerStrategy(String playerName) {
        this.playerName = playerName;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Position makeMove(Board board) {
        while (true) {
            System.out.printf("%s please make a move between [0-2] : ", playerName);
            try {
                int rowMove = scanner.nextInt();
                int colMove = scanner.nextInt();
                Position move = new Position(rowMove, colMove);
                if (board.isValidMove(move)) {
                    return move;
                } else {
                    System.out.println("Invalid move! try again");
                }
            } catch (Exception ex) {
                System.out.println("Please enter a number!");
            }
        }
    }
}
