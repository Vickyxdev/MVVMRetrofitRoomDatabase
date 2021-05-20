package com.vicky.mvvmretofitroomdatabsetest.Repository;

import android.os.AsyncTask;

public class PopulatedBDAsync extends AsyncTask<Void, Void, Void> {

    private final PostInfoDao mDao;

    PopulatedBDAsync(PostInfoRoomDatabase db)
    {
        mDao = db.postInfoDao();
    }
    @Override
    protected Void doInBackground(Void... voids) {

        mDao.deleteAll();
        return null;
    }
}
