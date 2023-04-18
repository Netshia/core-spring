package com.ndivhuho.learnspring.springdata.service;

import com.ndivhuho.learnspring.springdata.model.MemberDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MemberService {

    void save(final MemberDTO memberDTO);

    MemberDTO findById(final Long id);

    MemberDTO findWithRolesById(final Long id);

    List<MemberDTO> findAllByStatus(final int status);

    List<MemberDTO> findAllByMembershipDate(final LocalDate membershipDate);

    List<MemberDTO> findAllByMembershipDateAfter(final LocalDate dateAfter);

    List<MemberDTO> findAllByMembershipDateBefore(final LocalDate dateBefore);
}
