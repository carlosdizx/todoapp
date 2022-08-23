package finaktiva.repository.tasktodo;

import finaktiva.repository.tasktodo.TaskData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskData, Long> {
}