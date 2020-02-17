package com.example.mobiletopup.di.modules;

import android.content.Context;

import com.example.mobiletopup.db.AppDataManager;
import com.example.mobiletopup.db.AppPreferencesHelper;
import com.example.mobiletopup.db.IDataManager;
import com.example.mobiletopup.db.PreferencesHelper;
import com.example.mobiletopup.di.qualifiers.ApplicationContext;
import com.example.mobiletopup.di.qualifiers.PreferenceInfo;
import com.example.mobiletopup.di.scopes.ApplicationScope;
import com.example.mobiletopup.utils.AppConstants;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {

    @Provides
    @ApplicationScope
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @ApplicationScope
    IDataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

}
