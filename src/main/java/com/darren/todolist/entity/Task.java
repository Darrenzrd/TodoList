package com.darren.todolist.entity;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Task {

    private Integer id;
    private String title;
    private TaskStatus taskStatus;
    private LocalDateTime createtime;

    public enum TaskStatus {
        Todo,
        Done
    }

    public void setCreatetime(LocalDateTime creattime) {
        this.createtime = creattime;
    }

    public LocalDateTime getCreatetime() {
        return createtime;
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
}
