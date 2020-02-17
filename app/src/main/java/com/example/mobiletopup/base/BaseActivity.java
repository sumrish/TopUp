package com.example.mobiletopup.base;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import dagger.android.support.HasSupportFragmentInjector;

public abstract class BaseActivity<T extends ViewDataBinding, V extends BaseViewModel> extends AppCompatActivity implements BaseFragment.Callback , HasSupportFragmentInjector {

    private static final String TAG = "BaseActivity";

    protected T mViewDataBinding;
    protected V mViewModel;

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    public abstract int getBindingVariable();

    /**
     * @return layout resource id
     */
    public abstract
    @LayoutRes
    int getLayoutId();

    /**
     * Override for set view model
     *
     * @return view model instance
     */
    public abstract V getViewModel();

    @Override
    public void onFragmentAttached() {
        Log.d(TAG, "onFragmentAttached() called");

    }

    @Override
    public void onFragmentDetached(String tag) {
        Log.d(TAG, "onFragmentDetached() called with: tag = [" + tag + "]");

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        performDataBinding();
        initUi(savedInstanceState);
    }

    protected abstract void initUi(Bundle savedInstanceState);

    public T getViewDataBinding() {
        return mViewDataBinding;
    }

    private void performDataBinding() {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        this.mViewModel = mViewModel == null ? getViewModel() : mViewModel;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
