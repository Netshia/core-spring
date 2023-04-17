package com.ndivhuho.learnspring.springdata.repository;

import com.ndivhuho.learnspring.springdata.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findAllByStatus(final int status);

    List<Member> findAllByMembershipDate(final LocalDate membershipDate);

    List<Member> findAllByMembershipDateAfter(final LocalDate dateAfter);

    List<Member> findAllByMembershipDateBefore(final LocalDate dateBefore);
}
