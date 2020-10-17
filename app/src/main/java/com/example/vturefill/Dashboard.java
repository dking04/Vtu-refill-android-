package com.example.vturefill;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.CardView;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity {
    GridLayout gridLayout;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private LinearLayout fundWallet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        gridLayout = findViewById(R.id.products);
        toolbar = findViewById(R.id.toolbar);
        fundWallet = findViewById(R.id.fundwallet);
        fundWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Dashboard.this,FundWallet.class);
                startActivity(a);
            }
        });
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Dashboard");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        getSupportActionBar().setHomeButtonEnabled(true);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        int childCount = gridLayout.getChildCount();
        for(int i=0;i<childCount;i++){
            final CardView cardView = (CardView)gridLayout.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (v.getId()){
                        case R.id.view1:
                            Intent i = new Intent(Dashboard.this,Airtime.class);
                            startActivity(i);
                            break;
                        case R.id.view2:
                            Intent a = new Intent(Dashboard.this,DataBundle.class);
                            startActivity(a);
                            break;
                        case R.id.view3:
                            Intent b = new Intent(Dashboard.this,PayTv.class);
                            startActivity(b);
                            break;
                        case R.id.view4:
                            Intent c = new Intent(Dashboard.this,PayElectricity.class);
                            startActivity(c);
                            break;
                        case R.id.view5:
                            Toast.makeText(Dashboard.this,"this is view 5",Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.view6:
                            Toast.makeText(Dashboard.this,"this is view 6",Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.view7:
                            Toast.makeText(Dashboard.this,"this is view 7",Toast.LENGTH_SHORT).show();
                            break;

                    }
                }
            });
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
        }
        return true;
    }
}
