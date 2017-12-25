package com.xinzhengwei.xinzhengweiyuekao.com.bawie.fragment.com.bawie.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by 辛政维 on 2017/11/23.
 */

public class Utils {

    public static String getdata(String url){

        StringBuffer sb=new StringBuffer();

        try {
            URL ur=new URL(url);
            HttpURLConnection urlConnection = (HttpURLConnection) ur.openConnection();
            urlConnection.setReadTimeout(8000);
            int responseCode = urlConnection.getResponseCode();
            if(responseCode==200){
                InputStream inputStream = urlConnection.getInputStream();
                BufferedReader br=new BufferedReader(new InputStreamReader(inputStream));
                String line=null;
                while ((line=br.readLine())!=null){
                    sb.append(line);
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

}
