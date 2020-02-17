package com.example.mobiletopup.ui.confirm.dto;

public class TopUp {
    private Integer CurrencyID;
    private Float Amount;
    private TopUpTypes TopUpType;

    public TopUp(Integer currencyID, Float amount, TopUpTypes topUpType) {
        CurrencyID = currencyID;
        Amount = amount;
        TopUpType = topUpType;
    }



}
