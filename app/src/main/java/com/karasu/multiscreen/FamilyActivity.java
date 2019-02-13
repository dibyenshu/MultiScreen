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

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> family = new ArrayList<Word>(10);
        family.add(new Word("әpә","father",R.drawable.family_father,R.raw.family_father));
        family.add(new Word("әṭa","mom",R.drawable.family_mother,R.raw.family_mother));
        family.add(new Word("angsi","son",R.drawable.family_son,R.raw.family_son));
        family.add(new Word("tune","daughter",R.drawable.family_daughter,R.raw.family_daughter));
        family.add(new Word("taachi","older brother",R.drawable.family_older_brother,R.raw.family_older_brother));
        family.add(new Word("chalitti","younger brother",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        family.add(new Word("teṭe","older sister",R.drawable.family_older_sister,R.raw.family_older_sister));
        family.add(new Word("kolliti","younger sister",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        family.add(new Word("ama","grandmother",R.drawable.family_grandmother,R.raw.family_grandmother));
        family.add(new Word("paapa","grandfather",R.drawable.family_grandfather,R.raw.family_grandfather));

        WordAdapter adapter = new WordAdapter(this,family,"#379237");
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word w = family.get(position);
                int sid = w.getmSongId();
                MediaPlayer mp = MediaPlayer.create(FamilyActivity.this,sid);
                AudioManager manager = (AudioManager)FamilyActivity.this.getSystemService(Context.AUDIO_SERVICE);
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
