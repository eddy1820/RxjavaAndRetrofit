package com.example.eddy.rxjavaandretrofit.view;

import com.example.eddy.rxjavaandretrofit.dto.PersonalDataDto;

public interface
ILoginView {
    void onSuccess(PersonalDataDto personalDataDto);

    void onFail(Throwable throwable);
}
