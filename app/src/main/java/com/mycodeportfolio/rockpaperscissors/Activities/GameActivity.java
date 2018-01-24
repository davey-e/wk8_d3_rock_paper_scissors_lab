package com.mycodeportfolio.rockpaperscissors.Activities;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.mycodeportfolio.rockpaperscissors.Enums.EnumMove;
import com.mycodeportfolio.rockpaperscissors.Models.Game;
import com.mycodeportfolio.rockpaperscissors.R;

public class GameActivity extends AppCompatActivity {

    ConstraintLayout startContainer;
    ConstraintLayout gameContainer;
    ConstraintLayout playerMovesContainer;
    ConstraintLayout computerContainer;
    EditText roundsSelector;
    TextView currentRound;
    TextView totalRounds;
    TextView playerScore;
    TextView computerScore;
    int numberOfRounds;
    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        startContainer = findViewById(R.id.start_container);
        gameContainer = findViewById(R.id.game_container);
        playerMovesContainer = findViewById(R.id.player_moves_container);
        computerContainer = findViewById(R.id.computer_container);
        roundsSelector = findViewById(R.id.rounds_selector);
        currentRound = findViewById(R.id.current_round);
        totalRounds = findViewById(R.id.total_rounds);
        playerScore = findViewById(R.id.player_score);
        computerScore = findViewById(R.id.computer_score);

    }

    public void onStartButtonClick(View button){
        numberOfRounds = Integer.parseInt(roundsSelector.getText().toString());
        startContainer.setVisibility(View.INVISIBLE);
        gameContainer.setVisibility(View.VISIBLE);
        playerMovesContainer.setVisibility(View.VISIBLE);
        game = new Game(numberOfRounds);
        updateRound();
    }

    public void updateRound(){
        if(game.isGameFinished()){
            playerMovesContainer.setVisibility(View.INVISIBLE);
            computerContainer.setVisibility(View.INVISIBLE);
            startContainer.setVisibility(View.VISIBLE);
            game.decrementCurrentRound();
        }
        currentRound.setText(game.getCurrentRound().toString());
        totalRounds.setText(game.getTotalRounds().toString());
        playerScore.setText(game.getPlayer().getScore().toString());
        computerScore.setText(game.getComputer().getScore().toString());
    }

    public void onPlayerMoveClick(View button){
        EnumMove move = EnumMove.valueOf(button.getTag().toString());
        Log.d("Selected move", move.getLabel());
        game.setMoves(move);
        game.compareMoves();
        updateRound();
    }

}
