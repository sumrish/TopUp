package com.example.mobiletopup.api;

import android.util.Log;

import com.example.mobiletopup.ui.account.dto.LoginCredential;
import com.example.mobiletopup.ui.account.dto.Report;
import com.example.mobiletopup.ui.account.dto.UserDetail;
import com.example.mobiletopup.ui.confirm.dto.TopUp;
import com.example.mobiletopup.ui.confirm.dto.TopUpResponse;

import javax.inject.Inject;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AppApiHelper  implements IApiHelper{

    private static final String TAG = "AppApiHelper";
    private OkHttpClient okHttpClient = null;
    private Retrofit mRetrofit;
    private String accessToken = null;
    public static final String BASE_URL = "http://talfie.selfip.com:70";

    @Inject
    public AppApiHelper(Retrofit retrofit , OkHttpClient okHttpClient) {

        Log.d(TAG, "AppApiHelper() called with: mRetrofit = [" + retrofit + "]");
        this.mRetrofit = retrofit;
        this.okHttpClient = okHttpClient;

        init();

    }

    @Override
    public void setAccessToken(String accessToken) {
        this.accessToken =accessToken;
    }

    @Override
    public String getAccessToken() {
        return accessToken ;
    }

    private void init() {

        /*OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest  = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer " + "eyJhbGciOiJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNobWFjLXNoYTI1NiIsInR5cCI6IkpXVCJ9.eyJVc2VybmFtZSI6IjkwOTAiLCJVc2VyR1VJRCI6IjBGN0ZGNjA3LTY0MTktNEZENS05NUI3LTc2OTI1MzJDNUI1MiIsIkN1c3RvbWVyR1VJRCI6IkVENzE4MzBGLTY1NDItNEZGRi04MzAwLTVFODc1MjMxOTc4NyIsIm5iZiI6MTU4MTY2MDYzMCwiZXhwIjoxNTgxNjg5NDMwLCJpc3MiOiJUYWxmaWUiLCJhdWQiOiJodHRwczovL3RhbGZpZS5jb20ifQ.G193-5srXMWRvATzKhyLN4Iuyln6gfbCFPpfEiUPng8")
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();*/

        if (mRetrofit==null) {
          /*  mRetrofit = new Retrofit.Builder()
                    .client(okHttpClient*//*client*//*)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();*/
        }
    }

    @Override
    public Observable<Response<UserDetail>> doLogin(LoginCredential user) {
        IApis observable = mRetrofit.create(IApis.class);
        return observable.doLogin(user);
    }

    @Override
    public Observable<Response<Report>> getFinancialReport() {
        IApis observable = mRetrofit.create(IApis.class);
        return observable.getFinancialReport();    }

    @Override
    public Observable<Response<TopUpResponse>> sendTopUp(TopUp topUp) {
        IApis observable = mRetrofit.create(IApis.class);
        return observable.sendTopUp(topUp);
    }
}
