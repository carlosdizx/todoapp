package finaktiva.domain.tasktodo;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Task {
    private final Long id;
    private final String title;
    private final String description;
    private final LocalDateTime createdDate;
    private final LocalDateTime eta;
    private final boolean finished;
    private final TaskStatus taskStatus;
}
