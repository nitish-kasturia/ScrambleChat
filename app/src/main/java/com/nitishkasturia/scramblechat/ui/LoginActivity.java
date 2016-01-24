package com.nitishkasturia.scramblechat.ui;

import android.os.Bundle;

import com.github.paolorotolo.appintro.AppIntro;

public class LoginActivity extends AppIntro {

    @Override
    public void init(Bundle savedInstanceState) {

        addSlide(LandingFragment.newInstance());
        addSlide(SelfieFragment.newInstance());
        addSlide(ScrambleFragment.newInstance());
        addSlide(ShareFragment.newInstance());

        // OPTIONAL METHODS
        // Override bar/separator color.
        // setBarColor(Color.parseColor("#3F51B5"));
        // setSeparatorColor(Color.parseColor("#2196F3"));

        // Hide Skip/Done button.
        showSkipButton(false);
        setProgressButtonEnabled(false);

        // Turn vibration on and set intensity.
        // NOTE: you will probably need to ask VIBRATE permission in Manifest.
        setVibrate(true);
        setVibrateIntensity(30);
    }

    @Override
    public void onSkipPressed() {
        // Do something when users tap on Skip button.
    }

    @Override
    public void onDonePressed() {
        // Do something when users tap on Done button.
    }

    @Override
    public void onSlideChanged() {
        // Do something when the slide changes.
    }

    @Override
    public void onNextPressed() {
        // Do something when users tap on Next button.
    }

}
