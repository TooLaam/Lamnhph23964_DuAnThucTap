package com.example.savis_intern_project.service.serviceimpl;

import com.example.savis_intern_project.entity.Role;
import com.example.savis_intern_project.repository.RoleRepository;
import com.example.savis_intern_project.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role detail(UUID id) {
        return roleRepository.getById(id);
    }

    @Override
    public List<Role> getAll() {

        return roleRepository.findAll();
    }
}
