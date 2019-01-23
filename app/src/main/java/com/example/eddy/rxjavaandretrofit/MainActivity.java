package com.example.eddy.rxjavaandretrofit;


import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.example.eddy.rxjavaandretrofit.dto.FeAccountBo;
import com.example.eddy.rxjavaandretrofit.dto.PersonalDataDto;
import com.example.eddy.rxjavaandretrofit.dto.TokenDto;
import com.example.eddy.rxjavaandretrofit.service.AccountService;
import com.example.eddy.rxjavaandretrofit.service.PersonalService;
import com.example.eddy.rxjavaandretrofit.util.BaseActivity;
import com.example.eddy.rxjavaandretrofit.util.RetrofitUtils;
import com.example.eddy.rxjavaandretrofit.util.SpUtils;

import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn);


        btn.setOnClickListener(v -> {
            FeAccountBo feAccountBo = new FeAccountBo();
            feAccountBo.setAccountName("account0001");
            feAccountBo.setCaptchaToken("string");
            feAccountBo.setPassword("a11111111a");
            feAccountBo.setVerificationCode("string");
            getUserProfile(feAccountBo);
        });
    }


    private void getUserProfile(FeAccountBo feAccountBo) {
        AccountService accountService = RetrofitUtils.getInstance().create(AccountService.class);
        PersonalService personalService = RetrofitUtils.getInstance().create(PersonalService.class);
        addToDisposable(accountService.login(feAccountBo)
                .subscribeOn(Schedulers.io())
                .map(tokenDto -> {
                    SpUtils.putParam(MainActivity.this, SpUtils.TOKEN, tokenDto.getData().getAccessToken());
                    return tokenDto;
                })
                .flatMap((Function<TokenDto, SingleSource<PersonalDataDto>>) tokenDto -> personalService.personalData())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(personalDataDto -> Log.e("==", "PersonalData:" + personalDataDto.toString()),
                        f -> Log.e("==", "login fail:" + f.getMessage())));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SpUtils.putParam(this, SpUtils.TOKEN, "");
    }
}
