package com.example.home.activity;

import android.os.Bundle;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.comm.arouter.ARouterIntent;
import com.example.comm.arouter.ARouterPath;
import com.example.comm.base.BaseActivity;
import com.example.comm.bean.EventBean;
import com.example.home.R;
import com.example.home.R2;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者: 胡庆岭
 * 创建时间: 2019/12/9
 * 更新时间: 2019/12/9
 * 描述:
 */
@Route(path = ARouterPath.ACTIVITY.HOME_MAIN)
public class HomeActivity extends BaseActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {
        Log.w("HomeActivity", "我是首页");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {

    }


    @OnClick(R2.id.tv_home)
    public void onViewClicked() {
        Log.w("HomeActivity", "点击了我");
        ARouterIntent.openActivity(ARouterPath.ACTIVITY.APP_MAIN);
        EventBus.getDefault().postSticky(new EventBean("my name is HuGe"));
    }



}
