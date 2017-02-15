package cn.kerry.advisoryinfo.utils;

import android.content.Context;
import android.content.SharedPreferences;

import cn.kerry.advisoryinfo.MyApplication;

/**
 * Created by Administrator on 2017/2/15.
 */

public class SharedPreferencesUti {

    private static final String SHARES_INFO = "shares_info";//该项目的sp文件
    public static final String INIT_DB = "init_db";
    public static final String NIGHT_THEME_MODE = "night_theme_mode";


    /**
     * 获取sp
     *
     * @return
     */
    public static SharedPreferences getSharedPreferences() {
        return MyApplication.getInstance().getSharedPreferences(SHARES_INFO, Context.MODE_PRIVATE);
    }

    /**
     * 判断是否初始化本地数据库
     *
     * @return
     */
    public static boolean isInitDB() {
        return getSharedPreferences().getBoolean(INIT_DB, false);
    }

    /**
     * 判断是否夜间模式
     *
     * @return
     */
    public static boolean isNightMode() {
        return getSharedPreferences().getBoolean(NIGHT_THEME_MODE, false);
    }

    /**
     * 保存是否夜间模式的状态
     *
     * @param isNight
     */
    public static void saveNightMode(boolean isNight) {
        getSharedPreferences().edit()
                .putBoolean(NIGHT_THEME_MODE, isNight)
                .apply();
    }


}
