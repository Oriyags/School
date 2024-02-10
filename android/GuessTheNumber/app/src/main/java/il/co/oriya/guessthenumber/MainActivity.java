package il.co.oriya.guessthenumber;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ImageView ivLogo;
    private Button btnStartGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        };

    private void initializeViews() {
        ivLogo       = findViewById(R.id.ivLogo);
        btnStartGame = findViewById(R.id.btnStartGame);

        setListeners();
    }

    private void setListeners() {
        btnStartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Range.class);
                startActivity(intent);
            }
       });
    }
}