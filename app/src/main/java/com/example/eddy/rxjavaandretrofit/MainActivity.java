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
        //addToDisposable清理
        addToDisposable(accountService.login(feAccountBo)//首次呼叫login
                .subscribeOn(Schedulers.io())//io thread執行
                .map(tokenDto -> {//成功後,將token記下
                    SpUtils.putParam(MainActivity.this, SpUtils.TOKEN, tokenDto.getData().getAccessToken());
                    return tokenDto;
                })
                //嵌套getUserProfile API, 此處需使用flatMap展開
                .flatMap((Function<TokenDto, SingleSource<PersonalDataDto>>) tokenDto -> personalService.personalData())
                .observeOn(AndroidSchedulers.mainThread()) //回到mainThread處理UI
                .subscribe(
                        //成功
                        personalDataDto ->
                                Log.e("==", "PersonalData:" + personalDataDto.toString()),
                        //失敗
                        throwable ->
                                Log.e("==", "login fail:" + throwable.getMessage())));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SpUtils.putParam(this, SpUtils.TOKEN, "");
    }
}
