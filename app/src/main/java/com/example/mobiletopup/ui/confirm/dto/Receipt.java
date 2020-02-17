package com.example.mobiletopup.ui.confirm.dto;

import com.google.gson.annotations.SerializedName;

public class Receipt {

    @SerializedName("AmountFC")
    private  Double AmountFC;

    @SerializedName("InvoiceNo")
    private String InvoiceNo;

    @SerializedName("CurrencyName")
    private String  CurrencyName;

    public Double getAmountFC() {
        return AmountFC;
    }

    public void setAmountFC(Double amountFC) {
        AmountFC = amountFC;
    }

    public String getInvoiceNo() {
        return InvoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        InvoiceNo = invoiceNo;
    }

    public String getCurrencyName() {
        return CurrencyName;
    }

    public void setCurrencyName(String currencyName) {
        CurrencyName = currencyName;
    }

}
