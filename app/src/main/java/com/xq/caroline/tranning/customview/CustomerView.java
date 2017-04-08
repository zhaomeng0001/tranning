package com.xq.caroline.tranning.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by caroline on 2017/3/24.
 */

public class CustomerView extends View{


    @Override
    public View getRootView() {
        return super.getRootView();
    }

    WindowManager wm;

    public CustomerView(Context context) {
        super(context);
    }

    public CustomerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomerView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
