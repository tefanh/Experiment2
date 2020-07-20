package com.example.experiment2.data.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class Task {
    @NonNull
    @SerializedName("id")
    private Integer id;

    @Nullable
    @SerializedName("title")
    private String title;

    @Nullable
    @SerializedName("description")
    private String description;

    public Task(@NonNull Integer id, @Nullable String title, @Nullable String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    @Nullable
    public String getTitle() {
        return title;
    }

    public void setTitle(@Nullable String title) {
        this.title = title;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(@Nullable String description) {
        this.description = description;
    }

    @NonNull
    @Override
    public String toString() {
        return getTitle();
    }
}
