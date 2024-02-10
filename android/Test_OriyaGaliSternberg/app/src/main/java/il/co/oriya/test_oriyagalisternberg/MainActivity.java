package il.co.oriya.test_oriyagalisternberg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvAddress;
    private TextView tvMessage;
    private Button btnSendMessage;

    private static final int CODE_ADDRESS = 1;
    private static final int CODE_MESSAGE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
    }

    private void initializeViews() {
        tvAddress = findViewById(R.id.tvAddress);
        tvMessage = findViewById(R.id.tvMessage);
        btnSendMessage = findViewById(R.id.btnSendMessage);

        setListeners();
    }

    private void setListeners() {
        tvAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddressActivity2.class);
                startActivityForResult(intent, CODE_ADDRESS);
            }
        });

        tvMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MessageActivity.class);
                startActivityForResult(intent, CODE_MESSAGE);
            }
        });

        btnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String addressText = tvAddress.getText().toString();
                String messageText = tvMessage.getText().toString();

                if (addressText.contains("@")) {
                    Intent emailIntent = new Intent(Intent.ACTION_SEND);
                    emailIntent.setType("text/plain");
                    emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{addressText});
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                    emailIntent.putExtra(Intent.EXTRA_TEXT, messageText);

                    try {
                        startActivity(Intent.createChooser(emailIntent, "Send Email"));
                    } catch (android.content.ActivityNotFoundException ex) {
                        System.out.println("No email client installed.");
                    }
                } else {
                    Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                    smsIntent.setType("vnd.android-dir/mms-sms");
                    smsIntent.putExtra("address", addressText);
                    smsIntent.putExtra("sms_body", messageText);

                    try {
                        startActivity(smsIntent);
                    } catch (android.content.ActivityNotFoundException ex) {
                        System.out.println("SMS client not found.");
                    }
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == CODE_ADDRESS && data != null) {
                String emailOrPhone = data.getStringExtra("emailOrPhone");
                tvAddress.setText(emailOrPhone);
            } else if (requestCode == CODE_MESSAGE && data != null) {
                String enteredText = data.getStringExtra("enteredText");
                tvMessage.setText(enteredText);
            }
        }
    }
}
