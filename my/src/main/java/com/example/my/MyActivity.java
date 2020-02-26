package com.example.my;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.comm.arouter.ARouterPath;
import com.example.comm.base.BaseActivity;

/**
 * 作者: 胡庆岭
 * 创建时间: 2019/12/15
 * 更新时间: 2019/12/15
 * 描述:
 */
@Route(path = ARouterPath.ACTIVITY.MY_MAIN)
public class MyActivity extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_my;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {

    }
}
