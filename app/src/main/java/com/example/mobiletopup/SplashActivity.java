package com.example.mobiletopup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.mobiletopup.base.BaseActivity;
import com.example.mobiletopup.databinding.ActivitySplashBinding;
import com.example.mobiletopup.ui.account.LoginActivity;
import com.example.mobiletopup.ui.splash.SplashViewModel;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;

public class SplashActivity extends BaseActivity<ActivitySplashBinding, SplashViewModel> implements View.OnClickListener {
    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

//@Inject
//public SplashActivity(){}

    @Override
    public int getBindingVariable() {
        return 0;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public SplashViewModel getViewModel() {

        if (viewModelFactory != null) {
            SplashViewModel splashViewModel = ViewModelProviders.of(this, viewModelFactory).get(SplashViewModel.class);
            return splashViewModel;
        }

        return null;

    }

    @Override
    protected void initUi(Bundle savedInstances) {
        Intent intent = LoginActivity.newIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }

    @Override
    public void onClick(View view) {
    }
}

