package com.example.comm.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.View;

import androidx.annotation.NonNull;

/**
 * 作者: 胡庆岭
 * 创建时间: 2019/12/14
 * 更新时间: 2019/12/14
 * 描述:
 */
public class UIUtils {
    @SuppressLint("StaticFieldLeak")
    private static Context mContext;
    public static void init(@NonNull Context context){
        UIUtils.mContext = context;
    }
    public static Context getContext(){
        return DataUtils.checkNull(mContext);
    }
    /**
     * 设置状态栏字体颜色
     *
     * @param decorView
     * @param dark
     */
    public static void setStatusTextColor(@NonNull View decorView, boolean dark) {
        if (dark) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
        } else {
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }
    }
}
