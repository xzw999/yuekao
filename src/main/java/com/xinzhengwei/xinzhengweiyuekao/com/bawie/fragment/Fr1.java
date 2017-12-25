package com.xinzhengwei.xinzhengweiyuekao.com.bawie.fragment;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.xinzhengwei.xinzhengweiyuekao.Mainactivity1;
import com.xinzhengwei.xinzhengweiyuekao.R;

import java.util.ArrayList;

/**
 * Created by 辛政维 on 2017/11/23.
 */

public class Fr1 extends Fragment{

    private TabLayout tl;
    ArrayList<Fragment> fraglist=new ArrayList<>();
    ArrayList<String> tablelist=new ArrayList<>();
    private Button bt;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.table_main, container, false);
        fraglist.clear();
        tl = view.findViewById(R.id.tl);
        ViewPager vp = view.findViewById(R.id.vp);
        bt = view.findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), Mainactivity1.class);
                startActivity(intent);
            }
        });
        init();

        vp.setAdapter(new adapter(getChildFragmentManager()));
        tl.setTabMode(TabLayout.MODE_SCROLLABLE);
        tl.setupWithViewPager(vp);
        tl.setTabTextColors(Color.WHITE,0xFFF8BBD0);

        return view;
    }

    private void init() {

        fraglist.add(new Fr1zi1());
        fraglist.add(new Fr1zi2());
        fraglist.add(new Fr1zi3());
        fraglist.add(new Fr1zi4());
        fraglist.add(new Fr1zi5());
        fraglist.add(new Fr1zi6());
        fraglist.add(new Fr1zi7());
        fraglist.add(new Fr1zi8());
        fraglist.add(new Fr1zi9());
        fraglist.add(new Fr1zi10());
        tablelist.add("头条");
        tablelist.add("社会");
        tablelist.add("国内");
        tablelist.add("国际");
        tablelist.add("娱乐");
        tablelist.add("体育");
        tablelist.add("军事");
        tablelist.add("科技");
        tablelist.add("财经");
        tablelist.add("时尚");

    }

    class adapter extends FragmentPagerAdapter{

        public adapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fraglist.get(position);
        }

        @Override
        public int getCount() {
            return fraglist.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tablelist.get(position);
        }
    }

}
