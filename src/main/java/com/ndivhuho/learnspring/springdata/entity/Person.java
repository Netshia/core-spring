package com.ndivhuho.learnspring.springdata.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ndivhuho.learnspring.springdata.enums.Gender;
import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person extends AbstractEntity {

    private String firstName;
    private String lastName;
    private LocalDate dob;

    @Enumerated(EnumType.STRING)
    private Gender gender = Gender.MALE;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
    private List<Address> addresses = new ArrayList<>();
}