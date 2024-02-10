package il.co.oriya.guessthenumber;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Range extends AppCompatActivity {

    private EditText firstNumEditText;
    private EditText secondNumEditText;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_range);

        initializeViews();
    }

    private void initializeViews() {
        firstNumEditText = findViewById(R.id.etFirstNum);
        secondNumEditText = findViewById(R.id.etSecondNum);
        nextButton = findViewById(R.id.btnRange);

        setListeners();
    }

    private void setListeners() {
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int firstNum = Integer.parseInt(firstNumEditText.getText().toString());
                int secondNum = Integer.parseInt(secondNumEditText.getText().toString());

                Intent intent = new Intent(Range.this, Game.class);
                intent.putExtra("MIN_RANGE", firstNum);
                intent.putExtra("MAX_RANGE", secondNum);
                startActivity(intent);
            }
        });
    }
}
