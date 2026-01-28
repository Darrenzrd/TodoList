package com.darren.todolist.service;

import com.darren.todolist.entity.Task;
import com.darren.todolist.mapper.TaskMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Service
public class TaskServiceImpl implements TaskService {
    private final TaskMapper taskMapper;

    public TaskServiceImpl(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    //id自增原子操作
    @Override
    public Task addTask(String title, Task.TaskStatus status) {
        if (status == null) status = Task.TaskStatus.Todo;//默认status
        Task task = new Task();
        task.setTitle(title);
        task.setTaskStatus(status);
        task.setCreatetime(LocalDateTime.now());
        taskMapper.insert(task);
        log.info("TaskService添加任务:{},id= {}", task.getClass(), task.getId());
        return task;
    }

    public List<Task> listTasks() {
        log.info("list all tasks");
        return taskMapper.findAll();
    }

    public boolean updateTaskStatus(Long id, Task.TaskStatus status) {
        taskMapper.updateStatus(id, status);
        log.info("update id={} status for {}", id, status);
        return true;
    }

    public boolean deleteTasks(Long id) {
        log.info("delete id = {}", id);
        taskMapper.deleteByid(id);
        return true;
    }
}
