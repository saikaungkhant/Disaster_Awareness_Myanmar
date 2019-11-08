package com.wahaha.myapplication.Activies;

import android.os.Bundle;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.wahaha.myapplication.R;

import java.security.Provider;

import static com.google.android.youtube.player.YouTubePlayer.*;

public class CycloneVideoActivity extends YouTubeBaseActivity implements OnInitializedListener {

    YouTubePlayerView mPlayer;
    String key = "AIzaSyDijYWs0gHBv9HmEfiMvFypnF-6XaL5q2I";
    String id = "ayO-yT4L3mA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cyclone_video);
        mPlayer = (YouTubePlayerView)findViewById(R.id.youtube);
        mPlayer.initialize(key,this);
    }



    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        if (!b){
            youTubePlayer.cueVideo(id);
            youTubePlayer.play();
        }


    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }
}

