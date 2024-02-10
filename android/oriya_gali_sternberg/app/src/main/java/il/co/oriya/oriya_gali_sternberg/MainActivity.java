// MainActivity.java
package il.co.oriya.oriya_gali_sternberg;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etFirstNum;
    private EditText etSecondNum;
    private TextView txtResult;
    private Button   btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
    }
    private void initializeViews() {
        etFirstNum = findViewById(R.id.etFirstNum);
        etSecondNum = findViewById(R.id.etSecondNum);
        txtResult = findViewById(R.id.txtResult);
        btnCalculate = findViewById(R.id.btnCalculate);

        setListeners();
    }

    private void setListeners() {
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateSum();
            }
        });
    }
        private void calculateSum() {
        String firstNumStr = etFirstNum.getText().toString();
        String secondNumStr = etSecondNum.getText().toString();

        if (!firstNumStr.isEmpty() && !secondNumStr.isEmpty()) {
            int firstNum = Integer.parseInt(firstNumStr);
            int secondNum = Integer.parseInt(secondNumStr);

            int sum = Plus.add(firstNum, secondNum);

            txtResult.setText("Sum: " + sum);
        } else {
            txtResult.setText("Please enter numbers");
        }
    }
}