package com.db.responsimoprog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.db.responsimoprog.helper.Preferences;

public class LoginActivity extends AppCompatActivity {

    EditText username,password;
    Button btnLogin,btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRegister = (Button) findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usernameKey = username.getText().toString();
                String passwordKey = password.getText().toString();

                if (usernameKey.equals("admin") && passwordKey.equals("admin123")){
                    Preferences.getInstance(LoginActivity.this).setLogin(true);
                    Preferences.getInstance(LoginActivity.this).setName(usernameKey);
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("nama", usernameKey);
                    startActivity(intent);
                    finish();
                }

                else {
                    Toast.makeText(getApplicationContext(), "Username atau password salah",
                            Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
