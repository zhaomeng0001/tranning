package com.xq.caroline.tranning.childActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by caroline on 2017/3/15.
 */

public class FitDiffLanguageActivity extends Activity {
    private static final String TAG = "FitDiffLanguageActivity";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: ");
    }
    public static void start(Context context) {
        Intent starter = new Intent(context, FitDiffLanguageActivity.class);
        context.startActivity(starter);
    }
}
