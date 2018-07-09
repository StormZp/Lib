package com.storm.lib.base;

import android.app.Service;

import com.storm.lib.utils.EventBusUtil;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Objects;

/**
 * Created by XYSM on 2018/6/25.
 */

public abstract class BaseService extends Service {
    private boolean isRegisterEventBus = false;

    @Override
    public void onCreate() {
        super.onCreate();
        registerEventBus();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterEventBus();
    }



    /**
     * 绑定事件总线
     */
    protected void registerEventBus() {
        EventBusUtil.register(this);
        isRegisterEventBus = true;
    }

    /**
     * 取消绑定事件总线
     */
    protected void unregisterEventBus() {
        if (isRegisterEventBus)
            EventBusUtil.unregister(this);
        isRegisterEventBus = false;
    }


    /**
     * eventbus封装
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventBusCome(AppBean<Objects> appBean) {
        if (appBean != null) {
            receiveEvent(appBean);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onStickyEventBusCome(AppBean<Objects> appBean) {
        if (appBean != null) {
            receiveStickyEvent(appBean);
        }
    }

    /**
     * 接收到分发到事件
     *
     * @param appBean 事件
     */
    public abstract void receiveEvent(AppBean<Objects> appBean);

    /**
     * 接受到分发的粘性事件
     *
     * @param appBean 粘性事件
     */
    public abstract void receiveStickyEvent(AppBean<Objects> appBean);
}
