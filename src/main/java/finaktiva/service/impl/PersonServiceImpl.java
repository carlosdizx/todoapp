package finaktiva.service.impl;

import finaktiva.repository.person.PersonData;
import finaktiva.repository.person.PersonDataRepository;
import finaktiva.service.api.PersonService;
import finaktiva.util.GenericServiceApiImpl;
import org.springframework.data.jpa.repository.JpaRepository;

public class PersonServiceImpl extends GenericServiceApiImpl<PersonData, Long>  implements PersonService {

    private final PersonDataRepository repository;

    public PersonServiceImpl(PersonDataRepository repository) {
        this.repository = repository;
    }

    @Override
    public JpaRepository<PersonData, Long> getDao() {
        return repository;
    }
}
