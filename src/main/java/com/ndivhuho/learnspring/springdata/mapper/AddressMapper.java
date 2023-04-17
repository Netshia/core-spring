package com.ndivhuho.learnspring.springdata.mapper;

import com.ndivhuho.learnspring.springdata.entity.Address;
import com.ndivhuho.learnspring.springdata.model.AddressDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    AddressDTO internalToDTO(Address address);

    @Mapping(target = "person", ignore = true)
    Address DTOToInternalToDTO(AddressDTO addressDTO);

    List<AddressDTO> internalsToDTOs(List<Address> addresses);
}