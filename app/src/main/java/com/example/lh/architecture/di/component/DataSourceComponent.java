package com.example.lh.architecture.di.component;

import com.example.lh.architecture.di.module.AppModule;
import com.example.lh.architecture.di.module.DataSourceModule;
import com.example.lh.architecture.http.DataSource;
import com.example.lh.architecture.ui.base.ViewModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by lh_ha on 2016/12/21.
 */

@Singleton
@Component(modules = DataSourceModule.class,dependencies = AppModule.class)
public interface DataSourceComponent {

    DataSource dataSource();

    void inject(ViewModel target);

}
