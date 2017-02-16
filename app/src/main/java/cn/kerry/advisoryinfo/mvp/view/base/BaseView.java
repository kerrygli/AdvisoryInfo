package cn.kerry.advisoryinfo.mvp.view.base;

/**
 * View的基类
 * Created by Administrator on 2017/2/16.
 */

public interface BaseView {

    void showProgress();

    void hideProgress();

    void showMsg(String message);

}
