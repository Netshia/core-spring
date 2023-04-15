package com.ndivhuho.learnspring.springdata.entity;

import com.ndivhuho.learnspring.springdata.enums.Gender;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class Person extends AbstractEntity {

    private String firstName;
    private String lastName;
    private LocalDate dob;

    @Enumerated(EnumType.STRING)
    private Gender gender = Gender.MALE;

    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
    private List<Address> addresses;

}
