package com.example.eddy.rxjavaandretrofit.util;

import android.support.v7.app.AppCompatActivity;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;


public class BaseActivity extends AppCompatActivity {
    private CompositeDisposable disposable = new CompositeDisposable();

    public void addToDisposable(Disposable observable) {
         disposable.add(observable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.dispose();
    }
}
