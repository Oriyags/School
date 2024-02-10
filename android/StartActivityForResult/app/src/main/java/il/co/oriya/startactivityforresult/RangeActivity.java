package il.co.oriya.startactivityforresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RangeActivity extends AppCompatActivity {

    private EditText ptFirstNumInRange;
    private EditText ptSecondNumInRange;
    private Button   btnBackRange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_range);

        initializeViews();
    }

    private void initializeViews() {
        ptFirstNumInRange  = findViewById(R.id.ptFirstNumInRange);
        ptSecondNumInRange = findViewById(R.id.ptSecondNumInRange);
        btnBackRange       = findViewById(R.id.btnBackRange);

        setListeners();
    }

    private void setListeners() {
        btnBackRange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstNum = ptFirstNumInRange.getText().toString();
                String secondNum = ptSecondNumInRange.getText().toString();

                Intent intentBackRange = new Intent(RangeActivity.this, MainActivity.class);

                intentBackRange.putExtra("FIRST_NUMBER", firstNum);
                intentBackRange.putExtra("SECOND_NUMBER", secondNum);

                startActivity(intentBackRange);
            }
        });


    }
}