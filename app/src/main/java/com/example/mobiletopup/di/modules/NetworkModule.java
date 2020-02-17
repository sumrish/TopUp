package com.example.mobiletopup.di.modules;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import com.example.mobiletopup.api.AppApiHelper;
import com.example.mobiletopup.api.IApiHelper;
import com.example.mobiletopup.api.interceptors.HttpHeaderInterceptor;
import com.example.mobiletopup.di.qualifiers.ApplicationContext;
import com.example.mobiletopup.di.scopes.ApplicationScope;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Dispatcher;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.mobiletopup.utils.AppConstants.IP_URL_HTTPS;

@Module(includes = ContextModule.class)
public class NetworkModule {

    private static final String API = IP_URL_HTTPS;
    private AppApiHelper apiImpl;
    private static final int CACHE_SIZE_MB = 10;


    @ApplicationScope
    @Provides
    public Cache providecache(File cacheFile) {
        return new Cache(cacheFile, CACHE_SIZE_MB * 1000 * 1000); //10MB Cahe
    }


    @ApplicationScope
    @Provides
    public File providecacheFile(@ApplicationContext Context context) {
        return new File(context.getCacheDir(), "okhttp_cache");
    }


    @ApplicationScope
    @Provides
    public OkHttpClient okHttpClient(HttpLoggingInterceptor loggingInterceptor, Cache cache, HttpHeaderInterceptor interceptor, @ApplicationContext Context mContext) {

        boolean isDebugOn = false;

        try {
            isDebugOn = (mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0).applicationInfo.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();


        }


        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequests(10);
        dispatcher.setMaxRequestsPerHost(10);


        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        if (isDebugOn) {
            builder.addInterceptor(loggingInterceptor);
        }


        OkHttpClient httpClient = builder.dispatcher(dispatcher)
                .addInterceptor(interceptor)
                .
                        hostnameVerifier(new HostnameVerifier() {
                            @Override
                            public boolean verify(String s, SSLSession sslSession) {
                                return true;
                            }
                        })
                .connectTimeout(180, TimeUnit.SECONDS)
                .readTimeout(180, TimeUnit.SECONDS)
                .cache(cache)
                .build();
        return httpClient;
    }


    @ApplicationScope
    @Provides
    HttpHeaderInterceptor proviveHeaderInterceptor() {
        HttpHeaderInterceptor interceptor = new HttpHeaderInterceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                if (apiImpl.getAccessToken() != null) {
                    Request orignal = chain.request();
                    Request.Builder requestBuilder = orignal.newBuilder()
//                            .header("Authorization", apiImpl.getAccessToken());
                            .header("Authorization", "Bearer " + apiImpl.getAccessToken());


                    return chain.proceed(requestBuilder.build());
                }
                return chain.proceed(chain.request());

            }
        };

        return interceptor;
    }

    @Provides
    @ApplicationScope
    public HttpLoggingInterceptor provideloggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    @ApplicationScope
    @Provides
    public Retrofit retrofit(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .baseUrl(API)
                .build();

        return retrofit;
    }


    @Provides
    @ApplicationScope
    IApiHelper provideApis(AppApiHelper apiImpl) {
        if (this.apiImpl == null) {
            this.apiImpl = apiImpl;
        }
        return this.apiImpl;
    }




}
