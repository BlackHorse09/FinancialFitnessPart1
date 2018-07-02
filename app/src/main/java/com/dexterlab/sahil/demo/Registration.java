package com.dexterlab.sahil.demo;

import android.content.Intent;
import android.support.annotation.NonNull;
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
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class Registration extends AppCompatActivity {

    String emailAdd,user,pass;
    EditText email,username,password;
    TextView goToLogin;
    Button signup;
    ProgressBar progressBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mAuth = FirebaseAuth.getInstance();
        goToLogin = (TextView) findViewById(R.id.goToLogin);
        email = (EditText) findViewById(R.id.Email);
        //username = (EditText) findViewById(R.id.Username);
        password = (EditText) findViewById(R.id.Password);
        signup = (Button) findViewById(R.id.SignUp);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });

        goToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Registration.this, Login.class);
                startActivity(intent);
            }
        });

    }

    private void registerUser() {
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
            password.setError("Please enter password properly");
            password.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(emailAdd, pass) .addOnCompleteListener(Registration.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    Toast.makeText(Registration.this,"Successfully registered",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Registration.this,GridViewLayout.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else {
                    if (task.getException() instanceof FirebaseAuthUserCollisionException){
                        Toast.makeText(Registration.this,"Already registered",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }
}
