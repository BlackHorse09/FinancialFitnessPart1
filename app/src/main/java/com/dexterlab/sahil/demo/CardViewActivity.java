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
            modelList.add(new Model(R.drawable.c11));
            modelList.add(new Model(R.drawable.c12));
            }

        else if (number == 1) {
            modelList.add(new Model(R.drawable.c21));
            modelList.add(new Model(R.drawable.card22));
            modelList.add(new Model(R.drawable.c23));
            modelList.add(new Model(R.drawable.c24));
            modelList.add(new Model(R.drawable.c25));


        }
        else if (number == 2) {
            modelList.add(new Model(R.drawable.c31));
            modelList.add(new Model(R.drawable.c32));
            modelList.add(new Model(R.drawable.c33));
            modelList.add(new Model(R.drawable.c34));
            modelList.add(new Model(R.drawable.c35));

        }
        else if (number == 3) {
            modelList.add(new Model(R.drawable.c41));
            modelList.add(new Model(R.drawable.c42));
            modelList.add(new Model(R.drawable.c43));
            modelList.add(new Model(R.drawable.c44));

        }
        else if (number == 4) {
             modelList.add(new Model(R.drawable.c5));
            modelList.add(new Model(R.drawable.c52));
        }
        else if (number == 5) {
            modelList.add(new Model(R.drawable.c61));
            modelList.add(new Model(R.drawable.c62));
            modelList.add(new Model(R.drawable.c63));
            modelList.add(new Model(R.drawable.c64));

        }
        else if (number == 6) {
            modelList.add(new Model(R.drawable.c71));
            modelList.add(new Model(R.drawable.c72));
            modelList.add(new Model(R.drawable.c73));
            modelList.add(new Model(R.drawable.c74));

        }


        CardAdapter cardAdapter = new CardAdapter(modelList,this);
        swipeCardsView.setAdapter(cardAdapter);
    }



}
