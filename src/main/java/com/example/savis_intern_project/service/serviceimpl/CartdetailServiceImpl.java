package com.example.savis_intern_project.service.serviceimpl;
import com.example.savis_intern_project.entity.Cart;
import com.example.savis_intern_project.entity.CartDetail;
import com.example.savis_intern_project.entity.Product;
import com.example.savis_intern_project.entity.ProductDetail;
import com.example.savis_intern_project.entity.ViewModels.CartDetailView;
import com.example.savis_intern_project.repository.CartRepository;
import com.example.savis_intern_project.repository.CartdetailRepository;
import com.example.savis_intern_project.repository.ProductDetailResponsitory;
import com.example.savis_intern_project.repository.ProductResponsitory;
import com.example.savis_intern_project.service.CartdetailService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CartdetailServiceImpl implements CartdetailService  {
    @Autowired
    CartdetailRepository responitory;
    @Autowired
    ProductDetailResponsitory productDetailResponsitory;
    @Autowired
    ProductResponsitory productResponsitory;
    @Autowired
    CartRepository cartRepository;

    @Override
    public ArrayList<CartDetail> getAll() {
        return (ArrayList<CartDetail>) responitory.findAll();
    }

    @Override
    public ArrayList<CartDetailView> getCartDetailByCustomerId(UUID customerId) {
        List<CartDetail> cartDetails = responitory.getCartDetailsByCustomerId(customerId);

        ArrayList<CartDetailView> cs = new ArrayList<>();

        for (CartDetail cartDetail : cartDetails) {
            UUID productDetailId = cartDetail.getProductDetail().getId();
            ProductDetail productDetail = productDetailResponsitory.findById(productDetailId).orElse(null);

            if (productDetail != null) {
                UUID productId = productDetail.getProduct().getId();
                Product product = productResponsitory.findById(productId).orElse(null);

                if (product != null) {
                    Cart cart = cartRepository.findById(productDetailId).orElse(null);
                    // Create a CartDetailView and set its properties
                    CartDetailView c = new CartDetailView();
                    c.setId(cartDetail.getId());
                    c.setName(product.getName());
                    c.setQuantity(cartDetail.getQuantity());
                    c.setPrice(cartDetail.getPrice());
                    c.setProductId(product.getId());
                    c.setProductDetailId(productDetail.getId());
                    c.setCart(cart);
                    c.setProductDetail(productDetail);

                    cs.add(c);
                }
            }
        }

        return cs;
    }

    @Override
    public void save(CartDetail cartdetail)   {
        responitory.saveAndFlush(cartdetail);
    }

    @Override
    public void delete(UUID id)   {
        responitory.deleteById(id);
    }

    @Override
    public void update(UUID id, CartDetail cartdetail) {
        {
            CartDetail a = getOne(id).get();
            a.setProductDetail(cartdetail.getProductDetail());
            a.setQuantity(cartdetail.getQuantity());
            a.setPrice(cartdetail.getPrice());
            responitory.flush();
        }
    }

    @Override
    public Optional<CartDetail> getOne(UUID id)  {
        return responitory.findById(id);
    }

}
