package com.ndivhuho.learnspring.springdata.repository;

import com.ndivhuho.learnspring.springdata.entity.Person;
import com.ndivhuho.learnspring.springdata.enums.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("SELECT p FROM #{#entityName} p WHERE p.gender = ?#{#gender.MALE}")
    List<Person> findAllMales(final Gender gender);

    @Query("SELECT p FROM #{#entityName} p WHERE p.gender = ?#{#gender.MALE}")
    List<Person> findAllFemales(final Gender gender);

    @Query("SELECT p FROM #{#entityName} p JOIN FETCH p.addresses WHERE p.gender = ?#{#gender.MALE}")
    List<Person> findAllMalesFetchAddressEagerly(final Gender gender);
}
