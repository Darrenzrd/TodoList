package com.darren.todolist.controller;


import com.darren.todolist.dto.Result;
import com.darren.todolist.entity.Task;
import com.darren.todolist.service.TaskService;
import lombok.extern.slf4j.Slf4j;
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
    public Result<Task> addTask(@RequestParam String title,
                                @RequestParam(required = false) Task.TaskStatus status) {
        if (status == null) status = Task.TaskStatus.Todo;
        Task task = taskService.addTask(title, status);
        log.info("TaskController调用");
        return Result.success(task);
    }

    @GetMapping(value = "/list", produces = "application/json")
    public Result<List<Task>> listTask() {
        return Result.success(taskService.listTasks());
    }

    @PostMapping("/update")
    public Result<Void> updateTaskStatus(@RequestParam Long id,
                                         @RequestParam Task.TaskStatus status) {
        boolean ok =taskService.updateTaskStatus(id, status);
        return Result.success(null);
    }

    @PostMapping("/delete")
    public Result<Void> deleteTask(@RequestParam Long id){
        taskService.deleteTasks(id);
        return Result.success(null);
    }
}