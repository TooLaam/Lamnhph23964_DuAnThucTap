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
    private String colorName;
    private Integer Quantity;
    private BigDecimal Price;
    private BigDecimal ProductPrice;
    private UUID ProductId;
    private UUID ProductDetailId;
    private Cart cart;
    private ProductDetail productDetail;

    public CartDetailView(UUID id, String name, String colorName, Integer quantity, BigDecimal price, BigDecimal productPrice, UUID productId, UUID productDetailId, Cart cart, ProductDetail productDetail) {
        Id = id;
        Name = name;
        this.colorName = colorName;
        Quantity = quantity;
        Price = price;
        ProductPrice = productPrice;
        ProductId = productId;
        ProductDetailId = productDetailId;
        this.cart = cart;
        this.productDetail = productDetail;
    }

    public CartDetailView() {

    }
}
