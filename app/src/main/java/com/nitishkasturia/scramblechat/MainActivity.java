package com.nitishkasturia.scramblechat;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;

import com.facebook.AccessToken;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (AccessToken.getCurrentAccessToken() == null) {
            Intent loginActivityIntent = new Intent(MainActivity.this, LoginActivity.class);
            loginActivityIntent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(loginActivityIntent);
        }

        setContentView(R.layout.activity_main);
    }
}
