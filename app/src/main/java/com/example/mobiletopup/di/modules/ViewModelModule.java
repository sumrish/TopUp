package com.example.mobiletopup.di.modules;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.mobiletopup.di.qualifiers.ViewModelKey;
import com.example.mobiletopup.ui.account.LoginViewModel;
import com.example.mobiletopup.ui.amount.AmountViewModel;
import com.example.mobiletopup.ui.confirm.ConfirmPaymentViewModel;
import com.example.mobiletopup.ui.method.PaymentMethodActivity;
import com.example.mobiletopup.ui.method.PaymentMethodViewModel;
import com.example.mobiletopup.ui.splash.SplashViewModel;
import com.example.mobiletopup.viewModel.MobileTopUpModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(MobileTopUpModelFactory factory);

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel.class)
    abstract ViewModel bindSplashViewModel(SplashViewModel repoViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel.class)
    abstract ViewModel bindLoginViewModel(LoginViewModel repoViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(AmountViewModel.class)
    abstract ViewModel bindAmountViewModel(AmountViewModel repoViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(PaymentMethodViewModel.class)
    abstract ViewModel bindPaymentMethodViewModel(PaymentMethodViewModel repoViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ConfirmPaymentViewModel.class)
    abstract ViewModel bindConfirmPaymentViewModel(ConfirmPaymentViewModel repoViewModel);
}
