package finaktiva.data.repository;

import finaktiva.data.entity.tasktodo.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}