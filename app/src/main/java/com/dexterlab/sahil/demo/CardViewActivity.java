package com.dexterlab.sahil.demo;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.huxq17.swipecardsview.SwipeCardsView;

import java.util.ArrayList;
import java.util.List;

public class CardViewActivity extends AppCompatActivity {

    private SwipeCardsView swipeCardsView;
    private List<Model> modelList = new ArrayList<>();
    int number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        number = getIntent().getIntExtra("info",1);
        swipeCardsView = (SwipeCardsView) findViewById(R.id.swipeCardView);
        swipeCardsView.retainLastCard(true);
        swipeCardsView.enableSwipe(true);
        swipeCardsView.animate();

        getData();

    }

    private void getData() {

        if (number == 0) {
            modelList.add(new Model(R.drawable.three));
            }

        else if (number == 1) {
            modelList.add(new Model(R.drawable.three));
            modelList.add(new Model(R.drawable.three));


        }
        else if (number == 2) {
            modelList.add(new Model(R.drawable.three));
            modelList.add(new Model(R.drawable.three));
            modelList.add(new Model(R.drawable.three));

        }
        else if (number == 3) {
            modelList.add(new Model(R.drawable.three));
            modelList.add(new Model(R.drawable.three));
            modelList.add(new Model(R.drawable.three));
            modelList.add(new Model(R.drawable.three));

        }
        else if (number == 4) {
            modelList.add(new Model(R.drawable.three));
            modelList.add(new Model(R.drawable.three));
            modelList.add(new Model(R.drawable.three));
            modelList.add(new Model(R.drawable.three));
            modelList.add(new Model(R.drawable.three));
        }
        else if (number == 5) {
            modelList.add(new Model(R.drawable.three));
            modelList.add(new Model(R.drawable.three));
            modelList.add(new Model(R.drawable.three));
            modelList.add(new Model(R.drawable.three));
            modelList.add(new Model(R.drawable.three));
            modelList.add(new Model(R.drawable.three));

        }
        else if (number == 6) {
            modelList.add(new Model(R.drawable.three));
            modelList.add(new Model(R.drawable.three));
            modelList.add(new Model(R.drawable.three));
            modelList.add(new Model(R.drawable.three));
            modelList.add(new Model(R.drawable.three));
            modelList.add(new Model(R.drawable.three));
            modelList.add(new Model(R.drawable.three));
        }


        CardAdapter cardAdapter = new CardAdapter(modelList,this);
        swipeCardsView.setAdapter(cardAdapter);
    }



}
