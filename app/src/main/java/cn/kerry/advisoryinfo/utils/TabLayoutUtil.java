package cn.kerry.advisoryinfo.utils;

import android.support.design.widget.TabLayout;
import android.view.View;

import cn.kerry.advisoryinfo.MyApplication;

/**
 * TabLayout 动态设置相关属性
 * Created by Yoosir on 2016/10/21 0021.
 */
public class TabLayoutUtil {

    public static void dynamicSetTabLayoutMode(TabLayout tabLayout) {
        int tabWidth = calculateTabWidth(tabLayout);
        int screenWidth = getScreenWidth();

        if (tabWidth <= screenWidth) {
            tabLayout.setTabMode(TabLayout.MODE_FIXED);
        } else {
            tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        }
    }

    private static int calculateTabWidth(TabLayout tabLayout) {
        int tabWidth = 0;
        for (int i = 0; i < tabLayout.getChildCount(); i++) {
            final View view = tabLayout.getChildAt(i);
            view.measure(0, 0); //此时不需要考虑父控件布局问题，直接使用getMeasuredWindth获取此View的宽和高
            tabWidth += view.getMeasuredWidth();
        }
        return tabWidth;
    }

    public static int getScreenWidth() {
        return MyApplication.getInstance().getResources().getDisplayMetrics().widthPixels;
    }
}
