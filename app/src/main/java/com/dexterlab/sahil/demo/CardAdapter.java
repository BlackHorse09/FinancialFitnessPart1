package com.dexterlab.sahil.demo;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;


import com.huxq17.swipecardsview.BaseCardAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CardAdapter extends BaseCardAdapter {

    private List<Model> modelList;
    private Context context;
    int temp,progress;
    SeekBar seekBar;
    String image;
   // private int[] image_resource = {R.drawable.one,R.drawable.three,R.drawable.index};
    public CardAdapter(List<Model> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }

    @Override
    public int getCount() {
        temp = (100/modelList.size());
        return modelList.size();

    }

    @Override
    public int getCardLayoutId() {
        return R.layout.card_item;
    }

    @Override
    public void onBindData(final int position, View cardview) {
        if (modelList.size()==0 || modelList==null) {
            return;
        }


//        ImageView imageView = (ImageView) cardview.findViewById(R.id.imageView);
        TextView textView = (TextView) cardview.findViewById(R.id.textView);
//        Model model = modelList.get(position);
//        Picasso.with(context).load(model.getImage()).into(imageView);

        ImageView imageView = (ImageView) cardview.findViewById(R.id.imageView);
        seekBar = (SeekBar) cardview.findViewById(R.id.seekBar);
        Model model = modelList.get(position);
        imageView.setImageResource(model.getImage());
        progress = temp*(position+1);
        seekBar.setProgress(progress);

        if (position == modelList.size()-1) {
            textView.setText("Learn More>>>");
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context,FinancialFitness.class);
                    context.startActivity(intent);
                }
            });
        }

    }
}



