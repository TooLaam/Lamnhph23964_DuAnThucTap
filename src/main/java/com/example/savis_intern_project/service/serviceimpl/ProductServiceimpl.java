package com.example.savis_intern_project.service.serviceimpl;

import com.example.savis_intern_project.entity.*;
import com.example.savis_intern_project.entity.ViewModels.CartDetailView;
import com.example.savis_intern_project.entity.ViewModels.ProductView;
import com.example.savis_intern_project.repository.ProductDetailResponsitory;
import com.example.savis_intern_project.repository.ProductImageResponsitory;
import com.example.savis_intern_project.repository.ProductResponsitory;
import com.example.savis_intern_project.service.ProductServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceimpl implements ProductServie {
    @Autowired
    ProductResponsitory responsitory;
    @Autowired
    ProductDetailResponsitory productDetailResponsitory;
    @Autowired
    ProductImageResponsitory productImageResponsitory;

    @Override
    public Product add(Product product) {
        product.setCreatedDate(Date.valueOf(LocalDate.now()));
         return  responsitory.saveAndFlush(product);
    }

    @Override
    public void delete(UUID id) {
      responsitory.deleteById(id);
    }

    @Override
    public void update(UUID id, Product product) {
        Product pro = getOne(id);
        pro.setName(product.getName());
        pro.setDescripTion(product.getDescripTion());
        pro.setAvailableQuantity(product.getAvailableQuantity());
        pro.setSold(product.getSold());
        pro.setLikes(product.getLikes());
//        pro.setCreatedDate(product.getCreatedDate());
        pro.setStatus(product.getStatus());
        pro.setDescripTion(product.getDescripTion());
        pro.setBrand(product.getBrand());
//        pro.setList(product.getList());
        responsitory.flush();
    }

    @Override
    public List<Product> getAll() {
        return responsitory.findAll();
    }

    @Override
    public Product getOne(UUID id) {

        return responsitory.findById(id).get();
    }

    @Override
    public ArrayList<ProductView> getAllProduct() {
        List<Product> products = responsitory.findAll();

        ArrayList<ProductView> pv = new ArrayList<>();

        for (Product product : products) {
            ProductDetail productDetail = productDetailResponsitory.findByProductId(product.getId()).get(0);

            if (productDetail != null) {
                ProductView productView = new ProductView();
                productView.setId(product.getId());
                productView.setName(product.getName());
                productView.setAvailableQuantity(product.getAvailableQuantity());
                productView.setPrice(productDetail.getPrice());
                productView.setSold(product.getSold());
                productView.setLikes(product.getLikes());
                productView.setCreatedDate(product.getCreatedDate());
                productView.setStatus(product.getStatus());
                productView.setDescripTion(product.getDescripTion());
                productView.setProductDetailId(productDetail.getId());
                productView.setBrand(product.getBrand());

                ProductImage productImage = productImageResponsitory.findByProductDetailId(productDetail.getId()).get(0);

                if (productImage != null) {
                    productView.setImage(productImage.getName());
                }
                else{
                    productView.setImage("deafault.png");
                }
                pv.add(productView);
            }
        }

        return pv;
    }

    @Override
    public ArrayList<ProductView> getAllProductByName(String name) {
        List<Product> products = responsitory.findByProductName(name);

        ArrayList<ProductView> pv = new ArrayList<>();

        for (Product product : products) {
            ProductDetail productDetail = productDetailResponsitory.findByProductId(product.getId()).get(0);

            if (productDetail != null) {
                ProductView productView = new ProductView();
                productView.setId(product.getId());
                productView.setName(product.getName());
                productView.setAvailableQuantity(product.getAvailableQuantity());
                productView.setPrice(productDetail.getPrice());
                productView.setSold(product.getSold());
                productView.setLikes(product.getLikes());
                productView.setCreatedDate(product.getCreatedDate());
                productView.setStatus(product.getStatus());
                productView.setDescripTion(product.getDescripTion());
                productView.setProductDetailId(productDetail.getId());
                productView.setBrand(product.getBrand());

                ProductImage productImage = productImageResponsitory.findByProductDetailId(productDetail.getId()).get(0);

                if (productImage != null) {
                    productView.setImage(productImage.getName());
                }
                else{
                    productView.setImage("deafault.png");
                }
                pv.add(productView);
            }
        }

        return pv;
    }

    @Override
    public ArrayList<ProductView> getAllProductByBrand(UUID id) {
        List<Product> products = responsitory.findProductByBrand(id);

        ArrayList<ProductView> pv = new ArrayList<>();

        for (Product product : products) {
            ProductDetail productDetail = productDetailResponsitory.findByProductId(product.getId()).get(0);

            if (productDetail != null) {
                ProductView productView = new ProductView();
                productView.setId(product.getId());
                productView.setName(product.getName());
                productView.setAvailableQuantity(product.getAvailableQuantity());
                productView.setPrice(productDetail.getPrice());
                productView.setSold(product.getSold());
                productView.setLikes(product.getLikes());
                productView.setCreatedDate(product.getCreatedDate());
                productView.setStatus(product.getStatus());
                productView.setDescripTion(product.getDescripTion());
                productView.setProductDetailId(productDetail.getId());
                productView.setBrand(product.getBrand());

                ProductImage productImage = productImageResponsitory.findByProductDetailId(productDetail.getId()).get(0);

                if (productImage != null) {
                    productView.setImage(productImage.getName());
                }
                else{
                    productView.setImage("deafault.png");
                }
                pv.add(productView);
            }
        }

        return pv;
    }
}
