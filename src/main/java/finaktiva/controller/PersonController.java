package finaktiva.controller;

import finaktiva.domain.person.Person;
import finaktiva.repository.person.PersonData;
import finaktiva.repository.person.PersonDataMapper;
import finaktiva.service.api.PersonService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/persons/")
public class PersonController {

    private final static PersonDataMapper MAPPER = new PersonDataMapper();

    @Autowired
    private PersonService service;

    @GetMapping
    public List<Person> findAll() {
        final List<Person> persons = new ArrayList<>();
        service.getAll().forEach(personData -> persons.add(MAPPER.iMap(personData)));
        return persons;
    }

    @PostMapping
    public Person save(@Valid @RequestBody Person person) {
        final PersonData data = MAPPER.map(person);
        service.save(data);
        return person;
    }

    @GetMapping("{id}")
    public Person findById(@PathVariable Long id) {
        final PersonData personData = service.findByID(id);
        if (personData != null) {
            return MAPPER.iMap(service.findByID(id));

        }
        return null;
    }

    @PutMapping("{id}")
    public Person update(@PathVariable Long id, @RequestBody Person person) {
        final PersonData personData = service.findByID(id);
        if (personData != null) {
            BeanUtils.copyProperties(person, personData, "id");
            service.save(personData);
            return MAPPER.iMap(personData);
        }
        return null;
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        final PersonData personData = service.findByID(id);
        if (personData != null)
            service.delete(id);
    }
}
