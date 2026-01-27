package com.darren.todolist.entity;

public class Task {

    private Integer id;
    private String title;
    private TaskStatus taskStatus;

    public enum TaskStatus {
        Todo,
        Done
    }

    //实体类的无参构造
    public Task() {
    }

    //实体类的全参构造
    public Task(Integer id, String title, TaskStatus taskStatus) {
        this.id = id;
        this.title = title;
        this.taskStatus = taskStatus;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatues(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


}
