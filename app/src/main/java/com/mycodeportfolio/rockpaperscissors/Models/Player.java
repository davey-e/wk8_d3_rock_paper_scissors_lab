package com.mycodeportfolio.rockpaperscissors.Models;


import com.mycodeportfolio.rockpaperscissors.Enums.EnumMove;

public class Player {

    private int score;
    private EnumMove move;

    public Player(){
        this.score = 0;
    }

    public int getScore() {
        return this.score;
    }

    public void addPoint() {
        this.score += 1;
    }

    public EnumMove getMove() {
        return this.move;
    }

    public void setMove(EnumMove move) {
        this.move = move;
    }
}
