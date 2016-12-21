package com.example.lh.architecture.di.module;

import android.os.Handler;

import com.example.lh.architecture.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lh_ha on 2016/12/21.
 */
@Module
public class AppModule {

    private final App mApp;
    private final Handler mHandler;

    public AppModule(App app) {
        mApp = app;
        mHandler = new Handler();
    }

    @Provides
    @Singleton
    App provideApp() {
        return mApp;
    }

    @Provides
    @Singleton
    Handler provideHandler() {
        return mHandler;
    }
}
