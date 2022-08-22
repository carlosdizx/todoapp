package finaktiva.service.api;

import finaktiva.data.entity.tasktodo.Task;
import finaktiva.util.GenericServiceApi;

import java.util.List;

public interface TaskServiceApi extends GenericServiceApi<Task, Long> {

    @Override
    Task save(Task entity);

    @Override
    void delete(Long id);

    @Override
    Task findByID(Long id);

    @Override
    List<Task> getAll();
}
