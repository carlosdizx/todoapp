package finaktiva.domain.person;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalTime;


@Data
@Builder
public class Person {
    private final Long id;
    @NotBlank(message = "El campo names no puede estar vacio")
    private final String names;
    private final LocalTime created_at;
}
