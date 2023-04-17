package com.ndivhuho.learnspring.springdata.service.impl;

import com.ndivhuho.learnspring.springdata.entity.Member;
import com.ndivhuho.learnspring.springdata.mapper.MemberMapper;
import com.ndivhuho.learnspring.springdata.model.MemberDTO;
import com.ndivhuho.learnspring.springdata.repository.MemberRepository;
import com.ndivhuho.learnspring.springdata.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public void save(final MemberDTO memberDTO) {
        final Member member = MemberMapper.INSTANCE.DTOToInternal(memberDTO);
        memberRepository.save(member);
    }

    @Override
    public MemberDTO findById(Long id) {
        final Member member = memberRepository.findById(id).get();
        return MemberMapper.INSTANCE.internalToDTO(member);
    }

    @Override
    public List<MemberDTO> findAllByStatus(int status) {
        final List<Member> members = memberRepository.findAllByStatus(status);
        return MemberMapper.INSTANCE.internalsToDTOs(members);
    }

    @Override
    public List<MemberDTO> findAllByMembershipDate(LocalDate membershipDate) {
        final List<Member> members = memberRepository.findAllByMembershipDate(membershipDate);
        return MemberMapper.INSTANCE.internalsToDTOs(members);
    }

    @Override
    public List<MemberDTO> findAllByMembershipDateAfter(LocalDate dateAfter) {
        final List<Member> members = memberRepository.findAllByMembershipDateAfter(dateAfter);
        return MemberMapper.INSTANCE.internalsToDTOs(members);
    }

    @Override
    public List<MemberDTO> findAllByMembershipDateBefore(LocalDate dateBefore) {
        final List<Member> members = memberRepository.findAllByMembershipDateBefore(dateBefore);
        return MemberMapper.INSTANCE.internalsToDTOs(members);
    }
}