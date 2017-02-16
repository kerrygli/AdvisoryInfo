package cn.kerry.advisoryinfo.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.view.View;

/**
 * Created by Administrator on 2017/2/15.
 * 设置应用全屏显示，并且沉浸栏，隐藏状态栏
 */
@TargetApi(Build.VERSION_CODES.KITKAT)
public class SystemUiVisibilityUtil {


    private static final int FLAG_IMMERSIVE = View.SYSTEM_UI_FLAG_IMMERSIVE //android4.4以后的沉浸栏方式
            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION //隐藏导航栏
            | View.SYSTEM_UI_FLAG_FULLSCREEN; //全屏显示


    /**
     * 设置屏幕全屏和隐藏导航栏
     *
     * @param activity
     */
    public static void exit(Activity activity) {
        if (Build.VERSION.SDK_INT >= 19) {
            addFlags(activity.getWindow().getDecorView(), FLAG_IMMERSIVE);
        }
    }

    public static void enter(Activity activity) {
        if (Build.VERSION.SDK_INT >= 19) {
            clearFlags(activity.getWindow().getDecorView(), FLAG_IMMERSIVE);
        }
    }

    public static void clearFlags(View view, int flags) {
        view.setSystemUiVisibility(view.getSystemUiVisibility() & flags);

    }


    public static void addFlags(View decorView, int flags) {
        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | flags);
    }

}
