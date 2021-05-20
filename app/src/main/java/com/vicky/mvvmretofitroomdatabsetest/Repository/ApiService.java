package com.vicky.mvvmretofitroomdatabsetest.Repository;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("posts")
    Call<String> getAllData();
}
