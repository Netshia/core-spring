package com.ndivhuho.learnspring.springdata.mapper;

import com.ndivhuho.learnspring.springdata.model.PersonDTO;
import com.ndivhuho.learnspring.springdata.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, uses = {AddressMapper.class})
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonDTO internalToDTO(Person person);

    List<PersonDTO> internalsToDTOs(List<Person> tasks);
}