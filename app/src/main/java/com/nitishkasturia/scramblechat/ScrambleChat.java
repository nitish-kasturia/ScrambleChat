package com.nitishkasturia.scramblechat;

import android.app.Application;
import android.content.res.Resources;
import android.util.TypedValue;

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

    public static class Utils {
        public static int dpToPx(float dp, Resources resources) {
            float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.getDisplayMetrics());
            return (int) px;
        }
    }
}
