package com.ndivhuho.learnspring.springdata.service.impl;

import com.ndivhuho.learnspring.springdata.entity.Address;
import com.ndivhuho.learnspring.springdata.entity.Person;
import com.ndivhuho.learnspring.springdata.enums.Gender;
import com.ndivhuho.learnspring.springdata.repository.PersonRepository;
import com.ndivhuho.learnspring.springdata.service.AddressService;
import com.ndivhuho.learnspring.springdata.service.PersonService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("jpaPersonService")
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final AddressService addressService;

    public PersonServiceImpl(@Qualifier("personRepository") final PersonRepository personRepository,
                             final AddressService addressService) {

        this.personRepository = personRepository;
        this.addressService = addressService;
    }

    @Override
    public void save(final Person person) {

        final Person p = personRepository.save(person);
        person.getAddresses().forEach(address -> {
            address.setPerson(p);
            saveAddress(address);
        });
    }

    @Override
    public List<Person> findAllMales(final Gender gender) {
        return personRepository.findAllMales(gender);
    }

    @Override
    public List<Person> findAllFemales(final Gender gender) {
        return personRepository.findAllFemales(gender);
    }

    @Override
    public List<Person> findAllMalesFetchAddressEagerly(final Gender gender) {
        return personRepository.findAllMalesFetchAddressEagerly(gender);
    }

    private void saveAddress(final Address address) {
        addressService.save(address);
    }
}
