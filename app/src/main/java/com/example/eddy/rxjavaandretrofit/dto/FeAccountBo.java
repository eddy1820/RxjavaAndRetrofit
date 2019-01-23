package com.example.eddy.rxjavaandretrofit.dto;

public class FeAccountBo {
    /**
     * accountName : string
     * captchaToken : string
     * password : string
     * verificationCode : string
     */

    private String accountName;
    private String captchaToken;
    private String password;
    private String verificationCode;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getCaptchaToken() {
        return captchaToken;
    }

    public void setCaptchaToken(String captchaToken) {
        this.captchaToken = captchaToken;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
}
