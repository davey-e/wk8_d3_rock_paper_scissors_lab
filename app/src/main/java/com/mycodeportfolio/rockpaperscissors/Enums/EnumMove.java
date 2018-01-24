package com.mycodeportfolio.rockpaperscissors.Enums;

public enum EnumMove {

    ROCK("Rock"),
    PAPER("Paper"),
    SCISSORS("Scissors");

    private final String label;

    EnumMove(String label){
        this.label = label;
    }

    public String getLabel(){
        return this.label;
    }
}
