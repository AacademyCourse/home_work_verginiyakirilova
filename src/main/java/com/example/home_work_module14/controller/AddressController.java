package com.example.home_work_module14.controller;

import com.example.home_work_module14.entity.Address;
import com.example.home_work_module14.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping(path = "/{id}")
    public Address getAddress(@PathVariable Long id){
        return  this.addressService.getAddressById(id);
    }
    @PostMapping(path = "/add")
    public Address createAddress (@RequestBody Address address){
        return addressService.saveAddress(address);
    }
    @DeleteMapping(path = "/delete/{id}")
    public String deleteAddress(@PathVariable Long id){
        this.addressService.deleteById(id);
        return String.format("User with %s id is deleted", id);
    }
}
