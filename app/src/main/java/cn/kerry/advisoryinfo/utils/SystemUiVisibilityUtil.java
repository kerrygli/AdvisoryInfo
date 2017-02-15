package cn.kerry.advisoryinfo.utils;

import android.app.Activity;
import android.os.Build;
import android.view.View;

/**
 * Created by Administrator on 2017/2/15.
 */

public class SystemUiVisibilityUtil {


    private static final int FLAG_IMMERSIVE = View.SYSTEM_UI_FLAG_IMMERSIVE
            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION //隐藏导航栏
            | View.SYSTEM_UI_FLAG_FULLSCREEN; //全屏显示


    public static void exit(Activity activity) {
        if (Build.VERSION.SDK_INT >= 19) {

        }
    }


    public static void addFlags(View decorView, int flags) {
        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | flags);
    }

}
