package com.example.comm.arouter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.comm.utils.DataUtils;

/**
 * 作者: 胡庆岭
 * 创建时间: 2019/12/15
 * 更新时间: 2019/12/15
 * 描述: 路由intent
 */
public class ARouterIntent {
    public static void openActivity( @NonNull String path){
        path =DataUtils.checkNull(path);
        ARouter.getInstance().build(path).navigation();
    }
    public static Fragment getFragment(@NonNull String path){
        path = DataUtils.checkNull(path);
       return (Fragment) ARouter.getInstance().build(path).navigation();
    }
    public static Fragment getFragment(@NonNull String path,@NonNull String key,@NonNull String values){
        path = DataUtils.checkNull(path);
        return (Fragment) ARouter.getInstance().build(path).withString(key,values).navigation();
    }
}
