package com.vicky.mvvmretofitroomdatabsetest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.vicky.mvvmretofitroomdatabsetest.Adapter.RetroPostListAdapter;
import com.vicky.mvvmretofitroomdatabsetest.Models.ResultModel;
import com.vicky.mvvmretofitroomdatabsetest.viewmodel.PostsListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    PostsListViewModel retroViewModel;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retroViewModel = ViewModelProviders.of(MainActivity.this).get(PostsListViewModel.class);

        initViews();
        setAdapter();

        progressDialog = ProgressDialog.show(MainActivity.this, "Loading...", "Please wait...", true);
        retroViewModel.getAllPosts().observe(this, new Observer<List<ResultModel>>() {
            @Override
            public void onChanged(List<ResultModel> resultModels) {
                adapter.setWords(resultModels);
                if (progressDialog != null && progressDialog.isShowing())
                {
                    progressDialog.dismiss();
                }
            }
        });
    }

    RecyclerView recyclerView;
    private void initViews(){
        recyclerView = findViewById(R.id.recyclerview);
    }

    RetroPostListAdapter adapter = null;

    private void setAdapter(){
        adapter = new RetroPostListAdapter(MainActivity.this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}