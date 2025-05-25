package com.interview.tictactoe.entity;

import com.interview.tictactoe.strategy.PlayerStrategy;

public class Player {
    public PlayerStrategy playerStrategy;
    public Symbol symbol;

    public Player(PlayerStrategy playerStrategy, Symbol symbol) {
        this.playerStrategy = playerStrategy;
        this.symbol = symbol;
    }
}
