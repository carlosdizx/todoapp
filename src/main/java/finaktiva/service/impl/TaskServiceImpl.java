package finaktiva.service.impl;

import finaktiva.data.entity.tasktodo.TaskData;
import finaktiva.data.repository.TaskRepository;
import finaktiva.util.GenericServiceApiImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl extends GenericServiceApiImpl<TaskData, Long> {

    private final TaskRepository repository;

    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public JpaRepository<TaskData, Long> getDao() {
        return repository;
    }
}
