package com.example.mobiletopup.di.modules;

import com.example.mobiletopup.base.BaseActivity;
import com.example.mobiletopup.ui.confirm.ConfirmPaymentActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class ConfirmPaymentActivityModule {

    @Provides
    static public BaseActivity provideBaseActivity(ConfirmPaymentActivity homeActivity){
        return homeActivity;
    }
}
