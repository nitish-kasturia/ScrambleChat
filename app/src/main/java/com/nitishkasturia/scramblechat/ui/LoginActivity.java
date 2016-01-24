package com.nitishkasturia.scramblechat.ui;

import android.content.Intent;
import android.os.Bundle;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.github.paolorotolo.appintro.AppIntro;
import com.nitishkasturia.scramblechat.R;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseUser;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppIntro {

    @Override
    public void init(Bundle savedInstanceState) {

        ((android.widget.TextView) findViewById(R.id.done)).setText("Sign In");

        addSlide(LandingFragment.newInstance());
        addSlide(SelfieFragment.newInstance());
        addSlide(ScrambleFragment.newInstance());
        addSlide(ShareFragment.newInstance());

        showSkipButton(false);
        setProgressButtonEnabled(true);
    }

    @Override
    public void onSkipPressed() {
        // Do something when users tap on Skip button.
    }

    @Override
    public void onSlideChanged() {
        // Do something when the slide changes.
    }

    @Override
    public void onNextPressed() {
        // Do something when users tap on Next button.
    }

    @Override
    public void onDonePressed() {
        final List<String> permissions = new ArrayList<>();
        permissions.add("public_profile");
        permissions.add("user_friends");
        permissions.add("email");

        ParseFacebookUtils.logInWithReadPermissionsInBackground(this, permissions, new LogInCallback() {
            @Override
            public void done(ParseUser parseUser, ParseException e) {
                if (parseUser == null) {
                    //USER CANCELLED LOGIN
                } else {
                    final ParseUser user = ParseUser.getCurrentUser();

                    Bundle requestParameters = new Bundle();
                    requestParameters.putString("fields", "first_name,last_name,email");

                    GraphRequest request = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                        @Override
                        public void onCompleted(JSONObject object, GraphResponse response) {
                            try {
                                user.put("firstName", object.getString("first_name"));
                                user.put("lastName", object.getString("last_name"));
                                user.put("email", object.getString("email"));
                                user.saveEventually();
                                Intent startMainActivityIntent = new Intent(LoginActivity.this, MainActivity.class);
                                startMainActivityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(startMainActivityIntent);
                            } catch (JSONException e1) {
                                e1.printStackTrace();
                            }
                        }
                    });
                    request.setParameters(requestParameters);
                    request.executeAsync();
                }
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ParseFacebookUtils.onActivityResult(requestCode, resultCode, data);
    }
}
