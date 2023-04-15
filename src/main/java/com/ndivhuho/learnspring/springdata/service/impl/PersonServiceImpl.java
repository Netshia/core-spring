package com.ndivhuho.learnspring.springdata.service.impl;

import com.ndivhuho.learnspring.springdata.entity.Person;
import com.ndivhuho.learnspring.springdata.enums.Gender;
import com.ndivhuho.learnspring.springdata.repository.PersonRepository;
import com.ndivhuho.learnspring.springdata.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("jpaPersonService")
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(@Qualifier("personRepository") final PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void save(final Person person) {
        personRepository.save(person);
    }

    @Override
    public List<Person> findAllMales(final Gender gender) {
        return personRepository.findAllMales(gender);
    }

    @Override
    public List<Person> findAllFemales(final Gender gender) {
        return personRepository.findAllFemales(gender);
    }
}
