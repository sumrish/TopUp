package com.example.mobiletopup.ui.method;

import com.example.mobiletopup.base.BaseViewModel;
import com.example.mobiletopup.db.IDataManager;

import javax.inject.Inject;

public class PaymentMethodViewModel  extends BaseViewModel {


    @Inject
    public PaymentMethodViewModel(IDataManager dataManager) {
        super(dataManager);
    }

    public void setPaymentMethod(int method) {
        getDataManager().setPaymentMethod(method);
    }
}
