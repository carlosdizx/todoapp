package finaktiva.service.impl;

import finaktiva.repository.tasktodo.TaskData;
import finaktiva.repository.tasktodo.TaskRepository;
import finaktiva.service.api.TaskService;
import finaktiva.util.GenericServiceApiImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl extends GenericServiceApiImpl<TaskData, Long> implements TaskService {
    private final TaskRepository repository;

    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public JpaRepository<TaskData, Long> getDao() {
        return repository;
    }
}
