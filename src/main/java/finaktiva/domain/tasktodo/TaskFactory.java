package finaktiva.domain.tasktodo;

import finaktiva.repository.tasktodo.TaskData;

public class TaskFactory {
    public static Task createTask(final TaskData taskData) {
        return Task.builder()
                .id(taskData.getId())
                .title(taskData.getTitle())
                .description(taskData.getDescription())
                .createdDate(taskData.getCreatedDate())
                .eta(taskData.getEta())
                .finished(taskData.isFinished())
                .taskStatus(taskData.getTaskStatus())
                .build();
    }
}
