package finaktiva.service.impl;

import finaktiva.data.entity.tasktodo.Task;
import finaktiva.data.repository.TaskRepository;
import finaktiva.util.GenericServiceApiImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl extends GenericServiceApiImpl<Task, Long> {

    private final TaskRepository repository;

    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public JpaRepository<Task, Long> getDao() {
        return repository;
    }
}
