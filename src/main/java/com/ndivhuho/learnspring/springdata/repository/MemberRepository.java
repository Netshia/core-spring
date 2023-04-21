package com.ndivhuho.learnspring.springdata.repository;

import com.ndivhuho.learnspring.springdata.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findAllByStatus(final boolean status);

    List<Member> findAllByMembershipDate(final LocalDate membershipDate);

    List<Member> findAllByMembershipDateAfter(final LocalDate dateAfter);

    List<Member> findAllByMembershipDateBefore(final LocalDate dateBefore);

    @Query("SELECT m FROM #{#entityName} m JOIN FETCH m.roles WHERE m.id =:id")
    Member findWithRolesById(@Param("id") final Long id);
}
