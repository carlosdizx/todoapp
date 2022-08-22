package finaktiva.domain.tasktodo;

import finaktiva.domain.tasktodo.TaskStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Task {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdDate;
    private LocalDateTime eta;
    private boolean finished;
    private TaskStatus taskStatus;
}
