package com.example.match;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.comm.arouter.ARouterIntent;
import com.example.comm.arouter.ARouterPath;
import com.example.comm.base.BaseActivity;
import com.example.comm.bean.EventBean;
import com.example.comm.utils.UIUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者: 胡庆岭
 * 创建时间: 2019/12/15
 * 更新时间: 2019/12/15
 * 描述:
 */
@Route(path = ARouterPath.ACTIVITY.MATCH_MAIN)
public class MatchActivity extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_match;
    }

    @Override
    protected void initView() {
        EventBus.getDefault().register(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {

    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void reusltMessageEvent(EventBean bean){
        Log.w("MatchActivity--",bean.message);
        Toast.makeText(UIUtils.getContext(),bean.message,Toast.LENGTH_SHORT).show();
    }



    @OnClick(R2.id.tv_match)
    public void onViewClicked() {
        ARouterIntent.openActivity(ARouterPath.ACTIVITY.APP_MAIN);
        Log.w("MatchActivity--","点击了比赛");
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
}
