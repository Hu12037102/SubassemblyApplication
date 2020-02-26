package com.example.comm.base;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 作者: 胡庆岭
 * 创建时间: 2019/12/14
 * 更新时间: 2019/12/14
 * 描述:
 */
public abstract class BaseFragment extends Fragment {
    public static final String TAG = "BaseFragment";
    private Unbinder mUnBinder;
    private boolean isFirst;
    private boolean isFirstShow;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mRootView = inflater.inflate(getLayoutId(), container, false);
        mUnBinder = ButterKnife.bind(this, mRootView);
        Log.w(TAG,"onCreateView--");
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.w(TAG,"onActivityCreated--");
        initView();
        initData();
        initEvent();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.w(TAG,"setUserVisibleHint--");
        if (isFirst && isVisibleToUser ){
            isFirst = false;
            isFirstShow = true;
        }


    }



    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initEvent();

    protected boolean  isDelayed(){
        return false;
    }


    @Override
    public void onDestroyView() {
        Log.w(TAG,"onDestroyView--");
        mUnBinder.unbind();
        super.onDestroyView();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.w(TAG,"onAttach--");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.w(TAG,"onCreate--");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.w(TAG,"onStart--");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.w(TAG,"onResume--");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.w(TAG,"onStop--");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.w(TAG,"onDestroy--");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.w(TAG,"onDetach--");
    }
}
