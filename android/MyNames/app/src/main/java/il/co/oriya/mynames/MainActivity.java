package il.co.oriya.mynames;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText txtFamily;
    private EditText txtName;
    private Button btnMake;
    private TextView txtFinale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtFamily = findViewById(R.id.txtFamily);
        txtName = findViewById(R.id.txtName);
        btnMake = findViewById(R.id.btnMake);
        txtFinale = findViewById(R.id.txtFinale);

        btnMake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtName.getText().toString();
                String familyName = txtFamily.getText().toString();

                // Combine name and family name
                String fullName = name + " " + familyName;

                // Set the result in the TextView
                txtFinale.setText(fullName);
            }
        });
    }
}