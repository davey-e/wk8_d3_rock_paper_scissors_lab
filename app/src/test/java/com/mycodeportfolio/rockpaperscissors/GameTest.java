package com.mycodeportfolio.rockpaperscissors;

import com.mycodeportfolio.rockpaperscissors.Enums.EnumMove;
import com.mycodeportfolio.rockpaperscissors.Models.Computer;
import com.mycodeportfolio.rockpaperscissors.Models.Game;
import com.mycodeportfolio.rockpaperscissors.Models.Player;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class GameTest {

    Player player;
    Computer computer;
    Game game;
    Integer totalRounds;

    @Before
    public void before(){
        totalRounds = 1;
        player = new Player();
        computer = new Computer();
        game = new Game(totalRounds);
    }

    @Test
    public void hasPlayer(){
        assertNotNull(game.getPlayer());
    }

    @Test
    public void hasComputer(){
        assertNotNull(game.getComputer());
    }

    @Test
    public void hasTotalRounds(){
        assertEquals(totalRounds, game.getTotalRounds());
    }

    @Test
    public void hasCurrentRound(){
        assertEquals((Integer) 1, game.getCurrentRound());
    }

    @Test
    public void canIncrementCurrentRound(){
        game.incrementCurrentRound();
        assertEquals((Integer) 2, game.getCurrentRound());
    }

    @Test
    public void canCompareMoves_NoWinner(){
        game.getPlayer().setMove(EnumMove.SCISSORS);
        game.getComputer().setMove(EnumMove.SCISSORS);
        assertNull(game.compareMoves());
    }

    @Test
    public void canCompareMoves_PlayerWins(){
        game.getPlayer().setMove(EnumMove.SCISSORS);
        game.getComputer().setMove(EnumMove.PAPER);
        assertEquals(game.getPlayer(), game.compareMoves());
        assertEquals((Integer)1, game.getPlayer().getScore());
    }

    @Test
    public void canCompareMoves_ComputerWins(){
        game.getPlayer().setMove(EnumMove.PAPER);
        game.getComputer().setMove(EnumMove.SCISSORS);
        assertEquals(game.getComputer(), game.compareMoves());
        assertEquals((Integer)1, game.getComputer().getScore());
    }

    @Test
    public void canGetOverAllWinner_PlayerIsWinner(){
        game.getPlayer().setMove(EnumMove.SCISSORS);
        game.getComputer().setMove(EnumMove.PAPER);
        game.compareMoves();
        assertEquals(game.getPlayer(), game.getOverallWinner());
    }

    @Test
    public void canGetOverAllWinner_ComputerIsWinner(){
        game.getPlayer().setMove(EnumMove.PAPER);
        game.getComputer().setMove(EnumMove.SCISSORS);
        game.compareMoves();
        assertEquals(game.getComputer(), game.getOverallWinner());
    }

    @Test
    public void canDetermineIfGameIsFinished(){
        Game game2 = new Game(2);
        game2.incrementCurrentRound();
        assertFalse(game2.isGameFinished());
        game2.incrementCurrentRound();
        assertTrue(game2.isGameFinished());
    }


}
