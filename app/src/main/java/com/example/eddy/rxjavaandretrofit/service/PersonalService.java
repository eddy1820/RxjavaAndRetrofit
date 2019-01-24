package com.example.eddy.rxjavaandretrofit.service;

import com.example.eddy.rxjavaandretrofit.dto.PersonalDataDto;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface PersonalService {
    @GET("/pd/personal-data")
    Single<PersonalDataDto> personalData();
}
