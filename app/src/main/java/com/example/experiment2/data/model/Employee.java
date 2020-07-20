package com.example.experiment2.data.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.time.ZonedDateTime;

public class Employee {
    @NonNull
    @SerializedName("id")
    private Integer id;

    @Nullable
    @SerializedName("firstName")
    private String firstName;

    @Nullable
    @SerializedName("lastName")
    private String lastName;

    @Nullable
    @SerializedName("email")
    private String email;

    @Nullable
    @SerializedName("phoneNumber")
    private String phoneNumber;

    @Nullable
    @SerializedName("hireDate")
    private ZonedDateTime hireDate;

    @Nullable
    @SerializedName("salary")
    private Integer salary;

    @Nullable
    @SerializedName("comissionPct")
    private Integer comissionPct;

    @Nullable
    @SerializedName("jobs")
    private Job[] jobs;

    @Nullable
    @SerializedName("manager")
    private Employee manager;

    @Nullable
    @SerializedName("department")
    private Department department;

    public Employee(@NonNull Integer id, @Nullable String firstName, @Nullable String lastName, @Nullable String email, @Nullable String phoneNumber, @Nullable ZonedDateTime hireDate, @Nullable Integer salary, @Nullable Integer comissionPct, @Nullable Job[] jobs, @Nullable Employee manager, @Nullable Department department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.salary = salary;
        this.comissionPct = comissionPct;
        this.jobs = jobs;
        this.manager = manager;
        this.department = department;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    @Nullable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(@Nullable String firstName) {
        this.firstName = firstName;
    }

    @Nullable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(@Nullable String lastName) {
        this.lastName = lastName;
    }

    @Nullable
    public String getEmail() {
        return email;
    }

    public void setEmail(@Nullable String email) {
        this.email = email;
    }

    @Nullable
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@Nullable String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Nullable
    public ZonedDateTime getHireDate() {
        return hireDate;
    }

    public void setHireDate(@Nullable ZonedDateTime hireDate) {
        this.hireDate = hireDate;
    }

    @Nullable
    public Integer getSalary() {
        return salary;
    }

    public void setSalary(@Nullable Integer salary) {
        this.salary = salary;
    }

    @Nullable
    public Integer getComissionPct() {
        return comissionPct;
    }

    public void setComissionPct(@Nullable Integer comissionPct) {
        this.comissionPct = comissionPct;
    }

    @Nullable
    public Job[] getJobs() {
        return jobs;
    }

    public void setJobs(@Nullable Job[] jobs) {
        this.jobs = jobs;
    }

    @Nullable
    public Employee getManager() {
        return manager;
    }

    public void setManager(@Nullable Employee manager) {
        this.manager = manager;
    }

    @Nullable
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(@Nullable Department department) {
        this.department = department;
    }

    @NonNull
    @Override
    public String toString() {
        return getFirstName() + " " + getLastName();
    }
}
