package com.nitishkasturia.scramblechat.ui;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nitishkasturia.scramblechat.R;
import com.nitishkasturia.scramblechat.ui.view.ScrambledImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        if (AccessToken.getCurrentAccessToken() == null) {
//            Intent loginActivityIntent = new Intent(MainActivity.this, LoginActivity.class);
//            loginActivityIntent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//            startActivity(loginActivityIntent);
//        }

        setContentView(R.layout.activity_main);

        ScrambledImageView scrambledImageView = (ScrambledImageView) findViewById(R.id.scrambled_image);
        scrambledImageView.setImage(BitmapFactory.decodeResource(getResources(), R.drawable.grid_test));
    }
}
