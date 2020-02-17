package com.example.mobiletopup.ui.confirm;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mobiletopup.base.BaseViewModel;
import com.example.mobiletopup.db.IDataManager;
import com.example.mobiletopup.ui.account.dto.FinancialReport;
import com.example.mobiletopup.ui.confirm.dto.Receipt;
import com.example.mobiletopup.ui.confirm.dto.TopUp;
import com.example.mobiletopup.ui.confirm.dto.TopUpResponse;
import com.example.mobiletopup.ui.confirm.dto.TopUpTypes;
import com.example.mobiletopup.utils.S;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;
import retrofit2.Response;

public class ConfirmPaymentViewModel extends BaseViewModel {
    private MutableLiveData<Receipt> topUpMutableLiveData;
    private Receipt topUp;

    @Inject
    public ConfirmPaymentViewModel(IDataManager dataManager) {
        super(dataManager);
    }

    public float getAmount(){
        return getDataManager().getTopUpAmount();
    }

    public String getTopupType(){
        return TOPUP_TYPE_HASH_MAP.get(getDataManager().getPaymentMethod());
    }

    public static final HashMap<Integer, String> TOPUP_TYPE_HASH_MAP= new HashMap(){
        {put(1,"Deposit in Agent place" );}
        {put(2,"Pick by agent from your place" );}
    };

    public String getAccount(){
        String roomsList = getDataManager().getAccountInfo();
        Type type1 = new TypeToken<FinancialReport>() {
        }.getType();
        FinancialReport detailList = new Gson().fromJson(roomsList, type1);
        return  detailList.getCurrencyName();
    }

    public Integer getCurrencyID(){
        String roomsList = getDataManager().getAccountInfo();
        Type type1 = new TypeToken<FinancialReport>() {
        }.getType();
        FinancialReport detailList = new Gson().fromJson(roomsList, type1);
        return  detailList.getCurrencyID();
    }


    LiveData<Receipt> getInvoice(){
        if(topUpMutableLiveData == null){
            topUpMutableLiveData = new MutableLiveData<>();
        }
        return  topUpMutableLiveData;
    }

    public void sendTopUp(){

        Log.d("EnumTYpe",TopUpTypes.getEnumType(getDataManager().getPaymentMethod()) + "");
        getCompositeDisposable().add(getDataManager().sendTopUp(new TopUp(getCurrencyID(),getAmount(), TopUpTypes.getEnumType(getDataManager().getPaymentMethod()))).subscribeOn(S.io()).observeOn(S.ui()).subscribeWith(new DisposableObserver<Response<TopUpResponse>>() {
            @Override
            public void onNext(Response<TopUpResponse> dataResponse) {
                Log.d("Response:", dataResponse.body().toString()) ;

                Log.d("Response:CurrencyName ", dataResponse.body().getData().getCurrencyName());
                Log.d("Response:InvoiceNo ", dataResponse.body().getData().getInvoiceNo());
                Log.d("Response:AmountFC( ", dataResponse.body().getData().getAmountFC() + "");

                Receipt topUpResponse=new Receipt();
                topUpResponse.setAmountFC(dataResponse.body().getData().getAmountFC() );
                topUpResponse.setCurrencyName(dataResponse.body().getData().getCurrencyName());
                topUpResponse.setInvoiceNo(dataResponse.body().getData().getInvoiceNo());

                topUpMutableLiveData.setValue(topUpResponse);
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

}