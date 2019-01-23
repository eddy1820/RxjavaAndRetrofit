package com.example.eddy.rxjavaandretrofit.dto;

import java.util.List;

public class PersonalDataDto {

    @Override
    public String toString() {
        return "PersonalDataDto{" +
                "code='" + code + '\'' +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                ", status=" + status +
                ", traceId='" + traceId + '\'' +
                ", errorFields=" + errorFields +
                '}';
    }

    /**
     * code : string
     * data : {"accountName":"string","birthday":"2019-01-23T06:01:50.057Z","city":"string","county":"string","email":"string","gender":"F","mobilePhone":"string","nickname":"string","passwordStrength":"string","province":"string","realName":"string","sticker":"string","street":"string","uid":"string"}
     * errorFields : ["string"]
     * msg : string
     * status : 0
     * traceId : string
     */

    private String code;
    private DataBean data;
    private String msg;
    private int status;
    private String traceId;
    private List<String> errorFields;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public List<String> getErrorFields() {
        return errorFields;
    }

    public void setErrorFields(List<String> errorFields) {
        this.errorFields = errorFields;
    }

    public static class DataBean {
        @Override
        public String toString() {
            return "DataBean{" +
                    "accountName='" + accountName + '\'' +
                    ", birthday='" + birthday + '\'' +
                    ", city='" + city + '\'' +
                    ", county='" + county + '\'' +
                    ", email='" + email + '\'' +
                    ", gender='" + gender + '\'' +
                    ", mobilePhone='" + mobilePhone + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", passwordStrength='" + passwordStrength + '\'' +
                    ", province='" + province + '\'' +
                    ", realName='" + realName + '\'' +
                    ", sticker='" + sticker + '\'' +
                    ", street='" + street + '\'' +
                    ", uid='" + uid + '\'' +
                    '}';
        }

        /**
         * accountName : string
         * birthday : 2019-01-23T06:01:50.057Z
         * city : string
         * county : string
         * email : string
         * gender : F
         * mobilePhone : string
         * nickname : string
         * passwordStrength : string
         * province : string
         * realName : string
         * sticker : string
         * street : string
         * uid : string
         */

        private String accountName;
        private String birthday;
        private String city;
        private String county;
        private String email;
        private String gender;
        private String mobilePhone;
        private String nickname;
        private String passwordStrength;
        private String province;
        private String realName;
        private String sticker;
        private String street;
        private String uid;

        public String getAccountName() {
            return accountName;
        }

        public void setAccountName(String accountName) {
            this.accountName = accountName;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCounty() {
            return county;
        }

        public void setCounty(String county) {
            this.county = county;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getMobilePhone() {
            return mobilePhone;
        }

        public void setMobilePhone(String mobilePhone) {
            this.mobilePhone = mobilePhone;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getPasswordStrength() {
            return passwordStrength;
        }

        public void setPasswordStrength(String passwordStrength) {
            this.passwordStrength = passwordStrength;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public String getSticker() {
            return sticker;
        }

        public void setSticker(String sticker) {
            this.sticker = sticker;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }
    }
}
