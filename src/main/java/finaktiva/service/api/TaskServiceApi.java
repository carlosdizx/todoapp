package finaktiva.service.api;

import finaktiva.data.entity.tasktodo.TaskData;
import finaktiva.util.GenericServiceApi;

import java.util.List;

public interface TaskServiceApi extends GenericServiceApi<TaskData, Long> {

    @Override
    TaskData save(TaskData entity);

    @Override
    void delete(Long id);

    @Override
    TaskData findByID(Long id);

    @Override
    List<TaskData> getAll();
}
