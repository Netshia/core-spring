package com.ndivhuho.learnspring.jdbctemplate.controller;

import com.ndivhuho.learnspring.jdbctemplate.entity.Person;
import com.ndivhuho.learnspring.jdbctemplate.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(final PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons() {
        final List<Person> people = personService.findAll();
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Person> findById(@PathVariable final Long id) {
        final Person person = personService.findById(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> savePerson(@RequestBody final Person person) {
        personService.save(person);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("as-map/{id}")
    public ResponseEntity<Map<String, Object>> findByIdAsMap(@PathVariable(name = "id") final Long id) {
        final Map<String, Object> personMap = personService.findbyIdAsMap(id);
        return new ResponseEntity<>(personMap, HttpStatus.OK);
    }

    @GetMapping("list-as-map")
    public ResponseEntity<List<Map<String, Object>>> findAllAsMap() {
        final List<Map<String, Object>> personMapList = personService.findAllAsMap();
        return new ResponseEntity<>(personMapList, HttpStatus.OK);
    }

    @PostMapping("create-table/{name}")
    public ResponseEntity<Integer> createTable(@PathVariable(name = "name") final String name) {
        final Integer rowsAffected = personService.createTable(name);
        return new ResponseEntity<>(rowsAffected, HttpStatus.CREATED);
    }
}