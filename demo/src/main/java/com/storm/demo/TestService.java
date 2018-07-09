package com.storm.demo;

import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.storm.lib.base.AppBean;
import com.storm.lib.base.BaseService;
import com.storm.lib.utils.ToastUtil;

import java.util.Objects;

/**
 * Created by XYSM on 2018/6/25.
 */

public class TestService extends BaseService {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ToastUtil.Companion.toasts("服务启动了");
    }

    @Override
    public void receiveEvent(AppBean<Objects> appBean) {
        switch (appBean.getCode()) {
            case 2:
                ToastUtil.Companion.toasts("要被销毁了");
                stopSelf();
                break;
        }
    }

    @Override
    public void onDestroy() {
        ToastUtil.Companion.toasts("销毁了");
        super.onDestroy();
    }

    @Override
    public void receiveStickyEvent(AppBean<Objects> appBean) {

    }
}
