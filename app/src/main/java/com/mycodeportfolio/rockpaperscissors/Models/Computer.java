package com.mycodeportfolio.rockpaperscissors.Models;

import com.mycodeportfolio.rockpaperscissors.Enums.EnumMove;

import java.util.Random;

public class Computer extends Player {

    public void setRandomMove(){
        this.setMove(EnumMove.values()[new Random().nextInt(EnumMove.values().length)]);
    }

}
