package bwie.com.jingdong.myapplication;

import android.app.Application;
import android.content.Context;

import com.mob.MobSDK;

/**
 * 文 件 名: MyApplication
 * 创 建 人: 谢兴张
 * 创建日期: 2017/9/13
 * 邮   箱:
 * 博   客:
 * 修改时间：
 * 修改备注：
 */

public class MyApplication extends Application {
    private static Context mAppContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppContext = getApplicationContext();
        MobSDK.init(this, "20fbf8b3dffc6", "891297639b0399e7ac85cd92e719a7a4");
    }

    public static Context getAppContext() {
        return mAppContext;
    }
}
