package com.ndivhuho.learnspring.springdata.controller;

import com.ndivhuho.learnspring.springdata.entity.Person;
import com.ndivhuho.learnspring.springdata.enums.Gender;
import com.ndivhuho.learnspring.springdata.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("jpaPersonController")
@RequestMapping("v1/person")
public class PersonController {

    @Qualifier("jpaPersonService")
    private PersonService personService;

    @Autowired
    public PersonController(@Qualifier("jpaPersonService") final PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/males")
    public ResponseEntity<?> getAllMales() {
        final List<Person> males = personService.findAllMales(Gender.MALE);
        return new ResponseEntity<>(males, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody final Person person) {
        personService.save(person);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/males-address")
    public ResponseEntity<?> getAllMalesWithAddress() {
        final List<Person> males = personService.findAllMalesFetchAddressEagerly(Gender.MALE);
        return new ResponseEntity<>(males, HttpStatus.OK);
    }
}
