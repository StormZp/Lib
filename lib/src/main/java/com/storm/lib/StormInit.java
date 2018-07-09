package com.storm.lib;

import android.content.Context;

import com.storm.lib.utils.CrashHandler;
import com.storm.lib.utils.LogUtil;
import com.storm.lib.utils.SharedPreferenceUtil;
import com.storm.lib.utils.ToastUtil;

/**
 * Created by XYSM on 2018/6/25.
 */

public class StormInit {
    private static Context mContext;

    public static void init(Context context) {
        mContext = context;
        ToastUtil.Companion.init(mContext);
        SharedPreferenceUtil.init(mContext);
    }

    /**
     * @param clazz 崩溃后跳转的页面
     */
    public static void setCrach(Class clazz) {
        //崩溃处理
        CrashHandler.getInstance().init(mContext, clazz);
    }

    public static void setLog(boolean islog) {
        LogUtil.setDebug(islog);
    }
}
