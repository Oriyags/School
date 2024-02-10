package il.co.oriya.oriya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import il.co.oriya.modle.Making;

public class MainActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etFamilyName;
    private Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
    }

    private void initializeViews() {
        etName = findViewById(R.id.etName);
        etFamilyName = findViewById(R.id.etFamilyName);
        btnContinue = findViewById(R.id.btnContinue);

        setListeners();
    }

    private void setListeners() {
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstName = etName.getText().toString();
                String familyName = etFamilyName.getText().toString();

                Making m = new Making();
                m.setFirstNameFirstLetter(String.valueOf(firstName.charAt(0)));
                m.setFamilyNameFirstLetter(String.valueOf(familyName.charAt(0)));

                String str = m.combined();

                Intent intent = new Intent(MainActivity.this, Finish.class);
                intent.putExtra("The combined letters", str);
                startActivity(intent);
            }
        });
    }
}