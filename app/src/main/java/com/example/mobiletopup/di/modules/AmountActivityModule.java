package com.example.mobiletopup.di.modules;

import com.example.mobiletopup.base.BaseActivity;
import com.example.mobiletopup.ui.account.LoginActivity;
import com.example.mobiletopup.ui.amount.AmountActivity;

import dagger.Module;
import dagger.Provides;
@Module

public class AmountActivityModule {

    @Provides
    static public BaseActivity provideBaseActivity(AmountActivity homeActivity){
        return homeActivity;
    }




}
