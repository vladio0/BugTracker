package com.example.bugtracker.model;

import jakarta.persistence.*;


import java.time.LocalDate;

@Entity
@Table(name = "bug_tracker_item")
public class BugTrackerItem {

    @Id
    @GeneratedValue

    @Column(name = "bug_id")
    private Long id;

    @Column(name = "bug_title")
    private String title;

    @Column(name = "bug_date")
    private LocalDate date;

    @Column(name = "bug_dev_name")
    private String devName;

    @Column(name = "bug_status")
    private String status; // open, in progress, fixed, closed

    @Column(name = "bug_priority")
    private String priority; // low, medium, high, critical

    @Column(name = "bug_category")
    private String category; // ui, frontend, backend, security

    public BugTrackerItem() {
    }

    public BugTrackerItem(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
