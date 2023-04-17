package com.ndivhuho.learnspring.springdata.service;

import com.ndivhuho.learnspring.springdata.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleService {

    List<Role> findAllByMember(final Long id);

    List<Role> findAllByRoleValue(final String role);
}
