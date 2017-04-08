package com.xq.caroline.tranning.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.xq.caroline.tranning.R;
import com.xq.caroline.tranning.childActivity.TestFragmentActivity;
import com.xq.caroline.tranning.childActivity.TestRecycleViewActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        btn = (Button) findViewById(R.id.swipe_fresh_layout);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestRecycleViewActivity.start(MainActivity.this);
            }
        });
    }

    @OnClick({R.id.fit_different_language, R.id.customer_view, R.id.fragment})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fit_different_language:
                break;
            case R.id.customer_view:
                break;
            case R.id.fragment:
                TestFragmentActivity.start(this);
                break;
        }
    }

//    @OnClick({R.id.fit_different_language, R.id.customer_view})
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.fit_different_language:
//                FitDiffLanguageActivity.start(this);
//                break;
//            case R.id.customer_view:
//                CustomViewActivity.start(this);
//                break;
//        }
//    }
}
