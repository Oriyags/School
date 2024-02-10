package il.co.oriya.tictactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    private TicTacToeGame ticTacToeGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        initializeGame();
        initializeViews();
    }

    private void initializeGame() {
        ticTacToeGame = new TicTacToeGame();
    }

    private void initializeViews() {
        Button[] buttons = new Button[9];
        for (int i = 0; i < 9; i++) {
            String buttonID = "button_" + i;
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            buttons[i] = findViewById(resID);
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onButtonClick((Button) v);
                }
            });
        }
    }

    private void onButtonClick(Button button) {
        int position = Integer.parseInt(button.getTag().toString());
        if (ticTacToeGame.makeMove(position)) {
            button.setText(ticTacToeGame.getCurrentPlayer());
            if (ticTacToeGame.checkForWinner()) {
                showWinner();
            } else if (ticTacToeGame.isBoardFull()) {
                showTie();
            }
        } else {
            Toast.makeText(this, "Invalid move!", Toast.LENGTH_SHORT).show();
        }
    }

    private void showWinner() {
        Toast.makeText(this, "Player " + ticTacToeGame.getCurrentPlayer() + " wins!", Toast.LENGTH_SHORT).show();
        resetGame();
    }

    private void showTie() {
        Toast.makeText(this, "It's a tie!", Toast.LENGTH_SHORT).show();
        resetGame();
    }

    private void resetGame() {
        ticTacToeGame.resetGame();
        for (int i = 0; i < 9; i++) {
            String buttonID = "button_" + i;
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            Button button = findViewById(resID);
            button.setText("");
        }
    }
}
