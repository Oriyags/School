package il.co.oriya.guessthenumber;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Game extends AppCompatActivity {

    private GuessTheNumber guessTheNumber;
    private int minRange;
    private int maxRange;
    private ImageView ivGame;
    private EditText etNumber;
    private Button btnCheckNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        initializeViews();
        setListeners();
    }

    private void initializeViews() {
        Intent intent = getIntent();
        minRange = intent.getIntExtra("MIN_RANGE", 0);
        maxRange = intent.getIntExtra("MAX_RANGE", 100);
        guessTheNumber = new GuessTheNumber(minRange, maxRange);

        ivGame = findViewById(R.id.ivGame);
        etNumber = findViewById(R.id.etNumber);
        btnCheckNum = findViewById(R.id.btnCheckNum);
    }
    private void setListeners() {
        btnCheckNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int guessedNumber = Integer.parseInt(etNumber.getText().toString());
                boolean isCorrect = guessTheNumber.checkGuess(guessedNumber);

                if (isCorrect || guessTheNumber.getAttempts() > 10) {
                    int attempts = guessTheNumber.getAttempts();
                    String feedback = isCorrect ? guessTheNumber.getFeedback() : "Too many attempts!";

                    Intent resultIntent = new Intent(Game.this, Ending.class);
                    resultIntent.putExtra("ATTEMPTS", attempts);
                    resultIntent.putExtra("FEEDBACK", feedback);
                    startActivity(resultIntent);
                } else {
                    String incorrectFeedback = "Try again!";
                    Toast.makeText(Game.this, incorrectFeedback, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}