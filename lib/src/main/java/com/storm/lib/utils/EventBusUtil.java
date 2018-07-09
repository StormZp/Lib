package com.storm.lib.utils;


import com.storm.lib.base.AppBean;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Storm on 2018/2/7.
 */

public class EventBusUtil {
    public static void register(Object subscriber) {
        if (!EventBus.getDefault().isRegistered(subscriber))
            EventBus.getDefault().register(subscriber);
    }

    public static void unregister(Object subscriber) {
        if (EventBus.getDefault().isRegistered(subscriber))
            EventBus.getDefault().unregister(subscriber);
    }

    public static void sendEvent(AppBean event) {
        EventBus.getDefault().post(event);
    }

    public static void sendStickyEvent(AppBean event) {
        EventBus.getDefault().postSticky(event);
    }

    // 其他

}
