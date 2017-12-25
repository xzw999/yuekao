package com.xinzhengwei.xinzhengweiyuekao.com.bawie.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.xinzhengwei.xinzhengweiyuekao.R;
import com.xinzhengwei.xinzhengweiyuekao.com.bawie.fragment.com.bawie.bean.Goods1;
import com.xinzhengwei.xinzhengweiyuekao.com.bawie.fragment.com.bawie.util.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 辛政维 on 2017/11/23.
 */

public class Fr1zi10 extends Fragment{

    private String stringurl="http://www.93.gov.cn/93app/data.do?channelId=0&startNum=2";
    private ListView lv;
    ArrayList<Goods1.DataBean> datalist=new ArrayList<>();
    private ImageLoader instance;
    private Fr1zi10.adapter adap;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frzi1_main, container, false);
        instance = ImageLoader.getInstance();
        lv = view.findViewById(R.id.lv);
        adap = new Fr1zi10.adapter();
        lv.setAdapter(adap);
        new Fr1zi10.MascyTask().execute(stringurl);
        return view;
    }

    private class MascyTask extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... strings) {
            return Utils.getdata(strings[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Gson gson=new Gson();
            Goods1 goods = gson.fromJson(s, Goods1.class);
            List<Goods1.DataBean> data = goods.getData();
            datalist.addAll(data);
            adap.notifyDataSetChanged();
        }
    }
    class adapter extends BaseAdapter {

        private Fr1zi10.viewHadler viewHadler1;

        @Override
        public int getCount() {
            return datalist.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            if (view==null){
                viewHadler1 = new Fr1zi10.viewHadler();
                view = View.inflate(getActivity(), R.layout.text1_main, null);
                this.viewHadler1.iv = view.findViewById(R.id.iv);
                this.viewHadler1.tv = view.findViewById(R.id.tv);
                view.setTag(this.viewHadler1);
            }else {
                viewHadler1 = (Fr1zi10.viewHadler)view.getTag();
            }
            instance.displayImage((String) datalist.get(i).getIMAGEURL(),viewHadler1.iv);
            viewHadler1.tv.setText(datalist.get(i).getTITLE());

            return view;
        }
    }

    class viewHadler{

        private ImageView iv;
        private TextView tv;

    }
}
