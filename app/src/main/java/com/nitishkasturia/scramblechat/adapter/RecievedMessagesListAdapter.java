package com.nitishkasturia.scramblechat.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.parse.ParseUser;

/**
 * Created by Nitish on 2016-01-24.
 */
public class RecievedMessagesListAdapter extends ArrayAdapter<ParseUser> {

    public RecievedMessagesListAdapter(Context context, int resource) {
        super(context, resource);
    }
}
