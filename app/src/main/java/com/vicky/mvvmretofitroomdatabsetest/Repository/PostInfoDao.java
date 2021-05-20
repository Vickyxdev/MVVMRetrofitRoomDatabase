package com.vicky.mvvmretofitroomdatabsetest.Repository;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.vicky.mvvmretofitroomdatabsetest.Models.ResultModel;

import java.util.List;

@Dao
public interface PostInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ResultModel resultModel);

    @Query("SELECT * from post_info ORDER BY id ASC")
    LiveData<List<ResultModel>> getAllPosts();

    @Query("DELETE FROM post_info")
    void deleteAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPosts(List<ResultModel> resultModel);
}
