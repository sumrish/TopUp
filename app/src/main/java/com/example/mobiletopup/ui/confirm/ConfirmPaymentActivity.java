package com.example.mobiletopup.ui.confirm;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.mobiletopup.R;
import com.example.mobiletopup.base.BaseActivity;
import com.example.mobiletopup.databinding.ConfirmPaymentActivityBinding;
import com.example.mobiletopup.ui.confirm.dto.Receipt;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;

public class ConfirmPaymentActivity extends BaseActivity<ConfirmPaymentActivityBinding, ConfirmPaymentViewModel> {


    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    private ConfirmPaymentViewModel mAmountViewModel;

    @Override
    public int getBindingVariable() {
        return 0;
    }

    @Override
    public int getLayoutId() {
        return R.layout.confirm_payment_activity;
    }

    @Override
    public ConfirmPaymentViewModel getViewModel() {

        if (viewModelFactory != null) {
            mAmountViewModel = ViewModelProviders.of(this, viewModelFactory).get(ConfirmPaymentViewModel.class);
            return mAmountViewModel;
        }

        return null;
    }

    public void getReceipt() {
        mAmountViewModel.getInvoice().observe(this, (Receipt receipt) -> {
                    Dialog receiptDialoge = new Dialog(this, android.R.style.Theme_Light_NoTitleBar_Fullscreen);
                    receiptDialoge.setContentView(R.layout.receipt);
                    TextView msg = receiptDialoge.findViewById(R.id.requestAmount);
                    msg.setText("Successfully placed top up request " + receipt.getAmountFC() + " " + receipt.getCurrencyName().split("-")[0]);
                    TextView ID = receiptDialoge.findViewById(R.id.transactionID);
                    ID.setText("Your transaction no.  " + receipt.getInvoiceNo());
                    receiptDialoge.show();
                }
        );
    }

    @Override
    protected void initUi(Bundle savedInstanceState) {
        mViewDataBinding.account.setText(mAmountViewModel.getAccount());
        mViewDataBinding.amount.setText(mAmountViewModel.getAmount() + "");
        mViewDataBinding.type.setText(mAmountViewModel.getTopupType());
        mViewDataBinding.confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAmountViewModel.sendTopUp();
                getReceipt();

            }
        });
    }

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, ConfirmPaymentActivity.class);
        return intent;
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }
}
