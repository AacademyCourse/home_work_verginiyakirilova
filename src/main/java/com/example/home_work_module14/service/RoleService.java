package com.example.home_work_module14.service;

import com.example.home_work_module14.entity.Role;
import com.example.home_work_module14.entity.User;
import com.example.home_work_module14.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    public Role getRoleById(Long id) {
        return this.roleRepository.findById(id).get();
    }
}
