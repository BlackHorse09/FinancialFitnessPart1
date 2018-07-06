package com.dexterlab.sahil.demo;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText postquestion,postanswer;
    Button questionPost;
    DatabaseReference databaseQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        postquestion = (EditText) findViewById(R.id.postQuestion);
        postanswer = (EditText) findViewById(R.id.postAnswer);
        postanswer.setVisibility(View.INVISIBLE);
        questionPost = (Button) findViewById(R.id.questionPost);

        databaseQuestion = FirebaseDatabase.getInstance().getReference("POST");

        questionPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPost();
            }
        });
    }

    private void addPost() {

        String question = postquestion.getText().toString();
        String answer = postanswer.getText().toString();

        if (!TextUtils.isEmpty(question)) {
            String id = databaseQuestion.push().getKey();
            Question question1 = new Question(id,question,answer);
            databaseQuestion.child(id).setValue(question1);
            Toast.makeText(getApplicationContext(),"Successfully posted",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"Please enter question to be posted",Toast.LENGTH_SHORT).show();
        }




    }
}
