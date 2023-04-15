package com.ndivhuho.learnspring.jdbctemplate.service.impl;

import com.ndivhuho.learnspring.jdbctemplate.entity.Person;
import com.ndivhuho.learnspring.jdbctemplate.repository.PersonRepository;
import com.ndivhuho.learnspring.jdbctemplate.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(@Qualifier("jdbcPersonRepo") final PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional(transactionManager = "platformTransactionManager", readOnly = true)
    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findById(Long id) {
        return personRepository.findById(id);
    }

    @Override
    public void save(Person person) {
        personRepository.save(person);
    }

    @Override
    public Map<String, Object> findbyIdAsMap(Long id) {
        return personRepository.findbyIdAsMap(id);
    }

    @Override
    public List<Map<String, Object>> findAllAsMap() {
        return personRepository.findAllAsMap();
    }

    @Override
    public int createTable(String name) {
        return personRepository.createTable(name);
    }
}
