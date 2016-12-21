package com.example.lh.architecture.di.component;

import android.os.Handler;

import com.example.lh.architecture.App;
import com.example.lh.architecture.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by lh_ha on 2016/12/21.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    App app();
    Handler handler();

}
