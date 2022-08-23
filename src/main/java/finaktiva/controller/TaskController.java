package finaktiva.controller;

import finaktiva.data.entity.tasktodo.TaskData;
import finaktiva.data.entity.tasktodo.TaskDataMapper;
import finaktiva.domain.tasktodo.Task;
import finaktiva.service.api.TaskService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


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
        final TaskData data = MAPPER.map(task);
        service.save(data);
        return task;
    }

    @GetMapping("{id}")
    public Task findById(@PathVariable Long id) {
        final TaskData taskData = service.findByID(id);
        if (taskData != null) {
            return MAPPER.iMap(service.findByID(id));

        }
        return null;
    }

    @PutMapping("{id}")
    public Task update(@PathVariable Long id, @RequestBody Task task) {
        final TaskData taskData = service.findByID(id);
        if (taskData != null) {
            BeanUtils.copyProperties(task, taskData, "id");
            service.save(taskData);
            return MAPPER.iMap(taskData);
        }
        return null;
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        final TaskData taskData = service.findByID(id);
        if (taskData != null)
            service.delete(id);
    }
}
