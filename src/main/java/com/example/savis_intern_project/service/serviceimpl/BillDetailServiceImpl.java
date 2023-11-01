package com.example.savis_intern_project.service.serviceimpl;

import com.example.savis_intern_project.entity.BillDetail;
import com.example.savis_intern_project.entity.*;
import com.example.savis_intern_project.entity.ViewModels.BillDetailView;
import com.example.savis_intern_project.entity.ViewModels.CartDetailView;
import com.example.savis_intern_project.repository.BillDetailRepository;
import com.example.savis_intern_project.repository.ColorResponsitory;
import com.example.savis_intern_project.repository.ProductDetailResponsitory;
import com.example.savis_intern_project.repository.ProductResponsitory;
import com.example.savis_intern_project.service.BillDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Date;

import java.util.ArrayList;

import java.util.List;
import java.util.UUID;


@Service
public class BillDetailServiceImpl implements BillDetailService {

    @Autowired
    BillDetailRepository billDetailRepository;
    @Autowired
    ProductDetailResponsitory productDetailResponsitory;
    @Autowired
    ProductResponsitory productResponsitory;
    @Autowired
    ColorResponsitory colorResponsitory;


    @Override
    public void create_new_billdetail(BillDetail billDetail) {
        billDetailRepository.save(billDetail);
    }

    @Override
    public List<BillDetail> get_all_billdetail() {
        return billDetailRepository.findAll();
    }
    @Override
    public List<BillDetail> get_all_by_billId(UUID billId) {
        return billDetailRepository.getAllByBillId(billId);
    }

    @Override

    public List<Object[]> get_all_product_sale_by_Date(Date startDate, Date endDate) {
        return billDetailRepository.getProductSalesData(startDate, endDate);
    }

    @Override
    public List<BillDetailView> getByBillId(UUID billId) {
        List<BillDetail> billDetails = billDetailRepository.getBillDetailByBillId(billId);

        List<BillDetailView> billDetailViews = new ArrayList<>();

        for (BillDetail billDetail : billDetails) {
            UUID productDetailId = billDetail.getProductDetail().getId();
            ProductDetail productDetail = productDetailResponsitory.findById(productDetailId).orElse(null);

            if (productDetail != null) {
                UUID productId = productDetail.getProduct().getId();
                Product product = productResponsitory.findById(productId).orElse(null);
                UUID colorId = productDetail.getColor().getId();
                Color color = colorResponsitory.findById(colorId).orElse(null);

                if (product != null && color != null) {
                    // Create a CartDetailView and set its properties
                    BillDetailView c = new BillDetailView();
                    c.setId(billDetail.getId());
                    c.setProductName(product.getName());
                    c.setColorName(color.getName());
                    c.setQuantity(billDetail.getQuantity());
                    c.setPrice(billDetail.getPrice());
                    c.setBill(billDetail.getBill());
                    c.setProductDetail(billDetail.getProductDetail());

                    billDetailViews.add(c);
                }
            }
        }

        return billDetailViews;
    }


    @Override
    public BillDetail get_one_bill_detail(UUID billDetailId) {
        return billDetailRepository.findById(billDetailId).get();
    }


    @Override
    public void delete_detail(UUID billDetailId) {
        billDetailRepository.deleteById(billDetailId);
    }
}
