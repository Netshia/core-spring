package com.ndivhuho.learnspring.springdata.entity;

import com.ndivhuho.learnspring.springdata.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    private LocalDate anniversaryDate;

    @OneToOne(mappedBy = "person")
    private Member member;
}