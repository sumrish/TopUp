package com.example.mobiletopup.ui.account;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.mobiletopup.base.BaseViewModel;
import com.example.mobiletopup.db.IDataManager;
import com.example.mobiletopup.ui.account.adapter.FinancialReportAdapter;
import com.example.mobiletopup.ui.account.dto.FinancialReport;
import com.example.mobiletopup.ui.account.dto.LoginCredential;
import com.example.mobiletopup.ui.account.dto.Report;
import com.example.mobiletopup.ui.account.dto.UserDetail;
import com.example.mobiletopup.utils.S;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;
import retrofit2.Response;

public class LoginViewModel extends BaseViewModel {


    private static final String TAG = LoginViewModel.class.getSimpleName();
    private MutableLiveData<UserDetail> userMutableLiveData;
    private UserDetail user;
    private FinancialReportAdapter mFinancialReportAdapter;
    List<FinancialReport> mFinancialReportsList;

    public FinancialReportAdapter getUserAdapter() {
        return mFinancialReportAdapter;
    }

    @Inject
    public LoginViewModel(IDataManager dataManager) {
        super(dataManager);
        userMutableLiveData = new MutableLiveData<>();
        user = new UserDetail();
        mFinancialReportAdapter = new FinancialReportAdapter();

    }

    public void LoginUser() {
        getCompositeDisposable().add(getDataManager().doLogin(new LoginCredential("9090", "9090")).
                subscribeOn(S.io()).observeOn(S.ui()).subscribeWith(new DisposableObserver<Response<UserDetail>>() {
            @Override
            public void onNext(Response<UserDetail> dataResponse) {
                Log.d("Response:", dataResponse.body().toString());

                Log.d("Response:getUsername ", dataResponse.body().getData().getUsername());
                Log.d("Response:getFullname ", dataResponse.body().getData().getFullname());
                Log.d("Response:getToken ", dataResponse.body().getData().getToken());
                setDataToken(dataResponse.body().getData().getToken());
                getFinancialReport();
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, e.toString());

            }

            @Override
            public void onComplete() {

            }
        }));

    }

    public void setDataToken(String dataResponse) {
        getDataManager().setToken(dataResponse);
    }

    public void getFinancialReport() {

        getCompositeDisposable().add(getDataManager().getFinancialReport().subscribeOn(S.io()).observeOn(S.ui()).subscribeWith(new DisposableObserver<Response<Report>>() {
            @Override
            public void onNext(Response<Report> dataResponse) {
                Log.d("Response:", dataResponse.body().toString());

                Log.d("Response:CurrencyName ", dataResponse.body().getData().get(0).getCurrencyName());
                Log.d("Response:CloseBalance ", dataResponse.body().getData().get(0).getClosingBalance() + "");
                Log.d("Response:CurrencyID ", dataResponse.body().getData().get(0).getCurrencyID() + "");
                mFinancialReportsList = new ArrayList<>();
                for (int i = 0; i < dataResponse.body().getData().size(); i++) {
                    FinancialReport financialReport = new FinancialReport();
                    financialReport.setCurrencyName(dataResponse.body().getData().get(i).getCurrencyName());
                    financialReport.setClosingBalance(dataResponse.body().getData().get(i).getClosingBalance());
                    financialReport.setCurrencyID(dataResponse.body().getData().get(i).getCurrencyID());
                    mFinancialReportsList.add(financialReport);
                }
                mFinancialReportAdapter.setDataset(mFinancialReportsList);

            }

            @Override
            public void onError(Throwable e) {
                Log.d("UserActivity", e.toString());

            }

            @Override
            public void onComplete() {

            }
        }));

    }

    public void storeAccountInfo(Integer position) {
        Gson gson = new Gson();
        String account = gson.toJson(mFinancialReportsList.get(position));
        getDataManager().setAccountInfo(account);

    }

}
