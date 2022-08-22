package finaktiva.data.repository;

import finaktiva.data.entity.tasktodo.TaskData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskData, Long> {
}