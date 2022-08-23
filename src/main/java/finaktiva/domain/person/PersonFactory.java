package finaktiva.domain.person;

import finaktiva.repository.person.PersonData;

public class PersonFactory {
    public static Person createPerson(final PersonData personData) {
        return Person.builder()
                .id(personData.getId())
                .names(personData.getNames())
                .created_at(personData.getCreated_at())
                .build();
    }
}
