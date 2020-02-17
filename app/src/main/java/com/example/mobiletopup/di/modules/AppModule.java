package com.example.mobiletopup.di.modules;

import com.example.mobiletopup.di.scopes.ApplicationScope;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;


@Module(includes = { ViewModelModule.class })
public class AppModule {

    @ApplicationScope
    @Provides
    Gson provideGson(){
        return new GsonBuilder().create();
    }


}
