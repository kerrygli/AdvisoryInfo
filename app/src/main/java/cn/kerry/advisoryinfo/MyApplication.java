package cn.kerry.advisoryinfo;

import android.app.Application;
import android.content.Context;

import com.socks.library.KLog;

/**
 * Created by Administrator on 2017/2/15.
 */

public class MyApplication extends Application {

    private static Context mContext;

    public static Context getInstance() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        initDayNightMode();
        KLog.init(true);//设置启动KLog
    }

    private void initDayNightMode() {

    }
}
