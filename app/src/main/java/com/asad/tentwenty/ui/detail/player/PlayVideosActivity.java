package com.asad.tentwenty.ui.detail.player;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.asad.tentwenty.R;
import com.asad.tentwenty.databinding.ActivityPlayVideosBinding;
/*

public class PlayVideosActivity extends YouTubeBaseActivity {

    ActivityPlayVideosBinding binding;

    private YouTubePlayer.OnInitializedListener listener;

    public static Intent newIntent(Context context, String url) {
        Intent intent = new Intent(context, PlayVideosActivity.class);
        intent.putExtra("url", url);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_play_videos);
        if (getIntent().hasExtra("url")) {
            final String url = getIntent().getStringExtra("url");

            listener = new YouTubePlayer.OnInitializedListener() {
                @Override
                public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

                    youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.MINIMAL);
                    youTubePlayer.setFullscreen(true);
                    youTubePlayer.loadVideo(url);
                    youTubePlayer.play();
                }

                @Override
                public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

                }
            };

            binding.youtubePlayerView.initialize(getString(R.string.youtube_api_key),
                    listener);
        } else {
            finish();
        }
    }
}
*/
