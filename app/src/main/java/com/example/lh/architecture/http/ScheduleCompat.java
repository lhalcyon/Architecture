package com.example.lh.architecture.http;

import rx.Observable;
import rx.Observable.Transformer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by L on 16/6/26.
 */
public class ScheduleCompat {

    private static final Transformer schedulersTransformer =
            observable -> ((Observable)observable).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());

    @SuppressWarnings("unchecked")
    public static <T> Transformer<T, T> applySchedulers() {
        return (Transformer<T, T>) schedulersTransformer;
    }
}
