package com.ndivhuho.learnspring.springdata.repository;

import com.ndivhuho.learnspring.springdata.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
