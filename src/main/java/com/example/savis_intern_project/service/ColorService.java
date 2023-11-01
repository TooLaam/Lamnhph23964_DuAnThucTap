package com.example.savis_intern_project.service;

import com.example.savis_intern_project.entity.Color;
import com.example.savis_intern_project.entity.ViewModels.ColorView;

import java.util.ArrayList;
import java.util.UUID;

public interface ColorService {
    ArrayList<Color> getAll();

    ArrayList<ColorView> getAllByProductDetailId(UUID id);

    void save(Color color);

    void delete(UUID id);

    void update(UUID id, Color color);

    Color getOne(UUID id);
}
