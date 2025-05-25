package com.interview.tictactoe.state;

public class GameContext {
    public GameState gameState;

    public GameContext(GameState gameState) {
        this.gameState = gameState;
    }

    public void next(GameStateEnum state) {
        gameState.next(this, state);
    }
}
