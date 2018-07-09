package com.storm.demo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.storm.demo.databinding.ActivityMainBinding
import com.storm.lib.base.AppBean
import com.storm.lib.utils.EventBusUtil
import com.storm.tool.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding(R.layout.activity_main)
    }

    override fun initData() {
        binding.click = OnClick()
        registerEventBus()
    }

    override fun initListener() {
    }

    override fun receiveEvent(appBean: AppBean<Any>) {
        when (appBean.code) {
            1 -> {
                toasts("接收到了eventbus")
            }
        }
    }

    override fun receiveStickyEvent(appBean: AppBean<Any>) {
    }

    inner class OnClick {
        open fun senBus(view: View) {
            EventBusUtil.sendEvent(AppBean(1, null))
        }

        open fun showToast(view: View) {
            toasts("这是提示框")
        }

        open fun showError(view: View) {
            var s: TextView? = null
            s!!.setText("123")
        }

        open fun startService(view: View) {
            startService(Intent(context, LocationService::class.java))
        }

        open fun stopService(view: View) {
            EventBusUtil.sendEvent(AppBean(2, null))
        }

        open fun showDialog(view: View) {
            jump(TestDialog::class.java)
        }
    }

}
