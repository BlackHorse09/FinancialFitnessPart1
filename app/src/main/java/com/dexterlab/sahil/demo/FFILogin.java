package com.dexterlab.sahil.demo;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FFILogin extends AppCompatActivity {

    Button button;
    EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ffilogin);

        ActionBar actionBar = getSupportActionBar();

        actionBar.hide();

        username = (EditText) findViewById(R.id.editEmail);
        password = (EditText) findViewById(R.id.editPassword);
        button = (Button) findViewById(R.id.Login);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

    }

    private void login() {
        String userName = username.getText().toString().toUpperCase();
        String pass = password.getText().toString();

        if (userName.isEmpty()){
            username.setError("Please netr the username given");
            username.requestFocus();
            return;
        }

        if (userName.equals("ADMIN") && pass.equals("1234")) {
            Toast.makeText(getApplicationContext(),"WELCOME",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(FFILogin.this, StartActivity.class);
            startActivity(intent);
        }

        else {
            Toast.makeText(getApplicationContext(),"Please check your username and password",Toast.LENGTH_SHORT).show();
        }
    }
}
