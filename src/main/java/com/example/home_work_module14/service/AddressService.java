package com.example.home_work_module14.service;

import com.example.home_work_module14.entity.Address;
import com.example.home_work_module14.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
    public Address saveAddress (Address address){
        Address addressToBeCreated = new Address();
        addressToBeCreated.setCountry(address.getCountry());
        addressToBeCreated.setCity(address.getCity());
        addressToBeCreated.setStreet(address.getStreet());
        addressToBeCreated.setStreet_number(address.getStreet_number());

        return this.addressRepository.save(addressToBeCreated);
    }

    public Address getAddressById(Long id){
        return this.addressRepository.findById(id).get();
    }

    public void deleteById(Long id){
        this.addressRepository.deleteById(id);
    }
}
