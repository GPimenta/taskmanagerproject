package com.taskmanager.taskmanagerproject.model;

import java.util.List;

public class TaskListDetails {
    private List<Task> data;
    private long total;
    private String next;

    public TaskListDetails(List<Task> data, long total, String next) {
        this.data = data;
        this.total = total;
        this.next = next;
    }

    public List<Task> getData() {
        return data;
    }

    public void setData(List<Task> data) {
        this.data = data;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
}
