package com.example.home_work_module14.runner;

import com.example.home_work_module14.entity.Address;
import com.example.home_work_module14.entity.User;
import com.example.home_work_module14.repository.AddressRepository;
import com.example.home_work_module14.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandRunner implements CommandLineRunner {
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {
            createTableUser();
            createTableAddress();

    }

    public void createTableUser(){
        User user = new User();
        user.setFirst_name("Ivan");
        user.setLast_name("Ivanov");
        user.setPhone_number("0896553323");
        user.setEmail("vankata@abv.bg");
        user.setCreatedAt(user.getCreatedAt());

        User user1 = new User();
        user1.setFirst_name("Petar");
        user1.setLast_name("Petkov");
        user1.setPhone_number("088896354");
        user1.setEmail("petko@abv.bg");
        user1.setCreatedAt(user.getCreatedAt());
        userRepository.save(user);
        userRepository.save(user1);
     }
   public void createTableAddress(){
        Address address = new Address();
        address.setCountry("Bulgaria");
        address.setCity("Sofiq");
        address.setStreet("Caricradsko");
        address.setStreet_number("12");

       Address address1 = new Address();
       address1.setCountry("Bulgaria");
       address1.setCity("Varna");
       address1.setStreet("Osmi primorski polk");
       address1.setStreet_number("10");
       addressRepository.save(address);
       addressRepository.save(address1);
    }
}


