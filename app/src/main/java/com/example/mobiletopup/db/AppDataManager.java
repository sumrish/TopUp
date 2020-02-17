package com.example.mobiletopup.db;

import android.util.Log;

import com.example.mobiletopup.api.IApiHelper;
import com.example.mobiletopup.ui.account.dto.LoginCredential;
import com.example.mobiletopup.ui.account.dto.Report;
import com.example.mobiletopup.ui.account.dto.UserDetail;
import com.example.mobiletopup.ui.confirm.dto.TopUp;
import com.example.mobiletopup.ui.confirm.dto.TopUpResponse;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Response;

public class AppDataManager implements IDataManager {

    @Inject
    IApiHelper mIApiHelper;

    private final PreferencesHelper mPreferencesHelper;

    private static final  String TAG="AppDataManager";

//    private final AppApiHelper mApiHelper;

    @Inject
    public AppDataManager( PreferencesHelper preferencesHelper ) {
        mPreferencesHelper = preferencesHelper;
//        mApiHelper = apiHelper;
    }

    @Override
    public Observable<Response<UserDetail>> doLogin(LoginCredential user) {
        Log.d(TAG, "Log In method called ");
        return mIApiHelper.doLogin(user);
    }

    @Override
    public Observable<Response<Report>> getFinancialReport() {
        Log.d(TAG, "FinancialReport method called ");
        return mIApiHelper.getFinancialReport();    }

    @Override
    public Observable<Response<TopUpResponse>> sendTopUp(TopUp topUp) {
        Log.d(TAG, "TopUp method called ");
        return mIApiHelper.sendTopUp(topUp);    }

    @Override
    public void setToken(String token) {
        Log.d(TAG, "setToken method called ");
        mIApiHelper.setAccessToken(token);
    }

    @Override
    public String getAccountInfo() {
        return mPreferencesHelper.getAccountInfo();    }

    @Override
    public void setAccountInfo(String accountInfo) {
        mPreferencesHelper.setAccountInfo(accountInfo);
    }

    @Override
    public float getTopUpAmount() {
        return mPreferencesHelper.getTopUpAmount();
    }

    @Override
    public void setTopUpAmount(float amount) {
        mPreferencesHelper.setTopUpAmount(amount);
    }

    @Override
    public int getPaymentMethod() {
        return mPreferencesHelper.getPaymentMethod();
    }

    @Override
    public void setPaymentMethod(int method) {
        mPreferencesHelper.setPaymentMethod(method);
    }
}
