package com.ndivhuho.learnspring.springdata.entity.DTO;

import com.ndivhuho.learnspring.springdata.entity.Address;
import com.ndivhuho.learnspring.springdata.enums.Gender;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class PersonDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private Gender gender;
    private List<AddressDTO> addresses;
}
