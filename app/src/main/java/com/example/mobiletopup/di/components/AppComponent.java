package com.example.mobiletopup.di.components;

import com.example.mobiletopup.app.MobileTopUpApp;
import com.example.mobiletopup.di.modules.ActivityModule;
import com.example.mobiletopup.di.modules.AppModule;
import com.example.mobiletopup.di.modules.ContextModule;
import com.example.mobiletopup.di.modules.DatabaseModule;
import com.example.mobiletopup.di.modules.NetworkModule;
import com.example.mobiletopup.di.scopes.ApplicationScope;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@ApplicationScope
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        ActivityModule.class,ContextModule.class, DatabaseModule.class , NetworkModule.class

})
public interface AppComponent {
    @Component.Builder
    interface Builder {

//        @BindsInstance
//        Builder appModule(ContextModule contextModule);


        @BindsInstance
        Builder application(MobileTopUpApp application);

        AppComponent build();

    }
    void inject(MobileTopUpApp loadMonitorApp);

//    Gson getGson();


//    BaseActivity getHomeActivity();



}
