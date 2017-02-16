package cn.kerry.advisoryinfo.mvp.ui.activities.base;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import butterknife.ButterKnife;
import cn.kerry.advisoryinfo.R;
import cn.kerry.advisoryinfo.mvp.persenter.interfaces.BasePresenter;
import cn.kerry.advisoryinfo.mvp.ui.activities.HomeActivity;
import rx.Subscription;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {

    protected T mPresenter;
    private WindowManager mWindowManager = null;
    private View mNightView = null;
    private boolean mIsAddedView;

    protected Subscription mSubscription;

    public abstract int getLayoutId();

    public abstract void initVariables();

    public abstract void initViews();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layoutId = getLayoutId();
        setNightOrDayMode();
        setContentView(layoutId);
        initVariables();//初始化变量
        ButterKnife.bind(this);
        initToolBar();
        initViews();//初始化基本控件
        if (null != mPresenter) {
            mPresenter.onCreate();
        }

    }

    /**
     * 菜单点击之后显示的操作
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    finishAfterTransition();
                } else {
                    finish();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 不是HomeActivity要设置标题栏
     */
    private void initToolBar() {
        if (!(this instanceof HomeActivity)) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
        }
    }

    /**
     * 设置应用的主题样式，必须在setContentView()方法之前调用
     */
    private void setNightOrDayMode() {

    }

    @Override
    protected void onDestroy() {
        if (null != mPresenter) {
            //presenter层销毁
            mPresenter.onDestroy();
        }
        //解绑订阅
        if (null != mSubscription && !mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
        super.onDestroy();
    }


}
