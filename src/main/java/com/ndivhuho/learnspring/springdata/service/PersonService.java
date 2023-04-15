package com.ndivhuho.learnspring.springdata.service;

import com.ndivhuho.learnspring.springdata.entity.Person;
import com.ndivhuho.learnspring.springdata.enums.Gender;

import java.util.List;

public interface PersonService {

    void save(final Person person);

    List<Person> findAllMales(final Gender gender);

    List<Person> findAllFemales(final Gender gender);
}
