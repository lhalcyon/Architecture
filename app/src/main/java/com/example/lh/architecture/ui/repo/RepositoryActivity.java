package com.example.lh.architecture.ui.repo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.lh.architecture.R;
import com.example.lh.architecture.model.Repository;

public class RepositoryActivity extends AppCompatActivity {
    private static final String EXTRA_REPOSITORY = "EXTRA_REPOSITORY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository);
    }
    public static Intent newIntent(Context context, Repository repository) {
        Intent intent = new Intent(context, RepositoryActivity.class);
        intent.putExtra(EXTRA_REPOSITORY, repository);
        return intent;
    }

}
