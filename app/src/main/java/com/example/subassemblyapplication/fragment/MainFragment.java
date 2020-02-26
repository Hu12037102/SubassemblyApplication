package com.example.subassemblyapplication.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.comm.arouter.ARouterIntent;
import com.example.comm.arouter.ARouterPath;
import com.example.comm.base.BaseFragment;
import com.example.comm.utils.DataUtils;
import com.example.subassemblyapplication.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 作者: 胡庆岭
 * 创建时间: 2019/12/15
 * 更新时间: 2019/12/15
 * 描述:
 */
@Route(path = ARouterPath.FRAGMENT_MAIN)
public class MainFragment extends BaseFragment {
    public static final String KEY = "key";
    @BindView(R.id.btn_main)
    Button mBtnMain;
    private String mValues;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initView() {
        Bundle bundle = DataUtils.checkNull(getArguments());
        mValues = bundle.getString(KEY, "");
        mBtnMain.setText(mValues);
    }

    @OnClick(R.id.btn_main)
    public void onClickView(View view) {
        switch (view.getId()) {
            case R.id.btn_main:
                switch (mValues){
                    case "首页":
                        ARouterIntent.openActivity(ARouterPath.ACTIVITY.HOME_MAIN);
                        break;
                    case "比赛":
                       ARouterIntent.openActivity(ARouterPath.ACTIVITY.MATCH_MAIN);
                        break;
                    case "社区":
                        ARouterIntent.openActivity(ARouterPath.ACTIVITY.COMMUNITY_MAIN);
                        break;
                    case "我的":
                        ARouterIntent.openActivity(ARouterPath.ACTIVITY.MY_MAIN);
                        break;
                }
                break;
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {

    }


}
