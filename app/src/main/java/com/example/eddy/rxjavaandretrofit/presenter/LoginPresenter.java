package com.example.eddy.rxjavaandretrofit.presenter;

import com.example.eddy.rxjavaandretrofit.MyApp;
import com.example.eddy.rxjavaandretrofit.base.BasePresenter;
import com.example.eddy.rxjavaandretrofit.dto.FeAccountBo;
import com.example.eddy.rxjavaandretrofit.dto.PersonalDataDto;
import com.example.eddy.rxjavaandretrofit.dto.TokenDto;
import com.example.eddy.rxjavaandretrofit.model.LoginModel;
import com.example.eddy.rxjavaandretrofit.util.SpUtils;

import io.reactivex.SingleSource;
import io.reactivex.functions.Function;

public class LoginPresenter extends BasePresenter {
    private LoginCallback loginCallback;
    private LoginModel loginModel;

    public interface LoginCallback {
        void onSuccess(PersonalDataDto personalDataDto);
        void onFail(Throwable throwable);
    }


    public LoginPresenter(LoginCallback loginCallback) {
        this.loginCallback = loginCallback;
        this.loginModel = new LoginModel();
    }

    public void login(final FeAccountBo feAccountBo) {
        disposable.add(loginModel.login(feAccountBo)//首次呼叫login
                .map(tokenDto -> {//成功後,將token記下
                    SpUtils.putParam(MyApp.getContext(), SpUtils.TOKEN, tokenDto.getData().getAccessToken());
                    return tokenDto;
                })
                //嵌套getUserProfile API, 此處需使用flatMap展開
                .flatMap((Function<TokenDto, SingleSource<PersonalDataDto>>) tokenDto -> loginModel.getProfile())
                .subscribe(
                        //成功
                        loginCallback::onSuccess,
                        //失敗
                        loginCallback::onFail));
    }
}
