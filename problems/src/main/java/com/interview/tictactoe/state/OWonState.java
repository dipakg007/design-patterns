package com.interview.tictactoe.state;

public class OWonState implements GameState {
    @Override
    public void next(GameContext context, GameStateEnum state) {

    }

    @Override
    public boolean isGameOver() {
        return true;
    }
}
