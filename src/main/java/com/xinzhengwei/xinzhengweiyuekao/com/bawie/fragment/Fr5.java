package com.xinzhengwei.xinzhengweiyuekao.com.bawie.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by 辛政维 on 2017/11/23.
 */

public class Fr5 extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        TextView tv = new TextView(getActivity());

        tv.setText("第五个");

        return tv;
    }
}
