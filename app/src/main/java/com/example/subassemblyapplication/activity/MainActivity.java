package com.example.subassemblyapplication.activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.comm.arouter.ARouterIntent;
import com.example.comm.arouter.ARouterPath;
import com.example.comm.base.BaseActivity;
import com.example.comm.utils.DataUtils;
import com.example.subassemblyapplication.R;
import com.example.subassemblyapplication.adapter.MainBottomAdapter;
import com.example.subassemblyapplication.bean.HomeBottomBean;
import com.example.subassemblyapplication.fragment.MainFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = ARouterPath.ACTIVITY.APP_MAIN)
public class MainActivity extends BaseActivity {
    @BindView(R.id.main_vp)
    ViewPager2 mVpMain;
    @BindView(R.id.rv_tab)
    RecyclerView mRvTab;
    private MainBottomAdapter mBottomTabAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mRvTab.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

    }


    @Override
    protected void initData() {
        List<HomeBottomBean> mTabData = new ArrayList<>();

        HomeBottomBean bean1 = new HomeBottomBean();
        bean1.isCheck = true;
        bean1.name = DataUtils.getString(R.string.home);
        bean1.defaultResId = R.mipmap.icon_main_tab_home_default;
        bean1.checkResId = R.mipmap.icon_main_tab_home_check;
        mTabData.add(bean1);

        HomeBottomBean bean2 = new HomeBottomBean();
        bean2.name = DataUtils.getString(R.string.match);
        bean2.defaultResId = R.mipmap.icon_main_tab_game_default;
        bean2.checkResId = R.mipmap.icon_main_tab_game_check;
        mTabData.add(bean2);

        HomeBottomBean bean3 = new HomeBottomBean();
        bean3.name = DataUtils.getString(R.string.community);
        bean3.defaultResId = R.mipmap.icon_main_tab_community_default;
        bean3.checkResId = R.mipmap.icon_main_tab_community_check;
        mTabData.add(bean3);

        HomeBottomBean bean4 = new HomeBottomBean();
        bean4.name = DataUtils.getString(R.string.my);
        bean4.defaultResId = R.mipmap.icon_main_tab_my_default;
        bean4.checkResId = R.mipmap.icon_main_tab_my_check;
        mTabData.add(bean4);

        mBottomTabAdapter = new MainBottomAdapter(this, mTabData);
        mRvTab.setAdapter(mBottomTabAdapter);
        Fragment[] fragments = {ARouterIntent.getFragment(ARouterPath.FRAGMENT_MAIN, MainFragment.KEY, "首页"),
                ARouterIntent.getFragment(ARouterPath.FRAGMENT_MAIN, MainFragment.KEY, "比赛"),
                ARouterIntent.getFragment(ARouterPath.FRAGMENT_MAIN, MainFragment.KEY, "社区"),
                ARouterIntent.getFragment(ARouterPath.FRAGMENT_MAIN, MainFragment.KEY, "我的")};
        FragmentStateAdapter mFragmentAdapter = new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                return fragments[position];
            }

            @Override
            public int getItemCount() {
                return mTabData.size();
            }
        };
        mVpMain.setAdapter(mFragmentAdapter);
    }

    @Override
    protected void initEvent() {
        mVpMain.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                mBottomTabAdapter.selectorTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
        mBottomTabAdapter.setOnItemClickListener(new MainBottomAdapter.OnItemClickListener() {
            @Override
            public void onClickItem(View view, int position) {
                mVpMain.setCurrentItem(position, true);
            }
        });
    }


}
