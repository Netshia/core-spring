package com.ndivhuho.learnspring.jdbctemplate.repository.impl;

import com.ndivhuho.learnspring.jdbctemplate.entity.Person;
import com.ndivhuho.learnspring.jdbctemplate.entity.PersonRowMapper;
import com.ndivhuho.learnspring.jdbctemplate.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("jdbcPersonRepo")
public class JdbcPersonRepository implements PersonRepository {

    private final JdbcTemplate jdbcTemplate;
    private final PersonRowMapper personRowMapper;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public JdbcPersonRepository(final JdbcTemplate jdbcTemplate,
                                final PersonRowMapper personRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.personRowMapper = personRowMapper;
    }

    @Override
    public List<Person> findAll() {
        return jdbcTemplate.query(
                "SELECT id, first_name, last_name FROM Person",
                personRowMapper);
    }

    @Override
    public Person findById(Long id) {
        return jdbcTemplate.queryForObject(
                "SELECT id, last_name, first_name FROM Person WHERE id = ?",
                personRowMapper,
                id);
    }

    @Override
    public void save(Person person) {
        jdbcTemplate.update(
                "INSERT INTO Person (id, first_name, last_name) VALUES(?, ?, ?)",
                person.getId(),
                person.getFirstName(),
                person.getLastName());
    }

    @Override
    public Map<String, Object> findbyIdAsMap(Long id) {
        return jdbcTemplate.queryForMap("SELECT * FROM Person WHERE id = ?",
                id);
    }

    @Override
    public List<Map<String, Object>> findAllAsMap() {
        return jdbcTemplate.queryForList("SELECT * FROM Person");
    }

    @Override
    public int createTable(String name) {
        jdbcTemplate.execute("CREATE TABLE " + name + " (id INTEGER, name VARCHAR(50))");

        jdbcTemplate.update("INSERT INTO " + name + " (id, name) VALUES(?, ?)",
                1, "VW");

        jdbcTemplate.update("INSERT INTO " + name + " (id, name) VALUES(?, ?)",
                2, "BMW");

        jdbcTemplate.update("INSERT INTO " + name + " (id, name) VALUES(?, ?)",
                3, "SUZUKI");

        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM " + name,
                Integer.class);
    }
}