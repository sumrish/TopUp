package com.example.mobiletopup.ui.splash;

import com.example.mobiletopup.base.BaseViewModel;
import com.example.mobiletopup.db.IDataManager;

import javax.inject.Inject;

public class SplashViewModel extends BaseViewModel {


    @Inject
    public SplashViewModel(IDataManager dataManager) {
        super(dataManager);
    }

}