package com.example.savis_intern_project.service;

import com.example.savis_intern_project.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public interface RoleService {
    Role detail(UUID id);
    List<Role> getAll();
}
