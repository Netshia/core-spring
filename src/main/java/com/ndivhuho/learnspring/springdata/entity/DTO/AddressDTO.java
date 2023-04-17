package com.ndivhuho.learnspring.springdata.entity.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDTO {

    private Long id;
    private String province;
    private String city;
    private String streetName;
}
