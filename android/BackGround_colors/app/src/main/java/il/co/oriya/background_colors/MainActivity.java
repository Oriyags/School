package il.co.oriya.background_colors;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private SeekBar redSeekBar;
    private SeekBar greenSeekBar;
    private SeekBar blueSeekBar;
    private TextView rgbTextView;
    private TextView hexRgbTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        redSeekBar = findViewById(R.id.seekBar5);
        greenSeekBar = findViewById(R.id.seekBar4);
        blueSeekBar = findViewById(R.id.seekBar2);
        rgbTextView = findViewById(R.id.textView9);
        hexRgbTextView = findViewById(R.id.textView10);

        updateBackgroundColor();

        redSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateBackgroundColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        greenSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateBackgroundColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        blueSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateBackgroundColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    private void updateBackgroundColor() {
        int red = redSeekBar.getProgress();
        int green = greenSeekBar.getProgress();
        int blue = blueSeekBar.getProgress();

        // Set the background color of the TextView
        textView.setBackgroundColor(Color.rgb(red, green, blue));

        // Update the RGB and Hex TextViews
        rgbTextView.setText(red + ", " + green + ", " + blue);
        hexRgbTextView.setText(String.format("#%02X%02X%02X", red, green, blue));
    }
}
