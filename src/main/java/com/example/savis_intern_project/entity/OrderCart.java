package com.example.savis_intern_project.entity;


import lombok.*;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderCart {
    private ArrayList<Item> items;
}
