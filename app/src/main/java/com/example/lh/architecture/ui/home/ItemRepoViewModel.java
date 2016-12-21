package com.example.lh.architecture.ui.home;

import android.content.Context;
import android.view.View;

import com.example.lh.architecture.R;
import com.example.lh.architecture.model.Repository;
import com.example.lh.architecture.ui.base.ViewModel;
import com.example.lh.architecture.ui.repo.RepositoryActivity;


/**
 * View model for each item in the repositories RecyclerView
 */
public class ItemRepoViewModel extends ViewModel {

    private Repository repository;

    public ItemRepoViewModel(Context context, Repository repository) {
        super(context);
        this.repository = repository;
    }

    @Override
    protected void unsubscribe() {

    }

    public String getName() {
        return repository.name;
    }

    public String getDescription() {
        return repository.description;
    }

    public String getStars() {
        return mContext.getString(R.string.text_stars, repository.stars);
    }

    public String getWatchers() {
        return mContext.getString(R.string.text_watchers, repository.watchers);
    }

    public String getForks() {
        return mContext.getString(R.string.text_forks, repository.forks);
    }

    public void onItemClick(View view) {
        mContext.startActivity(RepositoryActivity.newIntent(mContext, repository));
    }

    // Allows recycling ItemRepoViewModels within the recyclerview adapter
    public void setRepository(Repository repository) {
        this.repository = repository;
        notifyChange();
    }

}
