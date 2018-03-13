package com.chan.revernue.filterapplication;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeActivity extends AppCompatActivity {

    private RadioButton male, female;
    private Button btSave;
    private EditText etName, etHeight, etWeight;
    private TextView etAge;
    private Spinner spinner;
    private TextView Showresult;
    // result_BMR,result_BMI,

    int date,month,year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
    }

    public TextView getEtAge() {
        return etAge;
    }

    public void setEtAge(TextView etAge) {
        this.etAge = etAge;
    }
}
