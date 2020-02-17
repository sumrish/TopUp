package com.example.mobiletopup.db;

public interface PreferencesHelper {

    String getAccountInfo();

    void setAccountInfo(String accountInfo);

    float getTopUpAmount();

    void setTopUpAmount(float amount);

    int getPaymentMethod();

    void setPaymentMethod(int method);
}
