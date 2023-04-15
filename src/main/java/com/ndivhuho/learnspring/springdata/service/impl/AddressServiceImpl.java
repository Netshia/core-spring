package com.ndivhuho.learnspring.springdata.service.impl;

import com.ndivhuho.learnspring.springdata.entity.Address;
import com.ndivhuho.learnspring.springdata.repository.AddressRepository;
import com.ndivhuho.learnspring.springdata.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(final Address address) {
        addressRepository.save(address);
    }
}
