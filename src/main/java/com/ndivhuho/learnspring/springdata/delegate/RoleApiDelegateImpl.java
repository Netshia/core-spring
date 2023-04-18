package com.ndivhuho.learnspring.springdata.delegate;

import com.ndivhuho.learnspring.api.RoleApiDelegate;
import com.ndivhuho.learnspring.springdata.model.RoleDTO;
import com.ndivhuho.learnspring.springdata.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleApiDelegateImpl implements RoleApiDelegate {

    private final RoleService roleService;

    @Override
    public ResponseEntity<List<RoleDTO>> getAllRoles() {
        final List<RoleDTO> roleDTOS = roleService.findAll();
        return ResponseEntity.ok(roleDTOS);
    }

    @Override
    public ResponseEntity<List<RoleDTO>> getAllRolesByMember(Long memberId) {
        final List<RoleDTO> roleDTOS = roleService.findAllByMember(memberId);
        return ResponseEntity.ok(roleDTOS);
    }

    @Override
    public ResponseEntity<Object> saveAllRole(List<RoleDTO> roleDTO) {
        roleService.saveAllRoles(roleDTO);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Object> saveRole(RoleDTO roleDTO) {
        roleService.saveRole(roleDTO);
        return ResponseEntity.ok().build();
    }
}
