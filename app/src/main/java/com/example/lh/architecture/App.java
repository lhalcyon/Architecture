package com.example.lh.architecture;

import android.app.Application;

import com.example.lh.architecture.di.component.AppComponent;
import com.example.lh.architecture.di.component.DaggerAppComponent;
import com.example.lh.architecture.di.component.DaggerDataSourceComponent;
import com.example.lh.architecture.di.component.DataSourceComponent;
import com.example.lh.architecture.di.module.AppModule;
import com.example.lh.architecture.di.module.DataSourceModule;
import com.example.lh.architecture.http.Urls;

/**
 * Created by lh_ha on 2016/12/21.
 */

public class App extends Application{
    private static App mApp;
    private AppComponent mAppComponent;
    private DataSourceComponent mDataSourceComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
        initializeInjector(Urls.BASE_URL);
    }

    private void initializeInjector(String baseUrl) {
        AppModule appModule = new AppModule(this);
        mAppComponent =  DaggerAppComponent.builder()
                .appModule(appModule)
                .build();
        mDataSourceComponent = DaggerDataSourceComponent.builder()
                .appModule(appModule)
                .dataSourceModule(new DataSourceModule(baseUrl))
                .build();

    }

    public static App getApp() {
        return mApp;
    }

    public AppComponent getAppComponent(){
        return mAppComponent;
    }

    public DataSourceComponent getDataSourceComponent(){
        return mDataSourceComponent;
    }

}
