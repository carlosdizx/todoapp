package finaktiva.controller;

import finaktiva.data.entity.tasktodo.TaskData;
import finaktiva.data.entity.tasktodo.TaskDataMapper;
import finaktiva.domain.tasktodo.Task;
import finaktiva.service.api.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/tasks/")
public class TaskController {

    private final static TaskDataMapper MAPPER = new TaskDataMapper();

    @Autowired
    private TaskService service;

    @GetMapping
    public List<Task> findAll() {
        final List<Task> tasks = new ArrayList<>();
        service.getAll().forEach(taskData -> tasks.add(MAPPER.iMap(taskData)));
        return tasks;
    }

    @PostMapping
    public Task save(@Valid @RequestBody Task task) {
        TaskData data = MAPPER.map(task);
        service.save(data);
        return task;
    }
}
