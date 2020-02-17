package com.example.mobiletopup.di.modules;

import com.example.mobiletopup.SplashActivity;
import com.example.mobiletopup.ui.account.LoginActivity;
import com.example.mobiletopup.ui.amount.AmountActivity;
import com.example.mobiletopup.ui.confirm.ConfirmPaymentActivity;
import com.example.mobiletopup.ui.method.PaymentMethodActivity;

import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {


    @ContributesAndroidInjector(modules = {FragmentBuildersModule.class , SplashActivityModule.class})
    @ActivityKey(SplashActivity.class)
    public abstract SplashActivity contributeSplashActivity();

    @ContributesAndroidInjector(modules = {FragmentBuildersModule.class , LoginActivityModule.class})
    @ActivityKey(LoginActivity.class)
    public abstract LoginActivity contributeLoginActivity();

    @ContributesAndroidInjector(modules = {FragmentBuildersModule.class , AmountActivityModule.class})
    @ActivityKey(AmountActivity.class)
    public abstract AmountActivity contributeAmountActivity();

    @ContributesAndroidInjector(modules = {FragmentBuildersModule.class , PaymentMethodActivityModule.class})
    @ActivityKey(PaymentMethodActivity.class)
    public abstract PaymentMethodActivity contributePaymentMethodActivity();

    @ContributesAndroidInjector(modules = {FragmentBuildersModule.class , ConfirmPaymentActivityModule.class})
    @ActivityKey(ConfirmPaymentActivity.class)
    public abstract ConfirmPaymentActivity contributeConfirmPaymentActivity();
}
