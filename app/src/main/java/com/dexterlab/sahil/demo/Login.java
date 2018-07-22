package com.dexterlab.sahil.demo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    EditText email,password;
    Button login;
    Context context;
    FirebaseAuth mAuth;
    //ProgressBar progressBar;
    TextView goToRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        int black = Color.parseColor("#000000");
//
//        Drawable mDrawable = context.getResources().getDrawable(R.drawable.ic_action_pass);
//        mDrawable.setColorFilter(new
//                PorterDuffColorFilter(black, PorterDuff.Mode.MULTIPLY));

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        email = (EditText) findViewById(R.id.editEmail);
        password = (EditText) findViewById(R.id.editPassword);
        login = (Button) findViewById(R.id.Login);

        goToRegister = (TextView) findViewById(R.id.goToRegister);

//        progressBar = (ProgressBar) findViewById(R.id.progressBar3);
//        progressBar.setVisibility(View.INVISIBLE);


        mAuth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLogin();
            }
        });

        goToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Registration.class);
                startActivity(intent);
            }
        });

    }

    private void userLogin() {
        String emailAdd,pass;
        emailAdd = email.getText().toString();
        pass = password.getText().toString();

        if (emailAdd.isEmpty()) {
            email.setError("Please enter an Email Address");
            email.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(emailAdd).matches()) {
            email.setError("Please enter valid Email Address");
            email.requestFocus();
            return;
        }

        if (pass.isEmpty() || pass.length() < 6) {
            password.setError("Password must be 6 characters long");
            password.requestFocus();
            return;
        }



        mAuth.signInWithEmailAndPassword(emailAdd, pass) .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
            //progressBar.setVisibility(View.VISIBLE);
                if (task.isSuccessful()){
                    Intent intent = new Intent(Login.this,GridViewLayout.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else  {
                    Toast.makeText(Login.this,"Please register Your login is not present",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
