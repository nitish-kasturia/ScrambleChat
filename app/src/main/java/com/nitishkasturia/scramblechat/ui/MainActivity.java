package com.nitishkasturia.scramblechat.ui;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.login.LoginManager;
import com.nitishkasturia.scramblechat.R;

public class MainActivity extends AppCompatActivity {

    ViewPager mViewPager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.main_viewpager);

        if (AccessToken.getCurrentAccessToken() == null) {
            Toast.makeText(MainActivity.this, "NOT LOGGED IN", Toast.LENGTH_SHORT).show();
            LoginManager.getInstance().logInWithReadPermissions(MainActivity.this, null);
        } else {
            Toast.makeText(MainActivity.this, "ALREADY LOGGED IN", Toast.LENGTH_SHORT).show();
        }
    }
}
