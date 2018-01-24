package com.mycodeportfolio.rockpaperscissors;

import com.mycodeportfolio.rockpaperscissors.Enums.EnumMove;
import com.mycodeportfolio.rockpaperscissors.Models.Player;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PlayerTest {

    Player player1;

    @Before
    public void before(){
        player1 = new Player();
    }

    @Test
    public void hasScore(){
        assertEquals(0,     player1.getScore());
    }

    @Test
    public void canAddPoint(){
        player1.addPoint();
        assertEquals(1,     player1.getScore());
    }

    @Test
    public void hasMove(){
        assertNull(player1.getMove());
    }

    @Test
    public void canSetMove(){
        player1.setMove(EnumMove.PAPER);
        assertEquals(EnumMove.PAPER, player1.getMove());
    }

    @Test
    public void canGetMoveString(){
        player1.setMove(EnumMove.PAPER);
        assertEquals("Paper", player1.getMove().getLabel());
    }
}
