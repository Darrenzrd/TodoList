package com.darren.todolist.service;
import com.darren.todolist.entity.Task;

import java.util.List;

public interface TaskService {
    Task addTask(String title);
    List<Task> listTasks();
    boolean deleteTasks(int id);
    boolean updateTaskStatus(int id, Task.TaskStatus status);

}
