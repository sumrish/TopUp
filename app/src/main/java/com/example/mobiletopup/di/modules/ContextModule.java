package com.example.mobiletopup.di.modules;

import android.content.Context;

import com.example.mobiletopup.app.MobileTopUpApp;
import com.example.mobiletopup.di.qualifiers.ApplicationContext;
import com.example.mobiletopup.di.scopes.ApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {


    @Provides
    @ApplicationContext
    @ApplicationScope
    Context provideContext(MobileTopUpApp application) {
        return application.getApplicationContext();
    }
}
