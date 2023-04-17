package com.ndivhuho.learnspring.springdata.service;

import com.ndivhuho.learnspring.springdata.entity.Member;

import java.time.LocalDate;
import java.util.List;

public interface MemberService {

    List<Member> findAllByStatus(final int status);

    List<Member> findAllByMembershipDate(final LocalDate membershipDate);

    List<Member> findAllByMembershipDateAfter(final LocalDate dateAfter);

    List<Member> findAllByMembershipDateBefore(final LocalDate dateBefore);
}
