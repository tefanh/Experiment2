package com.example.experiment2.data.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class Department {
    @NonNull
    @SerializedName("id")
    private Integer id;

    @Nullable
    @SerializedName("departmentName")
    private String departmentName;

    @Nullable
    @SerializedName("location")
    private Location location;

    @Nullable
    @SerializedName("employees")
    private Employee[] employees;

    public Department(@NonNull Integer id, @Nullable String departmentName, @Nullable Location location, @Nullable Employee[] employees) {
        this.id = id;
        this.departmentName = departmentName;
        this.location = location;
        this.employees = employees;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    @Nullable
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(@Nullable String departmentName) {
        this.departmentName = departmentName;
    }

    @Nullable
    public Location getLocation() {
        return location;
    }

    public void setLocation(@Nullable Location location) {
        this.location = location;
    }

    @Nullable
    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(@Nullable Employee[] employees) {
        this.employees = employees;
    }

    @NonNull
    @Override
    public String toString() {
        return getDepartmentName();
    }
}
