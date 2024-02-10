package il.co.oriya.test_oriyagalisternberg;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MessageActivity extends AppCompatActivity {

    private EditText etSomeText;
    private Button btnBack2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        initializeViews();
    }

    private void initializeViews() {
        etSomeText = findViewById(R.id.etSomeText);
        btnBack2 = findViewById(R.id.btnBack2);

        setListeners();
    }

    private void setListeners() {
        btnBack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredText = etSomeText.getText().toString();

                Intent intent = new Intent();
                intent.putExtra("enteredText", enteredText);

                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
