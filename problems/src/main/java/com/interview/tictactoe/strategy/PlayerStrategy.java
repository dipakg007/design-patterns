package com.interview.tictactoe.strategy;

import com.interview.tictactoe.entity.Board;
import com.interview.tictactoe.entity.Position;

public interface PlayerStrategy {
    public Position makeMove(Board board);
}
