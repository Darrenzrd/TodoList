package com.darren.todolist.service;
import com.darren.todolist.entity.Task;

import java.util.List;

public interface TaskService {

    //id自增原子操作
    Task addTask(String title, Task.TaskStatus status);

    List<Task> listTasks();
    boolean deleteTasks(Long id);
    boolean updateTaskStatus(Long id, Task.TaskStatus status);

}
