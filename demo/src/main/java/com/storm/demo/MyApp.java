package com.storm.demo;

import com.storm.lib.StormInit;
import com.storm.lib.base.BaseApplication;

/**
 * Created by XYSM on 2018/6/25.
 */

public class MyApp extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();

        StormInit.setCrach(MainActivity.class);
    }
}
