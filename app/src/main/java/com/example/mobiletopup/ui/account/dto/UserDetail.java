package com.example.mobiletopup.ui.account.dto;

import com.google.gson.annotations.SerializedName;

public class UserDetail {
    @SerializedName("status")
    private Boolean status;

    @SerializedName("message")
    private String Message;

    @SerializedName("data")
    Data data;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
