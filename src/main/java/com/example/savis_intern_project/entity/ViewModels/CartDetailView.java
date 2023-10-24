package com.example.savis_intern_project.entity.ViewModels;

import com.example.savis_intern_project.entity.Cart;
import com.example.savis_intern_project.entity.ProductDetail;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class CartDetailView {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;
    private String Name;
    private Integer Quantity;
    private BigDecimal Price;
    private UUID ProductId;
    private UUID ProductDetailId;
    private Cart cart;
    private ProductDetail productDetail;

    public CartDetailView(UUID id, String name, Integer quantity, BigDecimal price, UUID productId, Cart cart, ProductDetail productDetail) {
        Id = id;
        Name = name;
        Quantity = quantity;
        Price = price;
        ProductId = productId;
        this.cart = cart;
        this.productDetail = productDetail;
    }

    public CartDetailView() {

    }
}
