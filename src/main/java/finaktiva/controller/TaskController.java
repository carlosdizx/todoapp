package finaktiva.controller;

import finaktiva.data.entity.tasktodo.TaskData;
import finaktiva.data.entity.tasktodo.TaskDataMapper;
import finaktiva.domain.tasktodo.Task;
import finaktiva.service.api.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/tasks/")
public class TaskController {

    private final static TaskDataMapper MAPPER = new TaskDataMapper();

    @Autowired
    private TaskService service;

    @PostMapping
    public Task save(@Valid @RequestBody Task task) {
        TaskData data = MAPPER.map(task);
        System.out.println("----------");
        System.out.println(data);
        System.out.println("----------");
        service.save(data);
        return task;
    }
}
