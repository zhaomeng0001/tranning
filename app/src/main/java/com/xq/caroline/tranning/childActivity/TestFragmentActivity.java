package com.xq.caroline.tranning.childActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.xq.caroline.tranning.R;
import com.xq.caroline.tranning.fragmnet.ArticleFragment;
import com.xq.caroline.tranning.fragmnet.HeadLineFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by caroline on 2017/3/28.
 */

public class TestFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.test_fragment);
        setContentView(R.layout.test_fragment_container);
        ButterKnife.bind(this);
        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            HeadLineFragment headLine = HeadLineFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, headLine).commit();
        }
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, TestFragmentActivity.class);
        context.startActivity(starter);
    }

    @OnClick(R.id.replace_fragment)
    public void onClick() {
        ArticleFragment articleFragment = ArticleFragment.newInstance();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container,articleFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
