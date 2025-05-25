package com.interview.tictactoe.state;

public interface GameState {
    public void next(GameContext context, GameStateEnum state);

    public boolean isGameOver();
}
