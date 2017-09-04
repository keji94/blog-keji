package com.keji.blog.constans;

public enum BaseError {
    SYSTEM_ERROR("system error","系统错误"),
    PARAM_ERROR("param error","参数错误，请检查参数的合法性");


    private String errorCode;

    private String errorMsg;

    BaseError(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
