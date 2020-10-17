package com.example.vturefill;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

public class DataBundle extends AppCompatActivity {
    private EditText phoneNumber,network,bundle;
    private ImageButton contacts;
    private Toolbar toolbar;
    private Spinner spinner,spinner2;
    final String[] networks = {"Select Nework","MTN","AIRTEL","9MOBILE","GLOMOBILE"};
    final String[] mtn = {"1GB@500","2GB@1000","5GB@2350"};
    private String[] airtel = {"1.5GB@950","3.5GB@1900","5GB@2400"};
    private String[] n9_mobile = {"1GB@950","1.5GB@1100"};
    private String[] glo_mobile = {"920MB@450","1.8GB@900","4.5GB@1800","7.2GB@2250","8.75GB@2750","12.5GB@3600","15.6GB@4500","25GB@7200"};
    private String[] nothingSelected={"waiting for network selection"};
    private int[] network_logo={R.drawable.ic_spinner,R.drawable.mtn,R.drawable.airtel,R.drawable.n9mobile,R.drawable.glo};
    private int[] network_logo1={R.drawable.ic_spinner};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_bundle);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Buy Data");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        phoneNumber = findViewById(R.id.phone_number_data);
        contacts = findViewById(R.id.contact_data);
        spinner2 = findViewById(R.id.spinner_network_data2);
        spinner = findViewById(R.id.spinner_network_data);
        SpinnerAdapter spinnerAdapter = new SpinnerAdapter(this,networks,network_logo);
        spinner.setAdapter(spinnerAdapter);
        SpinnerAdapter spinnerAdapter1 = new SpinnerAdapter(this,nothingSelected,network_logo1);
        spinner2.setAdapter(spinnerAdapter1);
        contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
                startActivityForResult(intent, 1);
            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 1:
                       SpinnerAdapter spinnerAdapter2 = new SpinnerAdapter(DataBundle.this, mtn);
                        spinner2.setAdapter(spinnerAdapter2);
                        break;
                    case 2:
                        SpinnerAdapter spinnerAdapter3 = new SpinnerAdapter(DataBundle.this, airtel);
                        spinner2.setAdapter(spinnerAdapter3);
                        break;
                    case 3:
                        SpinnerAdapter spinnerAdapter4 = new SpinnerAdapter(DataBundle.this, n9_mobile);
                        spinner2.setAdapter(spinnerAdapter4);
                        break;
                    case 4:
                        SpinnerAdapter spinnerAdapter5 = new SpinnerAdapter(DataBundle.this, glo_mobile);
                        spinner2.setAdapter(spinnerAdapter5);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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
