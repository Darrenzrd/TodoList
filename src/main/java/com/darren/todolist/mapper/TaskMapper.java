package com.darren.todolist.mapper;

import com.darren.todolist.entity.Task;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TaskMapper {
    @Insert("INSERT INTO task(title, task_status,create_time) VALUES (#{title},#{taskStatus}, #{createtime})")
    void insert(Task task);

    @Select("SELECT * FROM task")
    List<Task> findAll();

    @Update("UPDATE task SET task_status = #{status} WHERE id = #{id}")
    void updateStatus(@Param("id") Long id, @Param("status") Task.TaskStatus status);

    @Delete("DELETE FROM task WHERE id = #{id}")
    void deleteByid(@Param("id") Long id);

}
