package cn.kerry.advisoryinfo.utils;

import cn.kerry.advisoryinfo.MyApplication;

/**
 * @version 1.0
 */
public class DimenUtil {

    public static float dp2px(float dp) {
        final float scale = MyApplication.getInstance().getResources().getDisplayMetrics().density;
        return dp * scale + 0.5f;
    }

    public static float sp2px(float sp) {
        final float scale = MyApplication.getInstance().getResources().getDisplayMetrics().scaledDensity;
        return sp * scale;
    }

    public static int getScreenSize() {
        return MyApplication.getInstance().getResources().getDisplayMetrics().widthPixels;
    }

}
