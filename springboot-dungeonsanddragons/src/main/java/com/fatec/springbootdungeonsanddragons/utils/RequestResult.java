package com.fatec.springbootdungeonsanddragons.utils;

public class RequestResult<T> {
    private int statusCode;
    private String errorMessage;
    private boolean hasErrors;
    private T data;
    private boolean hasData;

    public RequestResult(T data){
        this.data = data;
        this.hasData = true;
        this.statusCode = 1;
    }

    public RequestResult(){
    }

    public RequestResult success() {
        RequestResult reqRes = new RequestResult();
        reqRes.setStatusCode(1);
        return reqRes;
    }

    public RequestResult error(String errorMessage) {
        RequestResult reqRes = new RequestResult();
        reqRes.setHasErrors(true);
        reqRes.setErrorMessage(errorMessage);
        reqRes.setStatusCode(0);
        return reqRes;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public boolean isHasErrors() {
        return hasErrors;
    }

    public void setHasErrors(boolean hasErrors) {
        this.hasErrors = hasErrors;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isHasData() {
        return hasData;
    }

    public void setHasData(boolean hasData) {
        this.hasData = hasData;
    }


}
