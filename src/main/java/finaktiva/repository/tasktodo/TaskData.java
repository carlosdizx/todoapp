package finaktiva.repository.tasktodo;

import finaktiva.domain.tasktodo.TaskStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.RequiredArgsConstructor;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import java.time.LocalDateTime;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "tasks")
public class TaskData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdDate;
    private LocalDateTime eta;
    private boolean finished;
    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;
}