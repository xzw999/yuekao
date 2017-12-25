package com.xinzhengwei.xinzhengweiyuekao;

import android.app.Application;
import android.os.Environment;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import java.io.File;

/**
 * Created by 辛政维 on 2017/11/23.
 */

public class Mapp extends Application{

         File cacheFile= new File(Environment.getExternalStorageDirectory()+"/"+"imgages");

             @Override
             public void onCreate() {
                 super.onCreate();
                 //初始化组件,链式开发思想,整个框架的参数初始化配置
                 ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this)
                         .memoryCacheExtraOptions(480, 800) // default = device screen dimensions 内存缓存文件的最大长宽
                         .diskCacheExtraOptions(480, 800, null)  // 本地缓存的详细信息(缓存的最大长宽)，最好不要设置这个
                         .tasksProcessingOrder(QueueProcessingType.FIFO) // default
                         .denyCacheImageMultipleSizesInMemory()
                         .diskCache(new UnlimitedDiskCache(cacheFile))//,自定义缓存目录
                         // default为使用HASHCODE对UIL进行加密命名， 还可以用MD5(new Md5FileNameGenerator())加密
                         .diskCacheFileNameGenerator(new HashCodeFileNameGenerator())
                         .defaultDisplayImageOptions(DisplayImageOptions.createSimple()) // default
                         .writeDebugLogs() // 打印debug log
                         .build();

                 ImageLoader.getInstance().init(configuration);

             }
    }

