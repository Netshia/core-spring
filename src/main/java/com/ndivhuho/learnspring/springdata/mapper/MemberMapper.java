package com.ndivhuho.learnspring.springdata.mapper;

import com.ndivhuho.learnspring.springdata.entity.Member;
import com.ndivhuho.learnspring.springdata.model.MemberDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, uses = {RoleMapper.class})
public interface MemberMapper {

    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    MemberDTO internalToDTO(Member member);

    Member DTOToInternal(MemberDTO memberDTO);

    List<MemberDTO> internalsToDTOs(List<Member> members);
}