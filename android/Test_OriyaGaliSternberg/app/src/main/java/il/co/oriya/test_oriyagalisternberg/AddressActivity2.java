package il.co.oriya.test_oriyagalisternberg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddressActivity2 extends AppCompatActivity {

    private EditText etEmailOrPhone;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address2);

        initializeViews();
    }

    private void initializeViews() {
        etEmailOrPhone = findViewById(R.id.etEmailOrPhone);
        btnBack = findViewById(R.id.btnBack);

        setListeners();
    }

    private void setListeners() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailOrPhone = etEmailOrPhone.getText().toString();

                Intent resultIntent = new Intent();
                resultIntent.putExtra("emailOrPhone", emailOrPhone);

                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}