package com.storm.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.storm.demo.databinding.DialogTestBinding;
import com.storm.lib.base.AppBean;
import com.storm.lib.base.BaseOnClick;
import com.storm.tool.base.BaseActivity;

import org.jetbrains.annotations.NotNull;

/**
 * Created by XYSM on 2018/6/25.
 */

public class TestDialog extends BaseActivity<DialogTestBinding> {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBinding(R.layout.dialog_test);
    }

    @Override
    public void initData() {
        binding.setClick(new OnClick());

    }

    @Override
    public void initListener() {

    }

    @Override
    public void receiveEvent(@NotNull AppBean appBean) {

    }

    @Override
    public void receiveStickyEvent(@NotNull AppBean appBean) {

    }

   public class OnClick implements BaseOnClick {

        @Override
        public void onFinish(View view) {
            finish();
        }
    }
}
