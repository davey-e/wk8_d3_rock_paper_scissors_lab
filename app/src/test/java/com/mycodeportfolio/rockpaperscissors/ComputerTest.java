package com.mycodeportfolio.rockpaperscissors;

import com.mycodeportfolio.rockpaperscissors.Models.Computer;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ComputerTest {

    Computer computer1;

    @Test
    public void canSetRandomMove(){
        computer1 = new Computer();
        computer1.setRandomMove();
        assertNotNull(computer1.getMove());
    }

}
