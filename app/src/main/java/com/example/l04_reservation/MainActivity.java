package com.example.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        EditText etName;
        EditText etNum;
        EditText etGrp;
        CheckBox cbSmoke;
        DatePicker dp;
        TimePicker tp;
        Button btnSubmit;
        Button btnReset;
        TextView tvShowName;
        TextView tvDetail;
        TextView tvContact;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etNum = findViewById(R.id.editTextPhone);
        etGrp = findViewById(R.id.editTextSize);
        cbSmoke = findViewById(R.id.checkBoxSmoke);
        dp = findViewById(R.id.DatePicker);
        tp = findViewById(R.id.TimePicker);
        btnSubmit = findViewById(R.id.buttonSubmit);
        btnReset = findViewById(R.id.buttonReset);
        tvShowName = findViewById(R.id.textViewName);
        tvDetail = findViewById(R.id.textViewDetail);
        tvContact = findViewById(R.id.textViewContact);

        tp.setCurrentHour(19);
        tp.setCurrentMinute(30);
        dp.updateDate(2021, 05, 01);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvShowName.setText("Hi " + etName.getText() + "! Thank you for booking a reservation with us.");

                if (cbSmoke.isChecked()) {
                    String message = "It will be on " + dp.getDayOfMonth() + "/" + (dp.getMonth() + 1) + "/" + dp.getYear() + ", at " + tp.getCurrentHour() + " : " + String.format("%02d", tp.getCurrentMinute())
                            + ", group of " + etGrp.getText() + ". Do note that it is a non-smoking area.";
                    tvDetail.setText(message);
                } else {
                    String message = "It will be on " + dp.getDayOfMonth() + "/" + (dp.getMonth() + 1) + "/" + dp.getYear() + ", at " + tp.getCurrentHour() + " : " + String.format("%02d", tp.getCurrentMinute())
                            + ", group of " + etGrp.getText() + ". Note that it is a smoking area.";
                    tvDetail.setText(message);
                }
                tvContact.setText("We will be contacting you via " + etNum.getText() + " after we have updated your reservation");


            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etName.setText("");
                etNum.setText("");
                etGrp.setText("");
                tvShowName.setText("");
                tvDetail.setText("");
                tvContact.setText("");
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
                dp.updateDate(2021, 05, 01);
            }
        });
    }
}