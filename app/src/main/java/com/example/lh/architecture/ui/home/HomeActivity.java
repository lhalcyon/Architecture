package com.example.lh.architecture.ui.home;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.inputmethod.InputMethodManager;

import com.example.lh.architecture.R;
import com.example.lh.architecture.databinding.ActivityHomeBinding;
import com.example.lh.architecture.model.Repository;
import com.example.lh.architecture.ui.adapter.RepositoryAdapter;
import com.example.lh.architecture.ui.base.BaseActivity;
import com.example.lh.architecture.ui.home.HomeViewModel.DataListener;

import java.util.List;

public class HomeActivity extends BaseActivity<HomeViewModel,ActivityHomeBinding> implements DataListener {

    @Override
    protected void initView(Bundle savedInstanceState) {
        setViewModel(new HomeViewModel(mContext,this));
        setBinding(DataBindingUtil.setContentView(this, R.layout.activity_home));
        getBinding().setViewModel(getViewModel());
        setupRecyclerView(getBinding().reposRecyclerView);
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        RepositoryAdapter adapter = new RepositoryAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onRepositoriesChanged(List<Repository> repositories) {
        RepositoryAdapter adapter =
                (RepositoryAdapter) getBinding().reposRecyclerView.getAdapter();
        adapter.setRepositories(repositories);
        adapter.notifyDataSetChanged();
        hideSoftKeyboard();


    }

    private void hideSoftKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getBinding().editTextUsername.getWindowToken(), 0);
    }
}
