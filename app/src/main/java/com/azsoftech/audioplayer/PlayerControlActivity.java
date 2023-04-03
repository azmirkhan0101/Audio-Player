package com.azsoftech.audioplayer;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class PlayerControlActivity extends AppCompatActivity {


    ImageView iv_player_controlTop;
    TextView player_control_song_tittle;
    ImageView iv_previous,iv_play_pause,iv_next;
    LinearLayout play_button;
    SeekBar seekBar;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_control);

        iv_player_controlTop = findViewById(R.id.iv_player_controlTop);
        player_control_song_tittle = findViewById(R.id.player_control_song_tittle);
        iv_previous = findViewById(R.id.iv_previous);
        iv_play_pause = findViewById(R.id.iv_play_pause);
        iv_next = findViewById(R.id.iv_next);
        play_button = findViewById(R.id.play_button);
        seekBar = findViewById(R.id.seekBar);

        /*
        if( mediaPlayer==null ){
            mediaPlayer = MediaPlayer.create(this, R.raw.aradhona);
        }

         */
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);


        player_control_song_tittle.setSelected(true);

        //CHANGE ACTIVITY
        iv_player_controlTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlayerControlActivity.this,MainActivity.class));
                overridePendingTransition( R.anim.slide_out_up02,R.anim.slide_in_up02 );
            }
        });

        //PREVIOUS SONG
        iv_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                if( mediaPlayer!=null ){
                    mediaPlayer.release();
                    mediaPlayer.start();
                    iv_play_pause.setImageResource(R.drawable.big_pause_white);
                }
                */

            }
        });
        //PLAY SONG
        play_button.setEnabled(false);
        play_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( !mediaPlayer.isPlaying() ){
                    mediaPlayer.start();
                    iv_play_pause.setImageResource(R.drawable.big_pause_white);
                }else{
                    mediaPlayer.pause();
                    iv_play_pause.setImageResource(R.drawable.big_player_white);
                }
            }
        });
        //NEXT SONG
        iv_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                if( mediaPlayer!=null ){
                    mediaPlayer.release();
                    mediaPlayer.start();
                    iv_play_pause.setImageResource(R.drawable.big_pause_white);
                }

                 */

            }
        });

        /*
        int dur = mediaPlayer.getDuration();
        int s = dur/1000;
        int min = s/60;
        int es = s%60;
         */



        seekBar.setMax( mediaPlayer.getDuration() );

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                mediaPlayer.seekTo( progress );

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                iv_play_pause.setImageResource(R.drawable.big_player_white);
            }
        });



    }
    //ONCREATE END




    //BACK PRESSED
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(PlayerControlActivity.this,MainActivity.class));
        overridePendingTransition( R.anim.slide_out_up02,R.anim.slide_in_up02 );
    }
}