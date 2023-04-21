package com.ndivhuho.learnspring.springdata.delegate;

import com.ndivhuho.learnspring.api.MemberApiDelegate;
import com.ndivhuho.learnspring.springdata.model.MemberDTO;
import com.ndivhuho.learnspring.springdata.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberApiDelegateImpl implements MemberApiDelegate {

    private final MemberService memberService;

    @Override
    public ResponseEntity<List<MemberDTO>> getById(Long id) {
        final MemberDTO memberDTO = memberService.findById(id);
        final List<MemberDTO> memberDTOS = List.of(memberDTO);
        return new ResponseEntity<>(memberDTOS, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<MemberDTO>> getByMembershipAfterDate(LocalDate date) {
        final List<MemberDTO> memberDTOS = memberService.findAllByMembershipDateAfter(date);
        return new ResponseEntity<>(memberDTOS, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<MemberDTO>> getByMembershipBeforeDate(LocalDate date) {
        final List<MemberDTO> memberDTOS = memberService.findAllByMembershipDateBefore(date);
        return new ResponseEntity<>(memberDTOS, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<MemberDTO>> getByMembershipStartDate(LocalDate date) {
        final List<MemberDTO> memberDTOS = memberService.findAllByMembershipDate(date);
        return new ResponseEntity<>(memberDTOS, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<MemberDTO>> getByStatus(Boolean status) {
        final List<MemberDTO> memberDTOS = memberService.findAllByStatus(status);
        return new ResponseEntity<>(memberDTOS, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> saveMember(MemberDTO memberDTO) {
        memberService.save(memberDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}