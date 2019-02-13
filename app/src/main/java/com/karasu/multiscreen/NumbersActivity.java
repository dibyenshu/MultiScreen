package com.karasu.multiscreen;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> numbers = new ArrayList<Word>(10);
        numbers.add(new Word("lutti","one",R.drawable.number_one,R.raw.number_one));
        numbers.add(new Word("otiiko","Two",R.drawable.number_two,R.raw.number_two));
        numbers.add(new Word("talookosu","Three",R.drawable.number_three,R.raw.number_three));
        numbers.add(new Word("oyyisa","Four",R.drawable.number_four,R.raw.number_four));
        numbers.add(new Word("massokka","Five",R.drawable.number_five,R.raw.number_five));
        numbers.add(new Word("temmokka","Six",R.drawable.number_six,R.raw.number_six));
        numbers.add(new Word("kenekaku","Seven",R.drawable.number_seven,R.raw.number_seven));
        numbers.add(new Word("kawinta","Eight",R.drawable.number_eight,R.raw.number_eight));
        numbers.add(new Word("wo'e","Nine",R.drawable.number_nine,R.raw.number_nine));
        numbers.add(new Word("na'aacha","Ten",R.drawable.number_ten,R.raw.number_ten));


        WordAdapter adapter = new WordAdapter(this,numbers,"#FD8E09");
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word w = numbers.get(position);
                int sid = w.getmSongId();
                MediaPlayer mp = MediaPlayer.create(NumbersActivity.this,sid);
                AudioManager manager = (AudioManager)NumbersActivity.this.getSystemService(Context.AUDIO_SERVICE);
                if(!manager.isMusicActive())
                    mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
            }
        });


    }



}
