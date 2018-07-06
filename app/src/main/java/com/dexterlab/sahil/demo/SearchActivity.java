package com.dexterlab.sahil.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    EditText editTextSearch;
    Button searchtext;
    ListView listViewSearch;
    List<Question> listOfQuestion;
    String searchWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        editTextSearch = (EditText) findViewById(R.id.textSearch);

        searchtext = (Button) findViewById(R.id.searchText);
        listViewSearch = (ListView) findViewById(R.id.listViewSearch);

        searchWord = editTextSearch.getText().toString();

        DatabaseReference dbQuestion = FirebaseDatabase.getInstance().getReference("POST");
        listOfQuestion = new ArrayList<>();

        final ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listOfQuestion.clear();
                for (DataSnapshot questionSnap : dataSnapshot.getChildren()) {
                    Question question = questionSnap.getValue(Question.class);
                    String[] array = question.getQuestion().split("\\s");
                    for (int i = 0;i<array.length;i++) {
                        if (array[i].toLowerCase().equals(editTextSearch.getText().toString().toLowerCase())) {
                            listOfQuestion.add(question);
                            break;
                        }
                    }
                }
                questionList adapter = new questionList(SearchActivity.this,listOfQuestion);
                listViewSearch.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };


        //dbQuestion.addListenerForSingleValueEvent(valueEventListener);
searchtext.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Query query = FirebaseDatabase.getInstance().getReference("POST").orderByChild("question");
        query.addValueEventListener(valueEventListener);

    }
});


        listViewSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Question question = listOfQuestion.get(i);
                Intent intent = new Intent(SearchActivity.this, AnswerActivity.class);
                intent.putExtra("question",question.getQuestion());
                intent.putExtra("answer",question.getAnswer());
                startActivity(intent);
            }
        });
        /*



        addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listOfQuestion.clear();
                for (DataSnapshot questionSnap : dataSnapshot.getChildren()) {
                    Question question = questionSnap.getValue(Question.class);
                    listOfQuestion.add(question);
                }

                questionList adapter = new questionList(QuestionListActivity.this,listOfQuestion);
                listView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        */

    }
}
