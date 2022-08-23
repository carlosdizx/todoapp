package finaktiva.service.impl;

import finaktiva.data.entity.tasktodo.TaskData;
import finaktiva.data.entity.tasktodo.TaskDataMapper;
import finaktiva.data.repository.TaskRepository;
import finaktiva.domain.tasktodo.Task;
import finaktiva.service.api.TaskServiceApi;
import finaktiva.util.GenericServiceApiImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl extends GenericServiceApiImpl<TaskData, Long> implements TaskServiceApi {

    private final static TaskDataMapper MAPPER = new TaskDataMapper();
    private final TaskRepository repository;

    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public JpaRepository<TaskData, Long> getDao() {
        return repository;
    }

    public TaskData save(Task entity) {
        return getDao().save(MAPPER.map(entity));
    }
}
