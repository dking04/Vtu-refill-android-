package com.example.vturefill;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class Airtime extends AppCompatActivity  {
    private Toolbar toolbar;
    private ImageButton contacts;
    private EditText phoneNumber;
    private EditText network;
    private Button buyAirtime;
    private Spinner networkSpinner;
    final String[] networks = {"Select Nework","MTN","AIRTEL","9MOBILE","GLOMOBILE"};
    private int[] network_logo={R.drawable.ic_spinner,R.drawable.mtn,R.drawable.airtel,R.drawable.n9mobile,R.drawable.glo};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airtime);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Buy Airtime");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        networkSpinner = findViewById(R.id.spinner_network_airtime);
        SpinnerAdapter spinnerAdapter= new SpinnerAdapter(this,networks,network_logo);
        networkSpinner.setAdapter(spinnerAdapter);
        contacts = findViewById(R.id.contact);
        phoneNumber = findViewById(R.id.phone_number);
        contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
                startActivityForResult(intent, 1);
            }
        });

        buyAirtime = findViewById(R.id.buy_airtime);
        buyAirtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Airtime.this,"i am clicked",Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if ((requestCode == 1) && (resultCode == RESULT_OK)) {
            Cursor cursor = null;
            try {
                Uri uri = data.getData();
                cursor = getContentResolver().query(uri, new String[] { ContactsContract.CommonDataKinds.Phone.NUMBER }, null, null, null);
                if (cursor != null && cursor.moveToNext()) {
                    String phone = cursor.getString(0);
                    phoneNumber.setText(phone);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
