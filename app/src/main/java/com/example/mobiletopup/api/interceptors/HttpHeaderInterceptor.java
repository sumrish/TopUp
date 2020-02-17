package com.example.mobiletopup.api.interceptors;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

public interface HttpHeaderInterceptor extends Interceptor {
    @Override
    Response intercept(Chain chain) throws IOException;
}
