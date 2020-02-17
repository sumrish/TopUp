package com.example.mobiletopup.ui.amount;

import android.util.Log;
import com.example.mobiletopup.base.BaseViewModel;
import com.example.mobiletopup.db.IDataManager;
import com.example.mobiletopup.ui.account.LoginViewModel;
import com.example.mobiletopup.ui.account.adapter.FinancialReportAdapter;
import com.example.mobiletopup.ui.account.dto.FinancialReport;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;

public class AmountViewModel extends BaseViewModel {


    private static final String TAG = LoginViewModel.class.getSimpleName();

    @Inject
    public AmountViewModel(IDataManager dataManager) {
        super(dataManager);

    }

    public FinancialReport fetchAccountInfo() {
        String roomsList = getDataManager().getAccountInfo();
        Type type1 = new TypeToken<FinancialReport>() {
        }.getType();
        FinancialReport detailList = new Gson().fromJson(roomsList, type1);
        return detailList;
    }


    public void setAmount(float amount) {
         getDataManager().setTopUpAmount(amount);
        Log.d("testing :",amount+"");
    }
}