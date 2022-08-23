package finaktiva.data.entity.tasktodo;

import finaktiva.domain.tasktodo.Task;
import finaktiva.domain.tasktodo.TaskFactory;
import finaktiva.mapper.IMapper;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;

@Component
public class TaskDataMapper implements IMapper<Task, TaskData> {

    @Override
    public TaskData map(Task in) {
        final TaskData taskData = TaskData.builder().build();
        BeanUtils.copyProperties(taskData, in, "id");
        return taskData;
    }
    @Override
    public Task iMap(TaskData out) {
        return TaskFactory.createTask(out);
    }
}
