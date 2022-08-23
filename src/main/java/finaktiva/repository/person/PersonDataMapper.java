package finaktiva.repository.person;

import finaktiva.domain.person.Person;
import finaktiva.domain.person.PersonFactory;
import finaktiva.mapper.IMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class PersonDataMapper implements IMapper<Person, PersonData> {

    @Override
    public PersonData map(Person in) {
        final PersonData personData = new PersonData();
        BeanUtils.copyProperties(in, personData, "id");
        return personData;
    }

    @Override
    public Person iMap(PersonData out) {
        return PersonFactory.createPerson(out);
    }
}
