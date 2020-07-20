package com.example.experiment2.data.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class Job {
    @NonNull
    @SerializedName("id")
    private Integer id;

    @Nullable
    @SerializedName("jobTitle")
    private String jobTitle;

    @Nullable
    @SerializedName("minSalary")
    private Integer minSalary;

    @Nullable
    @SerializedName("maxSalary")
    private String maxSalary;

    @Nullable
    @SerializedName("tasks")
    private Task[] tasks;

    @Nullable
    @SerializedName("employee")
    private Employee employee;

    public Job(@NonNull Integer id, @Nullable String jobTitle, @Nullable Integer minSalary, @Nullable String maxSalary, @Nullable Task[] tasks, @Nullable Employee employee) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.tasks = tasks;
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
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(@Nullable String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Nullable
    public Integer getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(@Nullable Integer minSalary) {
        this.minSalary = minSalary;
    }

    @Nullable
    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(@Nullable String maxSalary) {
        this.maxSalary = maxSalary;
    }

    @Nullable
    public Task[] getTasks() {
        return tasks;
    }

    public void setTasks(@Nullable Task[] tasks) {
        this.tasks = tasks;
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
        return getJobTitle();
    }
}
