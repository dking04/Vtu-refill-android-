package com.example.vturefill;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class PayElectricity extends AppCompatActivity {
    private Spinner distributionCompany;
    private EditText amount,meter_no,phone_no;
    private String[] electricCompany = {"Ikeja electricity prepaid","Eko electricity prepaid"};
    private int[] images={R.drawable.airtel,R.drawable.mtn};
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_electricity);
        distributionCompany = findViewById(R.id.spinner_electric_com);
        amount = findViewById(R.id.amount_electric);
        meter_no = findViewById(R.id.meter_number);
        phone_no = findViewById(R.id.phone_number_electric);
        SpinnerAdapter spinnerAdapter = new SpinnerAdapter(this,electricCompany,images);
        distributionCompany.setAdapter(spinnerAdapter);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Pay Electricity Bill");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                finish();
                break;
        }
        return true;
    }
}
