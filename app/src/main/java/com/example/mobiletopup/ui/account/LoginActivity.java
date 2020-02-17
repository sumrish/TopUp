package com.example.mobiletopup.ui.account;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mobiletopup.R;
import com.example.mobiletopup.base.BaseActivity;
import com.example.mobiletopup.databinding.ActivityLoginBinding;
import com.example.mobiletopup.ui.amount.AmountActivity;
import com.example.mobiletopup.utils.IOnItemClick;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;

public class LoginActivity  extends BaseActivity<ActivityLoginBinding, LoginViewModel>  implements IOnItemClick {


    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    private LoginViewModel mLoginViewModel;

    @Override
    public int getBindingVariable() {
        return 0;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public LoginViewModel getViewModel() {

        if (viewModelFactory != null) {
            mLoginViewModel = ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel.class);
            return mLoginViewModel;
        }

        return null;
    }

    @Override
    protected void initUi(Bundle savedInstanceState) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mViewDataBinding.user.setLayoutManager(layoutManager);
        mViewDataBinding.user.setAdapter(mLoginViewModel.getUserAdapter());
        mLoginViewModel.getUserAdapter().setInterface(this);

        mLoginViewModel.LoginUser();
    }

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        return intent;
    }


    public void onItemClick(int position) {
        mLoginViewModel.storeAccountInfo(position);
        Intent intent = AmountActivity.newIntent(LoginActivity.this);
        startActivity(intent);
    }

    @Override
    public void onItemClick(int position, float id) {

    }

    @Override
    public void onItemClick(int position, String url) {

    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }
}
