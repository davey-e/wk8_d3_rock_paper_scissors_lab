package com.mycodeportfolio.rockpaperscissors.Models;


import com.mycodeportfolio.rockpaperscissors.Enums.EnumMove;

public class Player {

    private Integer score;
    private EnumMove move;
    private String name;

    public Player(String name){
        this.score = 0;
        this.name = name;
    }

    public Integer getScore() {
        return this.score;
    }

    public String getName(){
        return this.name;
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
