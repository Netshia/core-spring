package com.ndivhuho.learnspring.springdata.controller;

import com.ndivhuho.learnspring.springdata.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

}
