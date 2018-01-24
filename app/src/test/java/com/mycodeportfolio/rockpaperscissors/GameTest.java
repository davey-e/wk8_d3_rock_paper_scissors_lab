package com.mycodeportfolio.rockpaperscissors;

import com.mycodeportfolio.rockpaperscissors.Enums.EnumMove;
import com.mycodeportfolio.rockpaperscissors.Models.Computer;
import com.mycodeportfolio.rockpaperscissors.Models.Game;
import com.mycodeportfolio.rockpaperscissors.Models.Player;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class GameTest {

    Player player;
    Computer computer;
    Game game;
    int totalRounds;

    @Before
    public void before(){
        totalRounds = 1;
        player = new Player();
        computer = new Computer();
        game = new Game(player, computer, totalRounds);
    }

    @Test
    public void hasPlayer(){
        assertEquals(player, game.getPlayer());
    }

    @Test
    public void hasComputer(){
        assertEquals(computer, game.getComputer());
    }

    @Test
    public void hasTotalRounds(){
        assertEquals(totalRounds, game.getTotalRounds());
    }

    @Test
    public void hasCurrentRound(){
        assertEquals(1, game.getCurrentRound());
    }

    @Test
    public void canIncrementCurrentRound(){
        game.incrementCurrentRound();
        assertEquals(2, game.getCurrentRound());
    }

    @Test
    public void canCompareMoves_NoWinner(){
        player.setMove(EnumMove.SCISSORS);
        computer.setMove(EnumMove.SCISSORS);
        assertNull(game.compareMoves());
    }

    @Test
    public void canCompareMoves_PlayerWins(){
        player.setMove(EnumMove.SCISSORS);
        computer.setMove(EnumMove.PAPER);
        assertEquals(player, game.compareMoves());
        assertEquals(1, player.getScore());
    }

    @Test
    public void canCompareMoves_ComputerWins(){
        player.setMove(EnumMove.PAPER);
        computer.setMove(EnumMove.SCISSORS);
        assertEquals(computer, game.compareMoves());
        assertEquals(1, computer.getScore());
    }

    @Test
    public void canGetOverAllWinner_PlayerIsWinner(){
        player.setMove(EnumMove.SCISSORS);
        computer.setMove(EnumMove.PAPER);
        game.compareMoves();
        assertEquals(player, game.getOverallWinner());
    }

    @Test
    public void canGetOverAllWinner_ComputerIsWinner(){
        player.setMove(EnumMove.PAPER);
        computer.setMove(EnumMove.SCISSORS);
        game.compareMoves();
        assertEquals(computer, game.getOverallWinner());
    }

    @Test
    public void canDetermineIfGameIsFinished(){
        Game game2 = new Game(player, computer, 2);
        game2.incrementCurrentRound();
        assertFalse(game2.isGameFinished());
        game2.incrementCurrentRound();
        assertTrue(game2.isGameFinished());
    }


}
