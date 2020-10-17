package com.example.vturefill;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class PayTv extends AppCompatActivity {
    private Spinner decoderBiller,plan;
    private EditText decoder_no;
    private String[] dstvPlan = {"DStv Access@₦2000","DStv Family@₦4000","DStv Compact@₦6800","DStv Compact plus@₦10650","DStv Premium@₦18000"};
    private String[] gotvPlan = {"GOtv Lite@₦400","GOtv Value@₦1250","GOtv plus@₦1900","GOtv Max@₦3200"};
    private String[] startimesPlan = {"Nova@₦900","Basic@₦1300","Smart@₦1900","Classic@₦2600","Unique@₦3800"};
    private String[] tvBiller={"Select biller","DSTV","GOTV","STARTIMES"};
    private String[] nothingSelected ={"Waiting for Biller selection"};
    private int[] decoderBillerLogo ={R.drawable.ic_spinner,R.drawable.dstv,R.drawable.gotv,R.drawable.startimes};
    private int[] nothingseledimage = {R.drawable.ic_spinner};
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_tv);
        decoderBiller = findViewById(R.id.spinner_decoder);
        plan = findViewById(R.id.spinner_package);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Pay Tv Subscription");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
       SpinnerAdapter spinnerAdapter = new SpinnerAdapter(this,tvBiller,decoderBillerLogo);
        decoderBiller.setAdapter(spinnerAdapter);

    SpinnerAdapter spinnerAdapter1 = new SpinnerAdapter(this,nothingSelected,nothingseledimage);
        plan.setAdapter(spinnerAdapter1);

        decoderBiller.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        SpinnerAdapter spinnerAdapter1 = new SpinnerAdapter(PayTv.this,nothingSelected,nothingseledimage);
                        plan.setAdapter(spinnerAdapter1);
                        break;
                    case 1:
                        SpinnerAdapter spinnerAdapter2 = new SpinnerAdapter(PayTv.this,dstvPlan);
                        plan.setAdapter(spinnerAdapter2);
                        break;
                    case 2:
                        SpinnerAdapter spinnerAdapter3 = new SpinnerAdapter(PayTv.this,gotvPlan);
                        plan.setAdapter(spinnerAdapter3);
                        break;
                    case 3:
                        SpinnerAdapter spinnerAdapter4 = new SpinnerAdapter(PayTv.this,startimesPlan);
                        plan.setAdapter(spinnerAdapter4);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
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
