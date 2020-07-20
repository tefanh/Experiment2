package com.example.experiment2.data.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class Country {
    @NonNull
    @SerializedName("id")
    private Integer id;

    @Nullable
    @SerializedName("countryName")
    private String countryName;

    @Nullable
    @SerializedName("region")
    private Region region;


    public Country(@NonNull Integer id, @Nullable String countryName, @Nullable Region region) {
        this.id = id;
        this.countryName = countryName;
        this.region = region;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    @Nullable
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(@Nullable String countryName) {
        this.countryName = countryName;
    }

    @Nullable
    public Region getRegion() {
        return region;
    }

    public void setRegion(@Nullable Region region) {
        this.region = region;
    }

    @NonNull
    @Override
    public String toString() {
        return getCountryName();
    }
}
