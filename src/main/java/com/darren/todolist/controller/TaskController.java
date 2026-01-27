package com.darren.todolist.controller;


import com.darren.todolist.entity.Task;
import com.darren.todolist.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //可以用@RestController代替,下面的@ResponseBody就可以省略了
@Slf4j
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/add")
//    @ResponseBody//如果不写这个,@Controller默认返回视图,需要有.html 页面返回
    public Task addTask(@RequestParam String title) {
        log.info("TaskController");
        return taskService.addTask(title);
    }

    @GetMapping("/list")
    public List<Task> listTask() {
        return taskService.listTasks();
    }

    @PostMapping("/update")
    public boolean updateTaskStatus(@RequestParam int id, @RequestParam Task.TaskStatus status) {
        return taskService.updateTaskStatus(id, status);
    }

    @PostMapping("/delete")
    public boolean deleteTask(@RequestParam int id){
        return taskService.deleteTasks(id);
    }
}