package com.example.comm.app;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.comm.utils.UIUtils;

/**
 * 作者: 胡庆岭
 * 创建时间: 2019/12/14
 * 更新时间: 2019/12/14
 * 描述: BaseApplication
 */
public class BaseApplication extends Application {
    private static final boolean IS_DEBUG = true;
    @Override
    public void onCreate() {
        super.onCreate();
        UIUtils.init(this);
        initARouter();
    }

    private void initARouter() {
        if (IS_DEBUG){
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);

    }
}
