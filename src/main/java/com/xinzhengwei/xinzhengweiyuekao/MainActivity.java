package com.xinzhengwei.xinzhengweiyuekao;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.xinzhengwei.xinzhengweiyuekao.com.bawie.fragment.Fr1;
import com.xinzhengwei.xinzhengweiyuekao.com.bawie.fragment.Fr2;
import com.xinzhengwei.xinzhengweiyuekao.com.bawie.fragment.Fr3;
import com.xinzhengwei.xinzhengweiyuekao.com.bawie.fragment.Fr4;
import com.xinzhengwei.xinzhengweiyuekao.com.bawie.fragment.Fr5;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FrameLayout fl;
    private RadioGroup rg;
    ArrayList<Fragment> list=new ArrayList<>();
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fl = findViewById(R.id.fl);
        rg = findViewById(R.id.rg);
        initfragment();
        manager = getSupportFragmentManager();
        manager.beginTransaction().add(R.id.fl,list.get(0)).commit();
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb1:
                        manager.beginTransaction().replace(R.id.fl,list.get(0)).commit();
                        break;
                    case R.id.rb2:
                        manager.beginTransaction().replace(R.id.fl,list.get(1)).commit();
                        break;
                    case R.id.rb3:
                        manager.beginTransaction().replace(R.id.fl,list.get(2)).commit();
                        break;
                    case R.id.rb4:
                        manager.beginTransaction().replace(R.id.fl,list.get(3)).commit();
                        break;
                    case R.id.rb5:
                        manager.beginTransaction().replace(R.id.fl,list.get(4)).commit();
                        break;
                }
            }
        });
    }

    private void initfragment() {

        Fr1 fr1 = new Fr1();
        Fr2 fr2 = new Fr2();
        Fr3 fr3 = new Fr3();
        Fr4 fr4 = new Fr4();
        Fr5 fr5 = new Fr5();
        list.add(fr1);
        list.add(fr2);
        list.add(fr3);
        list.add(fr4);
        list.add(fr5);

    }
}
