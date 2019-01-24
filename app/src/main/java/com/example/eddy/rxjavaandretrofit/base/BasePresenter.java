package com.example.eddy.rxjavaandretrofit.base;

import io.reactivex.disposables.CompositeDisposable;

public class BasePresenter {
    //回收RxJava的垃圾桶, 避免memory leak
    public CompositeDisposable disposable = new CompositeDisposable();
    public void onDestroy() {
        disposable.dispose();
    }
}
