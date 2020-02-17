package com.example.mobiletopup.ui.amount;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mobiletopup.R;
import com.example.mobiletopup.base.BaseActivity;
import com.example.mobiletopup.databinding.ActivityAmountBinding;
import com.example.mobiletopup.databinding.ActivityLoginBinding;
import com.example.mobiletopup.ui.account.LoginActivity;
import com.example.mobiletopup.ui.account.LoginViewModel;
import com.example.mobiletopup.ui.account.dto.FinancialReport;
import com.example.mobiletopup.ui.method.PaymentMethodActivity;
import com.example.mobiletopup.utils.IOnItemClick;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;

public class AmountActivity  extends BaseActivity<ActivityAmountBinding, AmountViewModel> implements View.OnClickListener{


    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    private AmountViewModel mAmountViewModel;

    @Override
    public int getBindingVariable() {
        return 0;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_amount;
    }

    @Override
    public AmountViewModel getViewModel() {

        if (viewModelFactory != null) {
            mAmountViewModel = ViewModelProviders.of(this, viewModelFactory).get(AmountViewModel.class);
            return mAmountViewModel;
        }

        return null;
    }

    @Override
    protected void initUi(Bundle savedInstanceState) {

        mViewDataBinding.amount.setOnClickListener(this);
        mViewDataBinding.amount1.setOnClickListener(this);
        mViewDataBinding.amount2.setOnClickListener(this);
        mViewDataBinding.amount3.setOnClickListener(this);
        mViewDataBinding.amount4.setOnClickListener(this);
        mViewDataBinding.amount5.setOnClickListener(this);
        mViewDataBinding.send.setOnClickListener(this);

        FinancialReport fr=mAmountViewModel.fetchAccountInfo();
        if(fr!=null) {
            mViewDataBinding.currentAmount.setText("Current Balance: " + fr.getClosingBalance());
            mViewDataBinding.currencyType.setText("Currency Name: " + fr.getCurrencyName());
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.amount1:
                mViewDataBinding.amount1.getText();
                mViewDataBinding.amount.setText(mViewDataBinding.amount1.getText());
                break;

            case R.id.amount2:
                mViewDataBinding.amount2.getText();
                mViewDataBinding.amount.setText(mViewDataBinding.amount2.getText());
                break;
            case R.id.amount3:
                mViewDataBinding.amount3.getText();
                mViewDataBinding.amount.setText(mViewDataBinding.amount3.getText());
                break;
            case R.id.amount4:
                mViewDataBinding.amount4.getText();
                mViewDataBinding.amount.setText(mViewDataBinding.amount4.getText());
                break;
            case R.id.amount5:
                mViewDataBinding.amount5.getText();
                mViewDataBinding.amount.setText(mViewDataBinding.amount5.getText());
                break;
            case R.id.send:
                float amount=Float.parseFloat(mViewDataBinding.amount.getText().toString());
                mAmountViewModel.setAmount(amount);
                Intent intent = PaymentMethodActivity.newIntent(AmountActivity.this);
                startActivity(intent);
                break;
        }
        }
    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, AmountActivity.class);
        return intent;
    }
    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }
}
