package com.interview.tictactoe.state;

public class XTurnState implements GameState {
    @Override
    public void next(GameContext context, GameStateEnum state) {
        if (GameStateEnum.WON.equals(state)) {
            context.gameState = new XWonState();
        } else if (GameStateEnum.DRAW.equals(state)) {
            context.gameState = new DrawState();
        } else {
            context.gameState = new OTurnState();
        }
    }

    @Override
    public boolean isGameOver() {
        return false;
    }
}
