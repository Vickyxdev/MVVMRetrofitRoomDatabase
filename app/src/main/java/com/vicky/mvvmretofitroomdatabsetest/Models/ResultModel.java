package com.vicky.mvvmretofitroomdatabsetest.Models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "post_info")
public class ResultModel {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    @SerializedName("id")
    private int id;
    @NonNull
    @ColumnInfo(name = "body")
    @SerializedName("body")
    private String body;

    @NonNull
    @ColumnInfo(name = "title")
    @SerializedName("title")
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getBody() {
        return body;
    }

    public void setBody(@NonNull String body) {
        this.body = body;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    public String toString()
    {
        return "ClassPojo [id = "+id+", body = "+body+", title = "+title+"]";
    }
}
