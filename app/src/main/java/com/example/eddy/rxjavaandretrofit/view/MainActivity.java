package com.example.eddy.rxjavaandretrofit.view;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.example.eddy.rxjavaandretrofit.R;
import com.example.eddy.rxjavaandretrofit.dto.FeAccountBo;
import com.example.eddy.rxjavaandretrofit.dto.PersonalDataDto;
import com.example.eddy.rxjavaandretrofit.presenter.LoginPresenter;
import com.example.eddy.rxjavaandretrofit.util.SpUtils;


public class MainActivity extends AppCompatActivity implements ILoginView {
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginPresenter = new LoginPresenter(this);
        initView();
    }



    private void initView() {
        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(v -> {
            FeAccountBo feAccountBo = new FeAccountBo();
            feAccountBo.setAccountName("account0001");
            feAccountBo.setCaptchaToken("string");
            feAccountBo.setPassword("a11111111a");
            feAccountBo.setVerificationCode("string");
            loginPresenter.login(feAccountBo);
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.onDestroy();
        SpUtils.putParam(this, SpUtils.TOKEN, "");
    }

    @Override
    public void onSuccess(PersonalDataDto personalDataDto) {
        Log.e("==", "PersonalData:" + personalDataDto.toString());
    }

    @Override
    public void onFail(Throwable throwable) {
        Log.e("==", "login fail:" + throwable.getMessage());
    }
}
