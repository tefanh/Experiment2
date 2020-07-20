package com.example.experiment2.data.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class Location {
    @NonNull
    @SerializedName("id")
    private Integer id;

    @Nullable
    @SerializedName("postalCode")
    private String postalCode;

    @Nullable
    @SerializedName("city")
    private String city;

    @Nullable
    @SerializedName("stateProvince")
    private String stateProvince;

    @Nullable
    @SerializedName("country")
    private Country country;

    public Location(@NonNull Integer id, @Nullable String postalCode, @Nullable String city, @Nullable String stateProvince, @Nullable Country country) {
        this.id = id;
        this.postalCode = postalCode;
        this.city = city;
        this.stateProvince = stateProvince;
        this.country = country;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    @Nullable
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(@Nullable String postalCode) {
        this.postalCode = postalCode;
    }

    @Nullable
    public String getCity() {
        return city;
    }

    public void setCity(@Nullable String city) {
        this.city = city;
    }

    @Nullable
    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(@Nullable String stateProvince) {
        this.stateProvince = stateProvince;
    }

    @Nullable
    public Country getCountry() {
        return country;
    }

    public void setCountry(@Nullable Country country) {
        this.country = country;
    }

    @NonNull
    @Override
    public String toString() {
        return getCity() + ", " + getPostalCode() + ", " + getStateProvince();
    }
}
