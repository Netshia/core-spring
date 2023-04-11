package com.ndivhuho.learnspring.jdbctemplate.service;

import com.ndivhuho.learnspring.jdbctemplate.entity.Person;

import java.util.List;
import java.util.Map;

public interface PersonService {

    List<Person> findAll();

    Person findById(final Long id);

    void save(final Person person);

    Map<String, Object> findbyIdAsMap(final Long id);

    List<Map<String, Object>> findAllAsMap();

    int createTable(final String name);
}