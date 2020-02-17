package com.example.mobiletopup.ui.method;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.mobiletopup.R;
import com.example.mobiletopup.base.BaseActivity;
import com.example.mobiletopup.databinding.ActvityPaymentMethodBinding;
import com.example.mobiletopup.ui.confirm.ConfirmPaymentActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;

public class PaymentMethodActivity  extends BaseActivity<ActvityPaymentMethodBinding, PaymentMethodViewModel>  {


    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    private PaymentMethodViewModel mAmountViewModel;

    @Override
    public int getBindingVariable() {
        return 0;
    }

    @Override
    public int getLayoutId() {
        return R.layout.actvity_payment_method;
    }

    @Override
    public PaymentMethodViewModel getViewModel() {

        if (viewModelFactory != null) {
            mAmountViewModel = ViewModelProviders.of(this, viewModelFactory).get(PaymentMethodViewModel.class);
            return mAmountViewModel;
        }

        return null;
    }

    @Override
    protected void initUi(Bundle savedInstanceState) {

        mViewDataBinding.spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
              Log.d("Position: ", position+1+"");
                mAmountViewModel.setPaymentMethod(position+1);

                mViewDataBinding.button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = ConfirmPaymentActivity.newIntent(PaymentMethodActivity.this);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, PaymentMethodActivity.class);
        return intent;
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }
}
