package com.example.lh.architecture.ui.base;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by lh_ha on 2016/12/21.
 */

public abstract class BaseActivity<VM extends ViewModel,B extends ViewDataBinding> extends AppCompatActivity {
    private VM mViewModel;
    private B mBinding;
    protected Context mContext;

    public void setViewModel(@NonNull VM viewModel) {
        mViewModel = viewModel;
    }

    public VM getViewModel() {
        if (mViewModel == null) {
            throw new NullPointerException("ViewModel must be set first!");
        }
        return mViewModel;
    }

    public void setBinding(@NonNull B binding) {
        this.mBinding = binding;
    }

    public B getBinding() {
        if (mBinding == null) {
            throw new NullPointerException("Binding must be set first!");
        }
        return mBinding;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        initView(savedInstanceState);
    }

    protected abstract void initView(Bundle savedInstanceState);

    @Override
    protected void onDestroy() {
        mViewModel.unsubscribe();
        super.onDestroy();
    }
}
