package com.example.comm.utils;

import androidx.annotation.ColorRes;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;

/**
 * 作者: 胡庆岭
 * 创建时间: 2019/12/14
 * 更新时间: 2019/12/14
 * 描述:
 */
public class DataUtils {
    public static <T> T checkNull(T t) {
        if (t == null){
            throw new  NullPointerException("t not null");
        }
        return t;
    }

    public static String getString(@StringRes int stringRes) {
       return UIUtils.getContext().getString(stringRes);
    }
    public static int getColor(@ColorRes int resColor){
        return ContextCompat.getColor(UIUtils.getContext(),resColor);
    }
}
