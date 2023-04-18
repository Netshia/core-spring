package com.ndivhuho.learnspring.springdata.service;

import com.ndivhuho.learnspring.springdata.entity.Role;
import com.ndivhuho.learnspring.springdata.model.RoleDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    List<RoleDTO> findAll();

    void saveRole(final RoleDTO roleDTO);

    void saveAllRoles(final List<RoleDTO> roleDTOS);

    List<RoleDTO> findAllByMember(final Long id);
}
