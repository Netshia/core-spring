package com.ndivhuho.learnspring.springdata.service.impl;

import com.ndivhuho.learnspring.springdata.entity.Role;
import com.ndivhuho.learnspring.springdata.mapper.RoleMapper;
import com.ndivhuho.learnspring.springdata.model.MemberDTO;
import com.ndivhuho.learnspring.springdata.model.RoleDTO;
import com.ndivhuho.learnspring.springdata.repository.RoleRepository;
import com.ndivhuho.learnspring.springdata.service.MemberService;
import com.ndivhuho.learnspring.springdata.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;
    private final MemberService memberService;

    @Override
    public List<RoleDTO> findAll() {
        final List<Role> roles = repository.findAll();
        return RoleMapper.INSTANCE.internalsToDTOs(roles);
    }

    @Override
    public void saveRole(RoleDTO roleDTO) {
        final Role role = RoleMapper.INSTANCE.DTOToInternalToDTO(roleDTO);
        repository.save(role);
    }

    @Override
    public void saveAllRoles(List<RoleDTO> roleDTOS) {
        final List<Role> roles = RoleMapper.INSTANCE.DTOsToInternals(roleDTOS);
        repository.saveAll(roles);
    }

    @Override
    public List<RoleDTO> findAllByMember(Long id) {
        final MemberDTO memberDTO = memberService.findWithRolesById(id);
        return memberDTO.getRoles();
    }
}