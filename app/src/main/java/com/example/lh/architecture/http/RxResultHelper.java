package com.example.lh.architecture.http;


import rx.Observable;
import rx.Subscriber;

/**
 * Created by L on 16/6/25.
 */
public class RxResultHelper {

   /* public static <T> Observable.Transformer<ApiResponse<T>, T> handleResult() {
        return apiResponseObservable -> apiResponseObservable.flatMap(
                (Func1<ApiResponse<T>, Observable<T>>) tApiResponse -> {
                    if (tApiResponse.isSuccess()) {
                        if(tApiResponse.ret == 4001){
                            return Observable.error(new ServerException(tApiResponse.ret));
                        }else{
                            return createData(tApiResponse.data);
                        }
                    } else {
                        return Observable.error(new ServerException(tApiResponse.ret));
                    }

                }
        );
    }*/


    private static <T> Observable<T> createData(final T t) {
        return Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                try {
                    subscriber.onNext(t);
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }

}
