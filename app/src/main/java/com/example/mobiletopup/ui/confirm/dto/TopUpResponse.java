package com.example.mobiletopup.ui.confirm.dto;

import com.google.gson.annotations.SerializedName;

public class TopUpResponse {
    @SerializedName("status")
    private Boolean status;


    @SerializedName("message")
    private String Message;

    @SerializedName("data")
    Receipt data;


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

    public Receipt getData() {
        return data;
    }

    public void setData(Receipt data) {
        this.data = data;
    }

}
