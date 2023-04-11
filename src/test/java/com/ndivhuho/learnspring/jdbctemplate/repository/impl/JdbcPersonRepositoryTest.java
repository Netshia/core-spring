package com.ndivhuho.learnspring.jdbctemplate.repository.impl;

import com.ndivhuho.learnspring.jdbctemplate.config.DatabaseConfig;
import com.ndivhuho.learnspring.jdbctemplate.entity.Person;
import com.ndivhuho.learnspring.jdbctemplate.entity.PersonRowMapper;
import com.ndivhuho.learnspring.jdbctemplate.repository.PersonRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JdbcPersonRepositoryTest {

    @Mock
    JdbcTemplate jdbcTemplate;

    @Mock
    PersonRowMapper personRowMapper;

    @InjectMocks
    JdbcPersonRepository jdbcPersonRepository;

    @BeforeEach
    void setUp() {
        assertNotNull(jdbcPersonRepository);
    }

    @Test
    void findAll_shouldReturnPersonList() {

        // Set-up
        List<Person> personList = List.of(
                Person.builder()
                        .id(1L)
                        .firstName("Ndivhuho")
                        .lastName("Netshia")
                        .build(),

                Person.builder()
                        .id(2L)
                        .firstName("John")
                        .lastName("Smith")
                        .build(),

                Person.builder()
                        .id(3L)
                        .firstName("Ntakuseni")
                        .lastName("Netshia")
                        .build()
        );

        // Mock
        when(jdbcTemplate.query("SELECT id, first_name, last_name FROM Person",
                personRowMapper))
                .thenReturn(personList);

        // System under test
        List<Person> actualExpectation = jdbcPersonRepository.findAll();

        // verify
        assertEquals(actualExpectation, personList);
    }

    @Test
    void findById_shouldReturnPerson() {

        // set-up
        final Long ID = 1L;

        // expectation
        final Person expectation = Person.builder()
                .id(ID)
                .firstName("Ndivhuho")
                .lastName("Netshia")
                .build();

        // Mock
        when(jdbcTemplate.queryForObject(
                "SELECT id, last_name, first_name FROM Person WHERE id=?",
                personRowMapper,
                ID))
                .thenReturn(expectation);

        //system under test
        Person actualResults = jdbcPersonRepository.findById(ID);

        // verify
        assertEquals(expectation, actualResults);
    }

    @Test
    void save() {
    }
}