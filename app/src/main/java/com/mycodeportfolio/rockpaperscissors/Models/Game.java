package com.mycodeportfolio.rockpaperscissors.Models;

import com.mycodeportfolio.rockpaperscissors.Enums.EnumMove;

public class Game {
    private Player player;
    private Computer computer;
    private Integer totalRounds;
    private Integer currentRound;
    private Player overallWinner;

    public Game(Integer totalRounds) {
        this.player = new Player();
        this.computer = new Computer();
        this.totalRounds = totalRounds > 0 ? totalRounds : 1;
        this.currentRound = 1;
    }

    public Player getPlayer() {
        return this.player;
    }

    public Computer getComputer() {
        return this.computer;
    }

    public Integer getTotalRounds() {
        return this.totalRounds;
    }

    public Integer getCurrentRound() {
        return this.currentRound;
    }

    public void incrementCurrentRound(){
        this.currentRound +=1;
    }

    public void decrementCurrentRound(){
        this.currentRound -= 1;
    }

    public void setMoves(EnumMove move){
        this.player.setMove(move);
        this.computer.setRandomMove();
    }

    public Player compareMoves(){
        this.incrementCurrentRound();
        if (this.player.getMove() == this.computer.getMove()){
            return null;
        } else if (this.player.getMove() == EnumMove.ROCK && this.computer.getMove() == EnumMove.SCISSORS){
            this.player.addPoint();
            return this.player;
        } else if (this.player.getMove() == EnumMove.PAPER && this.computer.getMove() == EnumMove.ROCK){
            this.player.addPoint();
            return this.player;
        } else if (this.player.getMove() == EnumMove.SCISSORS && this.computer.getMove() == EnumMove.PAPER){
            this.player.addPoint();
            return this.player;
        } else {
            this.computer.addPoint();
            return this.computer;
        }

    }

    public Player getOverallWinner() {
        Player winner;
        winner = player.getScore() > computer.getScore() ? player : computer;
        return winner;
    }

    public Boolean isGameFinished(){
        return currentRound > totalRounds;
    }
}
