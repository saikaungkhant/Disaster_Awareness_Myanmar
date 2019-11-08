package com.wahaha.myapplication.Activies;

import android.os.Bundle;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.wahaha.myapplication.R;

public class LandslideVideoActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    YouTubePlayerView mPlayer;
    String key = "AIzaSyDijYWs0gHBv9HmEfiMvFypnF-6XaL5q2I";
    String id = "5BRHr3j_NRo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.land_video);
        mPlayer = (YouTubePlayerView)findViewById(R.id.youtube);
        mPlayer.initialize(key,this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        if (!wasRestored){
            youTubePlayer.cueVideo(id);
            youTubePlayer.play();
        }

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }
}


