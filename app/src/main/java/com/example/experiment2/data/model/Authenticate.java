package com.example.experiment2.data.model;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class Authenticate {
    @Nullable
    @SerializedName("id_token")
    private String id_token;

    public Authenticate(@Nullable String id_token) {
        this.id_token = id_token;
    }

    public String getId_token() {
        return id_token;
    }

    public void setId_token(String id_token) {
        this.id_token = id_token;
    }
}
