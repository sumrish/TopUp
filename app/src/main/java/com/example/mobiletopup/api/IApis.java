package com.example.mobiletopup.api;


import com.example.mobiletopup.ui.account.dto.LoginCredential;
import com.example.mobiletopup.ui.account.dto.Report;
import com.example.mobiletopup.ui.account.dto.UserDetail;
import com.example.mobiletopup.ui.confirm.dto.TopUp;
import com.example.mobiletopup.ui.confirm.dto.TopUpResponse;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IApis {

    @POST("/Talfie_SRV_1_0/api/User/Login")
    Observable<Response<UserDetail>> doLogin(@Body LoginCredential user);

    @GET("/Talfie_SRV_1_0/api/FinancialReporting/GetUserClosingBalances")
    Observable<Response<Report>> getFinancialReport();

    @POST("/Talfie_SRV_1_0/api/TopUp/TopUp")
    Observable<Response<TopUpResponse>> sendTopUp(@Body TopUp topUp);
}
