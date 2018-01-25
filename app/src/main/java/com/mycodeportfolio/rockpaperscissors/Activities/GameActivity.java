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
import com.mycodeportfolio.rockpaperscissors.Models.Player;
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
    TextView resultText;
    Button rockButton;
    Button paperButton;
    Button scissorsButton;
    int numberOfRounds;
    Game game;
    Player winner;

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
        resultText = findViewById(R.id.result_text);
        rockButton = findViewById(R.id.button_rock2);
        paperButton = findViewById(R.id.button_paper2);
        scissorsButton = findViewById(R.id.button_scissors);

    }

    public void onStartButtonClick(View button){
        numberOfRounds = Integer.parseInt(roundsSelector.getText().toString());
        startContainer.setVisibility(View.INVISIBLE);
        gameContainer.setVisibility(View.VISIBLE);
        playerMovesContainer.setVisibility(View.VISIBLE);
        computerContainer.setVisibility(View.VISIBLE);
        rockButton.setVisibility(View.VISIBLE);
        paperButton.setVisibility(View.VISIBLE);
        scissorsButton.setVisibility(View.VISIBLE);
        game = new Game(numberOfRounds);
        updateRound();
    }

    public void updateRound(){
        if(game.isGameFinished()){
            startContainer.setVisibility(View.VISIBLE);
            rockButton.setVisibility(View.INVISIBLE);
            paperButton.setVisibility(View.INVISIBLE);
            scissorsButton.setVisibility(View.INVISIBLE);

            game.decrementCurrentRound();
        }
        currentRound.setText(game.getCurrentRound().toString());
        totalRounds.setText(game.getTotalRounds().toString());
        playerScore.setText(game.getPlayer().getScore().toString());
        computerScore.setText(game.getComputer().getScore().toString());
//        resultText.setText(winner.getName().toString() + " won that round!");
    }

    public void onPlayerMoveClick(View button){
        EnumMove move = EnumMove.valueOf(button.getTag().toString());
        Log.d("Selected move", move.getLabel());
        game.setMoves(move);
        winner = game.compareMoves();
        updateRound();
    }

}
