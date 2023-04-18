package com.ndivhuho.learnspring.springdata.mapper;

import com.ndivhuho.learnspring.springdata.entity.Role;
import com.ndivhuho.learnspring.springdata.model.RoleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface RoleMapper {

    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    RoleDTO internalToDTO(Role role);

    @Mapping(target = "member", ignore = true)
    Role DTOToInternalToDTO(RoleDTO roleDTO);

    List<RoleDTO> internalsToDTOs(List<Role> roles);

    List<Role> DTOsToInternals(List<RoleDTO> roleDTOS);
}