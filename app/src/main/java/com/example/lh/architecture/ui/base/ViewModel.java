package com.example.lh.architecture.ui.base;

import android.content.Context;
import android.databinding.BaseObservable;

import com.example.lh.architecture.App;
import com.example.lh.architecture.http.DataSource;

import javax.inject.Inject;

/**
 * Created by lh_ha on 2016/12/21.
 */

public abstract class ViewModel extends BaseObservable {

    protected Context mContext;

    @Inject
    protected DataSource mDataSource;

    public ViewModel(Context context) {
        mContext = context;
        App.getApp().getDataSourceComponent().inject(this);
    }

    protected abstract void unsubscribe();
}
