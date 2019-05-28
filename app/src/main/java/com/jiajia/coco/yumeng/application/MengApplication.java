package com.jiajia.coco.yumeng.application;

import android.app.Application;

/**
 * @author Create by Jerry
 * @date on 2019-05-28
 * @description 1.整个程序的入口 2.初始化工作 3.为其他模块提供上下文
 */
public class MengApplication extends Application {
    private static MengApplication mApplication = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
    }

    public static MengApplication getInstance() {
        return mApplication;
    }
}
