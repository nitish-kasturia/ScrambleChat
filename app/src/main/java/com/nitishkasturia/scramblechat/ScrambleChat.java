package com.nitishkasturia.scramblechat;

import android.app.Application;

import com.facebook.FacebookSdk;

/**
 * Created by Nitish on 2016-01-22.
 */
public class ScrambleChat extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FacebookSdk.sdkInitialize(ScrambleChat.this);
    }
}
