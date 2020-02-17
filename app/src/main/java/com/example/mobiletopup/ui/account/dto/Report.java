package com.example.mobiletopup.ui.account.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Report {

    @SerializedName("status")
    private Boolean status;

    @SerializedName("message")
    private String Message;

    @SerializedName("data")
    List <FinancialReport> data;

    public List<FinancialReport> getData() {
        return data;
    }

    public void setData(List<FinancialReport> data) {
        this.data = data;
    }

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


}
