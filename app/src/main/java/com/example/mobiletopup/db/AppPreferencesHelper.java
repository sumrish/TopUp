package com.example.mobiletopup.db;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.mobiletopup.di.qualifiers.ApplicationContext;
import com.example.mobiletopup.di.qualifiers.PreferenceInfo;
import com.example.mobiletopup.utils.S;

import javax.inject.Inject;

public class AppPreferencesHelper implements PreferencesHelper {
    private SharedPreferences mPrefs;

    private static final String PREF_KEY_ACCOUNT_INFO = "PREF_KEY_ACCOUNT_INFO";

    private static final String PREF_KEY_TOPUP_AMOUNT = "PREF_KEY_TOPUP_AMOUNT";

    private static final String PREF_KEY_PAYMENT_METHOD = "PREF_KEY_PAYMENT_METHOD";


    @Inject
    public AppPreferencesHelper(@ApplicationContext Context app, @PreferenceInfo String prefFileName) {
        S.computation().createWorker().schedule(()->{mPrefs =app.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);});
    }

    @Override
    public String getAccountInfo() {
        return mPrefs.getString(PREF_KEY_ACCOUNT_INFO, null);

    }

    @Override
    public void setAccountInfo(String accountInfo) {
        mPrefs.edit().putString(PREF_KEY_ACCOUNT_INFO, accountInfo).apply();
    }

    @Override
    public float getTopUpAmount() {
        return mPrefs.getFloat(PREF_KEY_TOPUP_AMOUNT, 0f);
    }

    @Override
    public void setTopUpAmount(float amount) {
        mPrefs.edit().putFloat(PREF_KEY_TOPUP_AMOUNT, amount).apply();
    }

    @Override
    public int getPaymentMethod() {
        return mPrefs.getInt(PREF_KEY_PAYMENT_METHOD, 0);
    }

    @Override
    public void setPaymentMethod(int method) {
        mPrefs.edit().putInt(PREF_KEY_PAYMENT_METHOD, method).apply();
    }
}
