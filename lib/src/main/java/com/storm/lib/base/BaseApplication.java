package com.storm.lib.base;

import android.app.Application;
import android.os.Build;
import android.os.StrictMode;
import android.support.multidex.MultiDex;

import com.storm.lib.StormInit;

/**
 * Created by XYSM on 2018/6/25.
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // android 7.0系统解决拍照的问题
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            builder.detectFileUriExposure();
        }

        //分包
        MultiDex.install(this);

        StormInit.init(this);
    }
}
