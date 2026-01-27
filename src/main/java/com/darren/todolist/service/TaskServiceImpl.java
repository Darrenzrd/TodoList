package com.darren.todolist.service;

import com.darren.todolist.entity.Task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Service
public class TaskServiceImpl implements TaskService {
    private final List<Task> tasks = new ArrayList<>();
    private final AtomicInteger count = new AtomicInteger(1);

    @Override
    public Task addTask(String title) {
        Task task = new Task();
        task.setId(count.getAndIncrement());
        task.setTaskStatues(Task.TaskStatus.Todo);
        task.setTitle(title);
        tasks.add(task);
        log.info("TaskService添加任务:{},id= {}", task.getClass(),task.getId());
        return task;
    }

    public List<Task> listTasks() {
        log.info("list all tasks");
        return tasks;
    }

    public boolean updateTaskStatus(int id, Task.TaskStatus status) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setTaskStatues(status);
                log.info("update id={} status for {}", id, status);
                return true;
            }
        }
        return false;
    }

    public boolean deleteTasks(int id){
        return tasks.removeIf(task -> task.getId() == id);
    }
}
