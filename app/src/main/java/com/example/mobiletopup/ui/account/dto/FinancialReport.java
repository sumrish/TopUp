package com.example.mobiletopup.ui.account.dto;

import com.google.gson.annotations.SerializedName;

public class FinancialReport {
    @SerializedName("CurrencyID")
    private Integer CurrencyID;

    @SerializedName("CurrencyName")
    private String CurrencyName;

    @SerializedName("ClosingBalance")
    private Float ClosingBalance;

    public Integer getCurrencyID() {
        return CurrencyID;
    }

    public void setCurrencyID(Integer currencyID) {
        CurrencyID = currencyID;
    }

    public String getCurrencyName() {
        return CurrencyName;
    }

    public void setCurrencyName(String currencyName) {
        CurrencyName = currencyName;
    }

    public Float getClosingBalance() {
        return ClosingBalance;
    }

    public void setClosingBalance(Float closingBalance) {
        ClosingBalance = closingBalance;
    }

}
