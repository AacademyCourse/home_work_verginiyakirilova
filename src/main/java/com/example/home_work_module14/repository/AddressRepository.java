package com.example.home_work_module14.repository;

import com.example.home_work_module14.entity.Address;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address,Long> {
}
