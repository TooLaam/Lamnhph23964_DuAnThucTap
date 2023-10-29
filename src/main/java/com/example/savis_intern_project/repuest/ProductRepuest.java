package com.example.savis_intern_project.repuest;


import com.example.savis_intern_project.entity.CategoryDetail;
import com.example.savis_intern_project.entity.CategoryValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRepuest {

    private String name;
    private Integer availableQuantity;
    private Integer sold;
    private Integer likes;
    private Date createdDate;
    private Integer status;
    private String descripTion;
    private UUID brand;
    private List<CategoryValue> listCate;

}
