package com.ndivhuho.learnspring.springdata.delegate;

import com.ndivhuho.learnspring.api.PersonApiDelegate;
import com.ndivhuho.learnspring.springdata.enums.Gender;
import com.ndivhuho.learnspring.springdata.model.PersonDTO;
import com.ndivhuho.learnspring.springdata.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonApiDelegateImpl implements PersonApiDelegate {

    private final PersonService personService;

    @Autowired
    public PersonApiDelegateImpl(@Qualifier("jpaPersonService") final PersonService personService) {
        this.personService = personService;
    }

    @Override
    public ResponseEntity<List<PersonDTO>> getAllMales() {
        final List<PersonDTO> males = personService.findAllMales(Gender.MALE);
        return new ResponseEntity<>(males, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PersonDTO>> getAllMalesWithAddress() {
        final List<PersonDTO> males = personService.findAllMalesFetchAddressEagerly(Gender.MALE);
        return new ResponseEntity<>(males, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PersonDTO>> savePerson(PersonDTO personDTO) {
        //personService.save(person);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
