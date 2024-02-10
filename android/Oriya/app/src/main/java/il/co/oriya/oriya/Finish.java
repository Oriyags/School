package il.co.oriya.oriya;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Finish extends AppCompatActivity {

    private TextView txtShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        initializeViews();
    }

    private void initializeViews() {
        txtShow = findViewById(R.id.txtShow);

        setListeners();
    }

    private void setListeners() {
        String lettersCombined = getIntent().getStringExtra("The combined letters");
        txtShow.setText(lettersCombined);
    }
}