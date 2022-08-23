package finaktiva.data.entity.person;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.RequiredArgsConstructor;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "persons")
public class PersonData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String names;
    private LocalTime created_at;
}

