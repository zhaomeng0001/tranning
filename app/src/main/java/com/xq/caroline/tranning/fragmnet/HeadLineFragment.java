package com.xq.caroline.tranning.fragmnet;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xq.caroline.tranning.R;

/**
 * Created by caroline on 2017/3/28.
 */

public class HeadLineFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.head_line_fragmnet,container,false);
        return view;
    }

    public static HeadLineFragment newInstance() {
        Bundle args = new Bundle();
        HeadLineFragment fragment = new HeadLineFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
