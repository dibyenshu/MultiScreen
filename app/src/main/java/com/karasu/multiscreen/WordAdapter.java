package com.karasu.multiscreen;

import android.app.Activity;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    String color;
    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Word currentWord = getItem(position);
        TextView listText1 = listItemView.findViewById(R.id.list_text1);
        listText1.setText(currentWord.getDefaultTranslation());
        listText1.setBackgroundColor(Color.parseColor(color));
        TextView listText2 = listItemView.findViewById(R.id.list_text2);
        listText2.setText(currentWord.getMiwokTranslation());
        listText2.setBackgroundColor(Color.parseColor(color));
        ImageView image = listItemView.findViewById(R.id.image);
        if(color=="#16AFCA")
            image.setVisibility(View.GONE);
        image.setImageResource(currentWord.getImageResourceId());

        return listItemView;
    }

    public WordAdapter(Activity context, ArrayList<Word> word,String col){
        super(context,0,word);
        color=col;
    }
}
