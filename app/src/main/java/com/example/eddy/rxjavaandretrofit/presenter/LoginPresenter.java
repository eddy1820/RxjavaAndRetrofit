package com.example.eddy.rxjavaandretrofit.presenter;

import com.example.eddy.rxjavaandretrofit.MyApp;
import com.example.eddy.rxjavaandretrofit.base.BasePresenter;
import com.example.eddy.rxjavaandretrofit.dto.FeAccountBo;
import com.example.eddy.rxjavaandretrofit.dto.PersonalDataDto;
import com.example.eddy.rxjavaandretrofit.dto.TokenDto;
import com.example.eddy.rxjavaandretrofit.model.LoginModel;
import com.example.eddy.rxjavaandretrofit.util.SpUtils;
import com.example.eddy.rxjavaandretrofit.view.ILoginView;

import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;

public class LoginPresenter extends BasePresenter {
    private ILoginView loginView;
    private LoginModel loginModel;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
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
                        loginView::onSuccess,
                        //失敗
                        loginView::onFail));

    }
}
