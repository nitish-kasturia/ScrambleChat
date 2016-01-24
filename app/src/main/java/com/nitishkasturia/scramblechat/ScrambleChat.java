package com.nitishkasturia.scramblechat;

import android.app.Application;
import android.content.res.Resources;
import android.util.TypedValue;

import com.facebook.FacebookSdk;
import com.parse.Parse;
import com.parse.ParseFacebookUtils;

/**
 * Created by Nitish on 2016-01-22.
 */
public class ScrambleChat extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.enableLocalDatastore(this);
        Parse.initialize(this);

        FacebookSdk.sdkInitialize(ScrambleChat.this);
        FacebookSdk.setApplicationId("565400640281287");
        ParseFacebookUtils.initialize(this);
    }

    public static class Utils {
        public static int dpToPx(float dp, Resources resources) {
            float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.getDisplayMetrics());
            return (int) px;
        }
    }
}
