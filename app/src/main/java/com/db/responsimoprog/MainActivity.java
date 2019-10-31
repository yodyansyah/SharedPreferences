package com.db.responsimoprog;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.db.responsimoprog.helper.Preferences;

public class MainActivity extends AppCompatActivity {

    Button btnSatuFragment, btnDuaFragment, BtnLogout;
    TextView username;
    Preferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSatuFragment = findViewById(R.id.btnFragment1);
        btnDuaFragment = findViewById(R.id.btnFragment2);
        username = findViewById(R.id.user);
        BtnLogout = findViewById(R.id.btnLogout);


        Intent intent = getIntent();
        username.setText(intent.getStringExtra("nama"));

        btnSatuFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment (new OneFragment());
            }
        });

        btnDuaFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new TwoFragment());
            }
        });

        BtnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pref.getInstance(MainActivity.this).setLogin(false);

                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout, fragment);
        fragmentTransaction.commit();
    }
}

