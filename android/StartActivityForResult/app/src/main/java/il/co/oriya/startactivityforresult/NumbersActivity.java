package il.co.oriya.startactivityforresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NumbersActivity extends AppCompatActivity {

    private TextView txtFirstNumNumbers;
    private TextView txtSecondNumNumbers;
    private TextView txtChosenNum1Numbers;
    private TextView txtChosenNum2Numbers;
    private Button btnStartNumbers;
    private Button btnBackNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        initializeViews();
    }

    private void initializeViews() {
        txtFirstNumNumbers = findViewById(R.id.txtFirstNumNumbers);
        txtSecondNumNumbers = findViewById(R.id.txtSecondNumNumbers);
        txtChosenNum1Numbers = findViewById(R.id.txtChosenNum1Numbers);
        txtChosenNum2Numbers = findViewById(R.id.txtChosenNum2Numbers);
        btnStartNumbers = findViewById(R.id.btnStartNumbers);
        btnBackNumbers = findViewById(R.id.btnBackNumbers);

        setListeners();
    }

    private void setListeners() {
        btnBackNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String randomLotteryNum1 = txtFirstNumNumbers.getText().toString();
                String randomLotteryNum2 = txtSecondNumNumbers.getText().toString();

                Intent intentBackRange = new Intent(NumbersActivity.this, MainActivity.class);

                intentBackRange.putExtra("RAN_NUMBER1", randomLotteryNum1);
                intentBackRange.putExtra("RAN_NUMBER2", randomLotteryNum2);

                startActivity(intentBackRange);
            }
        });
    }
}