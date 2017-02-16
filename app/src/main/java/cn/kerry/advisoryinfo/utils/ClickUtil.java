package cn.kerry.advisoryinfo.utils;

import android.os.SystemClock;

/**
 * Created by Administrator on 2017/2/16.
 */

public class ClickUtil {

    private static long mLastClickTime = 0;
    private static final int SPACE_TIME = 500;

    /**
     * 屏蔽快速点击
     *
     * @return
     */
    public static boolean isFastDoubleClick() {
        long time = SystemClock.elapsedRealtime();
        if (time - mLastClickTime < SPACE_TIME) {
            return true;
        } else {
            mLastClickTime = time;
            return false;
        }
    }
}
