package il.co.oriya.dialogs;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class MainActivity extends AppCompatActivity {
    private TextView    txtBirthdate;
    private TextView    txtAge;
    private TextView    txtHour;
    private EditText    etTitle;
    private EditText    etMessage;
    private EditText    etNumberOfButtons;
    private Button      btnAlertDialog;
    private Button      btnCustomDialog;
    private ImageView   ivCalendar;
    private ImageView   ivClock;
    private Switch      swVisibleCircle;
    private Switch      swVisibleLine;
    private ProgressBar pbCircle;
    private ProgressBar pbLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createCustomDialog();

        initializeViews();
    }

    private void initializeViews() {
        txtBirthdate       = findViewById(R.id.txtBirthdate);
        txtAge             = findViewById(R.id.txtAge);
        txtHour            = findViewById(R.id.txtHour);
        etTitle            = findViewById(R.id.etTitle);
        etMessage          = findViewById(R.id.etMessage);
        etNumberOfButtons  = findViewById(R.id.etNumberOfButtons);
        btnAlertDialog     = findViewById(R.id.btnAlertDialog);
        btnCustomDialog    = findViewById(R.id.btnCustomDialog);
        ivCalendar         = findViewById(R.id.ivCalendar);
        ivClock            = findViewById(R.id.ivClock);
        swVisibleCircle    = findViewById(R.id.swVisibleCircle);
        swVisibleLine      = findViewById(R.id.swVisibleLine);
        pbLine             = findViewById(R.id.pbLine);
        pbCircle           = findViewById(R.id.pbCircle);

        setListeners();
    }

    private void setListeners() {
        ivCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialDatePicker.Builder builder = MaterialDatePicker.Builder.datePicker()
                        .setTitleText("Select your birthdate")
                        .setTextInputFormat(new SimpleDateFormat("dd/MM/yyyy"))
                        .setInputMode(MaterialDatePicker.INPUT_MODE_CALENDAR);
                MaterialDatePicker picker = builder.build();

                picker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
                    @SuppressLint("NewApi")
                    @Override
                    public void onPositiveButtonClick(Object selection) {
                        txtBirthdate.setText(Instant.ofEpochMilli((long) selection)
                                .atZone(ZoneId.systemDefault())
                                .toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

                        showAge(Instant.ofEpochMilli((long) selection)
                                .atZone(ZoneId.systemDefault())
                                .toLocalDate());
                    }
                });
                picker.addOnNegativeButtonClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        txtBirthdate.setText("Enter date:");
                    }
                });

                picker.show(getSupportFragmentManager(), "");

            }
            private void showAge(LocalDate birthDate) {
                Period period = Period.between(birthDate, LocalDate.now());
                txtAge.setText(String.valueOf(period.getYears()) + "|" + String.valueOf(period.getMonths()) + "|" + String.valueOf(period.getDays()));
            }
        });

        swVisibleCircle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    pbCircle.setVisibility(View.VISIBLE);
                else
                    pbCircle.setVisibility(View.INVISIBLE);
            }
        });

    }

    private void createCustomDialog() {
        Dialog dialog       = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);
        EditText etEmail    = dialog.findViewById(R.id.etPassword);
        EditText etPassword = dialog.findViewById(R.id.etPassword);
        Button btnSubmit    = dialog.findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(MainActivity.this)
                        .setTitle("Login")
                        .setMessage("Your login credentials:\n Email: "
                                + etEmail.getText().toString()
                                + "\nPassword: "
                                +etPassword.getText().toString())

                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                AlertDialog d = builder.create();
                d.show();
            }
        });
        dialog.show();
    }

    public void createAlertDialog(){
        Dialog alertDialog = new Dialog(this);
        alertDialog.setContentView(R.layout.custom_dialog);
        EditText etTitle           = alertDialog.findViewById(R.id.etTitle);
        EditText etMessage         = alertDialog.findViewById(R.id.etMessage);
        EditText etNumberOfButtons = alertDialog.findViewById(R.id.etNumberOfButtons);
        Button   btnAlertDialog    = alertDialog.findViewById((R.id.btnAlertDialog));

        btnAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(MainActivity.this)
                        .setMessage("The information:\n Title: "
                                + etTitle.getText().toString()
                                + "\nMessage: "
                                + etMessage.getText().toString()
                                + "\nButtons: "
                                + etNumberOfButtons.getText().toString())

                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                AlertDialog d = builder.create();
                d.show();
            }
        });
        alertDialog.show();
    }
}