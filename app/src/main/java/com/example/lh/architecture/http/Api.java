package com.example.lh.architecture.http;

import com.example.lh.architecture.model.Repository;
import com.example.lh.architecture.model.User;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by lh_ha on 2016/12/21.
 */

public interface Api {

    @GET(Urls.REPO)
    Observable<List<Repository>> publicRepositories(@Path("username") String username);

    @GET
    Observable<User> userFromUrl(@Url String userUrl);
}
