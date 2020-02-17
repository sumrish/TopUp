package com.example.mobiletopup.di.modules;

import com.example.mobiletopup.base.BaseActivity;
import com.example.mobiletopup.ui.account.LoginActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginActivityModule {

    @Provides
    static public BaseActivity provideBaseActivity(LoginActivity homeActivity){
        return homeActivity;
    }




}
