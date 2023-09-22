package com.example.savis_intern_project.service.serviceimpl;


import com.example.savis_intern_project.entity.Color;
import com.example.savis_intern_project.repository.ColorResponsitory;
import com.example.savis_intern_project.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class ColorServiceimpl implements ColorService {
    @Autowired
    ColorResponsitory  responsitory;
    @Override
    public ArrayList<Color> getAll() {
        return (ArrayList<Color>) responsitory.findAll();
    }

    @Override
    public void save(Color color) {
            responsitory.saveAndFlush(color);
    }

    @Override
    public void delete(UUID id) {
       responsitory.deleteById(id);
    }

    @Override
    public void update(UUID id, Color color) {
         Color a = getOne(id).get();
         a.setName(color.getName());
         responsitory.flush();
    }

    @Override
    public Optional<Color> getOne(UUID id) {
        return responsitory.findById(id);
    }
}
