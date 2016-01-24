package com.nitishkasturia.scramblechat.ui;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.facebook.AccessToken;
import com.facebook.login.LoginManager;
import com.nitishkasturia.scramblechat.R;

public class MainActivity extends AppCompatActivity {

    ListView mReceivedMessagesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mReceivedMessagesList = (ListView) findViewById(R.id.received_messages_list);

        if (AccessToken.getCurrentAccessToken() == null) {
            Toast.makeText(MainActivity.this, "NOT LOGGED IN", Toast.LENGTH_SHORT).show();
            LoginManager.getInstance().logInWithReadPermissions(MainActivity.this, null);
        } else {
            Toast.makeText(MainActivity.this, "ALREADY LOGGED IN", Toast.LENGTH_SHORT).show();
        }
    }
}
