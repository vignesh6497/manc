package com.example.xenderx.jsonvolley;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.TweetUtils;
import com.twitter.sdk.android.tweetui.TweetView;

/**
 * Created by vignesh on 09-Nov-16.
 */

public class TabView5 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);

        getActivity().setContentView(R.layout.tweet_feeds);
        // TODO: Use a more specific parent
        final ViewGroup parentView = (ViewGroup) getActivity().getWindow().getDecorView().getRootView();
        // TODO: Base this Tweet ID on some data from elsewhere in your app
        long tweetId = 631879971628183552L;
        TweetUtils.loadTweet(tweetId, new Callback<Tweet>() {
            @Override
            public void success(Result<Tweet> result) {
                TweetView tweetView = new TweetView(getContext(), result.data);
                parentView.addView(tweetView);
            }

            @Override
            public void failure(TwitterException exception) {
                Log.d("TwitterKit", "Load Tweet failure", exception);
            }
        });

        //EmbeddedTweetActivity embeddedTweetActivity = new EmbeddedTweetActivity();
        View view = inflater.inflate(R.layout.tweet_feeds,container,false);

        return view;
    }

}
