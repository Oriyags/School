package il.co.oriya.model;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity {

    private EditText operand1EditText;
    private EditText operand2EditText;
    private Button addButton;
    private Button subtractButton;
    private Button multiplyButton;
    private Button divideButton;
    private Button calculateButton;
    private EditText resultEditText;
    private Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operand1EditText = findViewById(R.id.editTextText2);
        operand2EditText = findViewById(R.id.editTextText);
        addButton = findViewById(R.id.button);
        subtractButton = findViewById(R.id.button3);
        multiplyButton = findViewById(R.id.button4);
        divideButton = findViewById(R.id.button5);
        calculateButton = findViewById(R.id.button2);
        resultEditText = findViewById(R.id.textView3); //?

        calculator = new Calculator();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.setOperator('+');
            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.setOperator('-');
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.setOperator('*');
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.setOperator('/');
            }
        });

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int operand1 = Integer.parseInt(operand1EditText.getText().toString());
                int operand2 = Integer.parseInt(operand2EditText.getText().toString());
                calculator.setOperand1(operand1);
                calculator.setOperand2(operand2);
                int result = calculator.calculate();
                resultEditText.setText(String.valueOf(result));
            }
        });
    }
}
