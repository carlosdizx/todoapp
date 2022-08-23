package finaktiva.service.api;

import finaktiva.data.entity.tasktodo.TaskData;
import finaktiva.util.GenericServiceApi;

public interface TaskService extends GenericServiceApi<TaskData, Long> {
    @Override
    TaskData save(TaskData entity);
}
