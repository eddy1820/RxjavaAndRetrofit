package com.example.eddy.rxjavaandretrofit.service;

import com.example.eddy.rxjavaandretrofit.dto.FeAccountBo;
import com.example.eddy.rxjavaandretrofit.dto.TokenDto;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AccountService {
    @POST("/fe/login")
    Single<TokenDto> login(@Body FeAccountBo feAccountBo);
}