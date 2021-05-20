package com.vicky.mvvmretofitroomdatabsetest.Repository;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.vicky.mvvmretofitroomdatabsetest.Models.ResultModel;

@Database(entities = {ResultModel.class}, version = 1)
public abstract class PostInfoRoomDatabase extends RoomDatabase {

    public abstract PostInfoDao postInfoDao();
    private static PostInfoRoomDatabase INSTANCE;

    static PostInfoRoomDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (PostInfoRoomDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                PostInfoRoomDatabase.class, "postoinfo_database")
                                .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static Callback sRoomDatabaseCallback = new Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulatedBDAsync(INSTANCE).execute();
        }
    };
}
