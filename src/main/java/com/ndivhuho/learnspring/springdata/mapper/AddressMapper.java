package com.ndivhuho.learnspring.springdata.mapper;

import com.ndivhuho.learnspring.springdata.entity.Address;
import com.ndivhuho.learnspring.springdata.entity.DTO.AddressDTO;
import com.ndivhuho.learnspring.springdata.entity.DTO.PersonDTO;
import com.ndivhuho.learnspring.springdata.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    AddressDTO internalToDTO(Address address);

    List<AddressDTO> internalsToDTOs(List<Address> addresses);
}