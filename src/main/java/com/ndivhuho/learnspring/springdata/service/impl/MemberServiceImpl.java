package com.ndivhuho.learnspring.springdata.service.impl;

import com.ndivhuho.learnspring.springdata.entity.Member;
import com.ndivhuho.learnspring.springdata.service.MemberService;

import java.time.LocalDate;
import java.util.List;

public class MemberServiceImpl implements MemberService {
    @Override
    public List<Member> findAllByStatus(int status) {
        return null;
    }

    @Override
    public List<Member> findAllByMembershipDate(LocalDate membershipDate) {
        return null;
    }

    @Override
    public List<Member> findAllByMembershipDateAfter(LocalDate dateAfter) {
        return null;
    }

    @Override
    public List<Member> findAllByMembershipDateBefore(LocalDate dateBefore) {
        return null;
    }
}
