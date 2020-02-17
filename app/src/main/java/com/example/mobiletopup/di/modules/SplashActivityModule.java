package com.example.mobiletopup.di.modules;

import com.example.mobiletopup.SplashActivity;
import com.example.mobiletopup.base.BaseActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class SplashActivityModule {

    @Provides
    static public BaseActivity provideBaseActivity(SplashActivity homeActivity){
        return homeActivity;
    }




}
