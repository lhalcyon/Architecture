package com.example.lh.architecture.ui.repo;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.example.lh.architecture.R;
import com.example.lh.architecture.databinding.ActivityRepositoryBinding;
import com.example.lh.architecture.model.Repository;
import com.example.lh.architecture.ui.base.BaseActivity;

public class RepositoryActivity extends BaseActivity<RepositoryViewModel,ActivityRepositoryBinding> {
    private static final String EXTRA_REPOSITORY = "EXTRA_REPOSITORY";

    @Override
    protected void initView(Bundle savedInstanceState) {
        Repository repository = getIntent().getParcelableExtra(EXTRA_REPOSITORY);
        RepositoryViewModel viewModel = new RepositoryViewModel(this, repository);
        setViewModel(viewModel);
        setBinding(DataBindingUtil.setContentView(this, R.layout.activity_repository));
        getBinding().setViewModel(getViewModel());
    }

    public static Intent newIntent(Context context, Repository repository) {
        Intent intent = new Intent(context, RepositoryActivity.class);
        intent.putExtra(EXTRA_REPOSITORY, repository);
        return intent;
    }



}
