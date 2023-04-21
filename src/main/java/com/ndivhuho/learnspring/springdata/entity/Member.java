package com.ndivhuho.learnspring.springdata.entity;

import com.ndivhuho.learnspring.springdata.enums.StatusValue;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Member extends AbstractEntity {

    private String membershipDate;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Role> roles;

    private boolean status;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;
}
