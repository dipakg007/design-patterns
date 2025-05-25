package com.interview.tictactoe.state;

public class XWonState implements GameState {

    @Override
    public void next(GameContext context, GameStateEnum state) {

    }

    @Override
    public boolean isGameOver() {
        return true;
    }
}
