package com.example.eddy.rxjavaandretrofit.model;

import com.example.eddy.rxjavaandretrofit.dto.FeAccountBo;
import com.example.eddy.rxjavaandretrofit.dto.PersonalDataDto;
import com.example.eddy.rxjavaandretrofit.dto.TokenDto;
import com.example.eddy.rxjavaandretrofit.service.AccountService;
import com.example.eddy.rxjavaandretrofit.service.PersonalService;
import com.example.eddy.rxjavaandretrofit.util.RetrofitUtils;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LoginModel {
    public Single<TokenDto> login(final FeAccountBo feAccountBo) {
        AccountService accountService = RetrofitUtils.getInstance().create(AccountService.class);
        return accountService.login(feAccountBo).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public Single<PersonalDataDto> getProfile() {
        PersonalService personalService = RetrofitUtils.getInstance().create(PersonalService.class);
        return personalService.personalData().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
