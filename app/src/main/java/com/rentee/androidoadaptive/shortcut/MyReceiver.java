package com.rentee.androidoadaptive.shortcut;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import static com.rentee.androidoadaptive.view.MainActivity.TAG;

/**
 * Created by Tian on 17/8/8.
 */

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "onReceive: ");
    }
}
