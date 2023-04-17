package com.ndivhuho.learnspring.springdata.service.impl;

import com.ndivhuho.learnspring.springdata.entity.Address;
import com.ndivhuho.learnspring.springdata.model.PersonDTO;
import com.ndivhuho.learnspring.springdata.entity.Person;
import com.ndivhuho.learnspring.springdata.enums.Gender;
import com.ndivhuho.learnspring.springdata.mapper.PersonMapper;
import com.ndivhuho.learnspring.springdata.repository.PersonRepository;
import com.ndivhuho.learnspring.springdata.service.AddressService;
import com.ndivhuho.learnspring.springdata.service.PersonService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    public List<PersonDTO> findAllMales(final Gender gender) {
        final List<Person> personList = personRepository.findAllMales(gender);

        var list = personList.stream().map(person -> {
            person.setAddresses(new ArrayList<>());
            return person;
        }).collect(Collectors.toList());

        return PersonMapper.INSTANCE.internalsToDTOs(list);
    }

    @Override
    public List<Person> findAllFemales(final Gender gender) {
        return personRepository.findAllFemales(gender);
    }

    @Override
    public List<PersonDTO> findAllMalesFetchAddressEagerly(final Gender gender) {
        List<Person> personList = personRepository.findAllMalesFetchAddressEagerly(gender);
        return PersonMapper.INSTANCE.internalsToDTOs(personList);
    }

    private void saveAddress(final Address address) {
        addressService.save(address);
    }
}
