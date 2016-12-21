package com.example.lh.architecture.http;

import android.content.Context;

/**
 * Created by lh_ha on 2016/12/21.
 */

public interface BaseRepository<R,L> {

    R remote();

    L local(Context context);
}
