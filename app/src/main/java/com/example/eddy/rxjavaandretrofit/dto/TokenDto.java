package com.example.eddy.rxjavaandretrofit.dto;

public class TokenDto {
    @Override
    public String toString() {
        return "TokenDto{" +
                "status=" + status +
                ", data=" + data +
                '}';
    }

    /**
     * status : 0
     * data : {"accessToken":"e3e6164b-f40d-4cfa-8b91-d37434a95dce","expireTime":35999}
     */

    private int status;
    private DataBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * accessToken : e3e6164b-f40d-4cfa-8b91-d37434a95dce
         * expireTime : 35999
         */

        private String accessToken;
        private int expireTime;

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public int getExpireTime() {
            return expireTime;
        }

        public void setExpireTime(int expireTime) {
            this.expireTime = expireTime;
        }
    }
}
