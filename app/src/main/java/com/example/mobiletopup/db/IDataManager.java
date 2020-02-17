package com.example.mobiletopup.db;

import com.example.mobiletopup.ui.account.dto.LoginCredential;
import com.example.mobiletopup.ui.account.dto.Report;
import com.example.mobiletopup.ui.account.dto.UserDetail;
import com.example.mobiletopup.ui.confirm.dto.TopUp;
import com.example.mobiletopup.ui.confirm.dto.TopUpResponse;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Body;

public interface IDataManager extends PreferencesHelper {

        void setToken(String token);

        Observable<Response<UserDetail>> doLogin(@Body LoginCredential user);

        Observable<Response<Report>> getFinancialReport();

        Observable<Response<TopUpResponse>> sendTopUp(@Body TopUp topUp);

}
