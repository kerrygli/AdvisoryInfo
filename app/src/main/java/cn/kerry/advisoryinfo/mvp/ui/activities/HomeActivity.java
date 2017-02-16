package cn.kerry.advisoryinfo.mvp.ui.activities;

import android.os.Bundle;

import cn.kerry.advisoryinfo.R;
import cn.kerry.advisoryinfo.mvp.ui.activities.base.BaseActivity;

public class HomeActivity  extends BaseActivity{

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public void initVariables() {

    }

    @Override
    public void initViews() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
}
