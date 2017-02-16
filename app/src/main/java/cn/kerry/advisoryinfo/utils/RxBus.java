package cn.kerry.advisoryinfo.utils;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Created by Administrator on 2017/2/16.
 * RxBus实现事件总线：使android各组件之间的通信变的简单，最重要的解耦。
 */

public class RxBus {

    private static volatile RxBus mRxBus;//volatile java中一种稍弱的线程同步机制，用来保证将变量的更新操作通知到其他线程

    private final Subject<Object, Object> mSubject;

    /**
     * subject既充当订阅者又充当被订阅者，并且是非线程安全的，
     * 转化为线程安全的
     */
    public RxBus() {
        mSubject = new SerializedSubject<>(PublishSubject.create());
    }

    public static RxBus getInstance() {
        if (null == mRxBus) {//提高已经存在的对象访问率
            synchronized (RxBus.class) {//加锁，防止多线程安全问题
                if (null == mRxBus) {
                    mRxBus = new RxBus();
                }
            }
        }
        return mRxBus;
    }

    /**
     * 订阅事件
     *
     * @param o
     */
    public void post(Object o) {
        mSubject.onNext(o);
    }

    /**
     * 根据传递的eventType 类型返回特定类型的被观察者
     *
     * @param eventType
     * @param <T>
     * @return
     */
    public <T> Observable<T> toObservale(Class<T> eventType) {
        return mSubject.ofType(eventType);
    }


}
