package com.example.mobiletopup.base;

import androidx.lifecycle.ViewModel;

import com.example.mobiletopup.api.IApis;
import com.example.mobiletopup.db.IDataManager;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseViewModel extends ViewModel {

    private CompositeDisposable mCompositeDisposable;
    private IApis mApiService;
    private final IDataManager mDataManager;

//    public BaseViewModel() {
//        this.mCompositeDisposable = new CompositeDisposable();
//    }


    public BaseViewModel(IDataManager dataManager) {
        this.mCompositeDisposable = new CompositeDisposable();
        mDataManager = dataManager;
    }

    @Override
    protected void onCleared() {
        mCompositeDisposable.dispose();
        super.onCleared();
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }


    public IDataManager getDataManager() {
        return mDataManager;
    }

//    public IApis getApiClient() {
//       return mApiService = ApiClient.getClient().create(IApis.class);
//    }
}
