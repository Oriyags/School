package il.co.oriya.startactivityforresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button   btnRange;
    private Button   btnNumbers;
    private Button   btnOperation;
    private Button   btnCalculate;
    private TextView txtRange;
    private TextView txtButton;
    private TextView txtOperation;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();

        if (getIntent().hasExtra("FIRST_NUMBER") && getIntent().hasExtra("SECOND_NUMBER")) {
            String firstNum = getIntent().getStringExtra("FIRST_NUMBER");
            String secondNum = getIntent().getStringExtra("SECOND_NUMBER");

            txtRange.setText("Range: " + firstNum + " - " + secondNum);
        }
        else if (getIntent().hasExtra("RAN_NUMBER1") && getIntent().hasExtra("RAN_NUMBER2")) {
            String randomLotteryNum1 = getIntent().getStringExtra("RAN_NUMBER1");
            String randomLotteryNum2 = getIntent().getStringExtra("RAN_NUMBER2");

            txtRange.setText("Numbers: " + randomLotteryNum1 + " , " + randomLotteryNum2);
        }
    }

    private void initializeViews() {
        btnRange     = findViewById(R.id.btnRange);
        btnNumbers   = findViewById(R.id.btnNumbers);
        btnOperation = findViewById(R.id.btnOperation);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtRange     = findViewById(R.id.txtRange);
        txtButton    = findViewById(R.id.txtButton);
        txtOperation = findViewById(R.id.txtOperation);
        txtResult    = findViewById(R.id.txtResult);

        setListeners();
    }

    private void setListeners() {
        btnRange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRange = new Intent(MainActivity.this, RangeActivity.class);
                startActivity(intentRange);
            }
        });
        btnNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentNumbers = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(intentNumbers);
            }
        });
        btnOperation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentOperation = new Intent(MainActivity.this, OperationActivity.class);
                startActivity(intentOperation);
            }
        });
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCalculate = new Intent(MainActivity.this, CalculateActivity.class);
                startActivity(intentCalculate);
            }
        });
    }
}
