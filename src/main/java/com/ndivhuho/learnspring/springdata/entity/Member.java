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

    @Enumerated(EnumType.ORDINAL)
    private StatusValue status;
}