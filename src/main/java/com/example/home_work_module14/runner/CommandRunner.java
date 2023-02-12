package com.example.home_work_module14.runner;

import com.example.home_work_module14.entity.Address;
import com.example.home_work_module14.entity.Role;
import com.example.home_work_module14.entity.User;
import com.example.home_work_module14.repository.AddressRepository;
import com.example.home_work_module14.repository.RoleRepository;
import com.example.home_work_module14.repository.UserRepository;
import com.example.home_work_module14.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class CommandRunner implements CommandLineRunner {
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    RoleService roleService;


    @Override
    public void run(String... args) throws Exception {
            createUser();
            createAddress();
//            createRole();
    }
    public List<Role> createRole() {
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        Role clientsRole = new Role();
        clientsRole.setRoleName("Client");
        Role userRole = new Role();
        userRole.setRoleName("User");
        List<Role> roles = List.of(adminRole, clientsRole, userRole);
        roleRepository.saveAll(roles);
        return roles;
    }
    public void createUser(){
        List<Role> savedRoles = createRole();
        Set<Address> addresses = createAddress();
        User user = new User();
        user.setFirst_name("Ivan");
        user.setLast_name("Ivanov");
        user.setPhone_number("0896553323");
        user.setEmail("vankata@abv.bg");
        user.setCreatedAt(user.getCreatedAt());
        Set<Role> rolesForUser = new HashSet<>(savedRoles);
        user.setRoles(rolesForUser);
        user.setAddresses(addresses);
        userRepository.save(user);

        User user1 = new User();
        user1.setFirst_name("Petar");
        user1.setLast_name("Petkov");
        user1.setPhone_number("088896354");
        user1.setEmail("petko@abv.bg");
        user1.setCreatedAt(user.getCreatedAt());
        user1.setRoles(rolesForUser);
        user1.setAddresses(addresses);
        userRepository.save(user1);
     }
   public Set<Address> createAddress(){
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

       Set<Address> addAddress = Set.of(address,address1);
       addressRepository.saveAll(addAddress);
       return addAddress;
    }
}


