package com.example.mobiletopup.di.modules;

import com.example.mobiletopup.SplashActivity;
import com.example.mobiletopup.base.BaseActivity;
import com.example.mobiletopup.ui.method.PaymentMethodActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class PaymentMethodActivityModule {
    @Provides
    static public BaseActivity provideBaseActivity(PaymentMethodActivity homeActivity){
        return homeActivity;
    }
}
