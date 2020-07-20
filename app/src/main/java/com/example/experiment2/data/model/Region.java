package com.example.experiment2.data.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class Region {
    @NonNull
    @SerializedName("id")
    private Integer id;

    @Nullable
    @SerializedName("regionName")
    private String regionName;

    public Region(@NonNull Integer id, @Nullable String regionName) {
        this.id = id;
        this.regionName = regionName;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    @Nullable
    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(@Nullable String regionName) {
        this.regionName = regionName;
    }

    @NonNull
    @Override
    public String toString() {
        return getRegionName();
    }
}
