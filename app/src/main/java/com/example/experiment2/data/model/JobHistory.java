package com.example.experiment2.data.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.time.ZonedDateTime;

public class JobHistory {
    @NonNull
    @SerializedName("id")
    private Integer id;

    @Nullable
    @SerializedName("startDate")
    private ZonedDateTime startDate;

    @Nullable
    @SerializedName("endDate")
    private ZonedDateTime endDate;

    @Nullable
    @SerializedName("language")
    private Language language;

    @Nullable
    @SerializedName("job")
    private Job job;

    @Nullable
    @SerializedName("department")
    private Department department;

    @Nullable
    @SerializedName("employee")
    private Employee employee;

    public JobHistory(@NonNull Integer id, @Nullable ZonedDateTime startDate, @Nullable ZonedDateTime endDate, @Nullable Language language, @Nullable Job job, @Nullable Department department, @Nullable Employee employee) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.language = language;
        this.job = job;
        this.department = department;
        this.employee = employee;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    @Nullable
    public ZonedDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(@Nullable ZonedDateTime startDate) {
        this.startDate = startDate;
    }

    @Nullable
    public ZonedDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(@Nullable ZonedDateTime endDate) {
        this.endDate = endDate;
    }

    @Nullable
    public Language getLanguage() {
        return language;
    }

    public void setLanguage(@Nullable Language language) {
        this.language = language;
    }

    @Nullable
    public Job getJob() {
        return job;
    }

    public void setJob(@Nullable Job job) {
        this.job = job;
    }

    @Nullable
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(@Nullable Department department) {
        this.department = department;
    }

    @Nullable
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(@Nullable Employee employee) {
        this.employee = employee;
    }

    @NonNull
    @Override
    public String toString() {
        return getId().toString();
    }
}
