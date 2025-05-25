package com.interview.tictactoe.state;

public class OTurnState implements GameState {

    @Override
    public void next(GameContext context, GameStateEnum state) {
        if (GameStateEnum.WON.equals(state)) {
            context.gameState = new OWonState();
        } else if (GameStateEnum.DRAW.equals(state)) {
            context.gameState = new DrawState();
        } else {
            context.gameState = new XTurnState();
        }
    }

    @Override
    public boolean isGameOver() {
        return false;
    }
}
