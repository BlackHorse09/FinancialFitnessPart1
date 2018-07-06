package com.dexterlab.sahil.demo;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FinancialFitness extends AppCompatActivity {

    EditText editName,editPhone,Interest;
    Spinner spinner;
    Button send;
    String spinnerChoice,name,number,choice,interest;
    DatabaseReference databaseUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financial_fitness);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        editName = (EditText) findViewById(R.id.editName);
        editPhone = (EditText) findViewById(R.id.editPhone);
        Interest = (EditText) findViewById(R.id.interest);
        spinner = (Spinner) findViewById(R.id.Occupation);
        send = (Button) findViewById(R.id.sendTo);

        databaseUser = FirebaseDatabase.getInstance().getReference("User");

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addUser();
            }
        });
    }

    public void addUser(){
        name = editName.getText().toString();
        number = editPhone.getText().toString();
        spinnerChoice = spinner.getSelectedItem().toString();
        interest = Interest.getText().toString();
        String id = databaseUser.push().getKey();

        if (name.equals("")) {
            editName.setError("Please enter your full name");
            editName.requestFocus();
            return;
        }

        if (!(number.length() == 10)) {
            editPhone.setError("Please enter valid phone number");
            editPhone.requestFocus();
            return;
        }


        User user = new User(id,name,number,spinnerChoice,interest);
        databaseUser.child(id).setValue(user);
        Toast.makeText(FinancialFitness.this,"Entry added successfully",Toast.LENGTH_LONG).show();

    }
}
