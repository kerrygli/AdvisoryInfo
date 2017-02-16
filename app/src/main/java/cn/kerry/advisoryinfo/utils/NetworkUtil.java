package cn.kerry.advisoryinfo.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import cn.kerry.advisoryinfo.MyApplication;

/**
 * Created by Administrator on 2017/2/16.
 */

public class NetworkUtil {

    /**
     * 检查网络是否可用
     *
     * @return
     */
    public static boolean isNetWorkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) MyApplication.getInstance()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (null != connectivityManager) {
            NetworkInfo info = connectivityManager.getActiveNetworkInfo();
            if (null != info && info.isConnected()) {
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                }
                return true;
            }
        }
        return false;
    }

}
