package il.co.oriya.guessthenumber;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Ending extends AppCompatActivity {

    private TextView textView2;
    private ImageView imageView2;
    private Button restartButton;
    private Button endButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending);

        initializeViews();

        Intent intent = getIntent();
        final int attempts = intent.getIntExtra("ATTEMPTS", 0);
        String feedback = intent.getStringExtra("FEEDBACK");

        textView2.setText("Attempts: " + attempts);
        if (attempts < 5) {
            imageView2.setImageResource(R.drawable.happy_smiley);
        } else if (attempts >= 5 && attempts <= 10) {
            imageView2.setImageResource(R.drawable.normal);
        } else {
            imageView2.setImageResource(R.drawable.angry);
        }

        setListeners();
    }

    private void initializeViews() {
        textView2 = findViewById(R.id.textView2);
        imageView2 = findViewById(R.id.imageView2);
        restartButton = findViewById(R.id.restartButton);
        endButton = findViewById(R.id.endButton);
    }

    private void setListeners() {
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Restart the game
                Intent restartIntent = new Intent(Ending.this, MainActivity.class);
                startActivity(restartIntent);
            }
        });

        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
