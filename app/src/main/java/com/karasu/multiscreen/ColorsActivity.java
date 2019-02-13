package com.karasu.multiscreen;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    MediaPlayer.OnCompletionListener Clistener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            mp.release();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> colors = new ArrayList<Word>(8);
        colors.add(new Word("weṭeṭṭi","red",R.drawable.color_red,R.raw.color_red));
        colors.add(new Word("chokokki","green",R.drawable.color_green,R.raw.color_green));
        colors.add(new Word("ṭakaakki","brown",R.drawable.color_brown,R.raw.color_brown));
        colors.add(new Word("ṭopoppi","gray",R.drawable.color_gray,R.raw.color_gray));
        colors.add(new Word("kululli","black",R.drawable.color_black,R.raw.color_black));
        colors.add(new Word("kelelli","white",R.drawable.color_white,R.raw.color_white));
        colors.add(new Word("ṭopiisә","dusty yellow",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        colors.add(new Word("chiwiiṭә","mustard yellow",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));
        

        WordAdapter adapter = new WordAdapter(this,colors,"#8800A0");
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word w = colors.get(position);
                int sid = w.getmSongId();
                MediaPlayer mp = MediaPlayer.create(ColorsActivity.this,sid);
                AudioManager manager = (AudioManager)ColorsActivity.this.getSystemService(Context.AUDIO_SERVICE);
                if(!manager.isMusicActive())
                    mp.start();
                mp.setOnCompletionListener(Clistener);
            }
        });
    }
}
