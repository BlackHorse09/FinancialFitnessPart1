package com.dexterlab.sahil.demo;

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

    EditText editName,editPhone;
    Spinner spinner;
    Button send;
    String spinnerChoice,name,number,choice;
    DatabaseReference databaseUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financial_fitness);

        editName = (EditText) findViewById(R.id.editName);
        editPhone = (EditText) findViewById(R.id.editPhone);
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
        String id = databaseUser.push().getKey();

        User user = new User(id,name,number,spinnerChoice);
        databaseUser.child(id).setValue(user);
        Toast.makeText(FinancialFitness.this,"Entry added successfully",Toast.LENGTH_LONG).show();

    }
}
