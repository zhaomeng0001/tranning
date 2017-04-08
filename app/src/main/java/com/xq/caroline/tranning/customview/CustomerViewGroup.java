package com.xq.caroline.tranning.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by caroline on 2017/3/24.
 */

public class CustomerViewGroup extends ViewGroup{


    public CustomerViewGroup(Context context) {
        super(context);
    }

    public CustomerViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomerViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomerViewGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
