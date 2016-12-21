package com.example.lh.architecture.di.module;

import com.example.lh.architecture.http.DataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lh_ha on 2016/12/21.
 */
@Module
public class DataSourceModule {

    private final DataSource mDataSource;

    public DataSourceModule(String url) {
        mDataSource = new DataSource(url);
    }

    @Provides
    @Singleton
    DataSource dataSource() {
        return mDataSource;
    }
}
