package finaktiva.domain.person;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;


@Data
@Builder
public class Person {
    private final Long id;
    @NotBlank(message = "El campo names no puede estar vacio")
    private final String names;
    private final LocalDate created_at;
}
