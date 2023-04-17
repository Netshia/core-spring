package com.ndivhuho.learnspring.springdata.entity;

import com.ndivhuho.learnspring.springdata.enums.RoleValue;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role extends AbstractEntity {

    @Enumerated(EnumType.STRING)
    private RoleValue roleValue;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;
}
