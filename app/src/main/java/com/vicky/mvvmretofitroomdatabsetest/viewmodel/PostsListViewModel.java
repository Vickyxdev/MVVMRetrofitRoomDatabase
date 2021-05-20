package com.vicky.mvvmretofitroomdatabsetest.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.vicky.mvvmretofitroomdatabsetest.Models.ResultModel;
import com.vicky.mvvmretofitroomdatabsetest.Repository.PostRoomDBRepository;
import com.vicky.mvvmretofitroomdatabsetest.Repository.WebServiceRepository;

import java.util.List;

public class PostsListViewModel extends AndroidViewModel {

    private PostRoomDBRepository postRoomDBRepository;
    private LiveData<List<ResultModel>> mAllPosts;

    WebServiceRepository webServiceRepository;


    private final LiveData<List<ResultModel>> retroObservable;

    public PostsListViewModel(@NonNull Application application) {
        super(application);

        postRoomDBRepository = new PostRoomDBRepository(application);
        webServiceRepository = new WebServiceRepository(application);

        retroObservable  = webServiceRepository.providesWebService();
        mAllPosts = postRoomDBRepository.getAllPosts();
    }

    public LiveData<List<ResultModel>> getAllPosts()
    {
        return  mAllPosts;
    }
}
