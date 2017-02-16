package cn.kerry.advisoryinfo.mvp.persenter.interfaces;

import android.support.annotation.NonNull;

import cn.kerry.advisoryinfo.mvp.view.base.BaseView;

/**
 * presenter基类
 * Created by Administrator on 2017/2/16.
 */

public interface BasePresenter {

    void onCreate();//创建

    void attachView(@NonNull BaseView vid);

    void onDestroy();
}
