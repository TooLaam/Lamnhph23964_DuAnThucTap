package com.example.savis_intern_project.controller;


import com.example.savis_intern_project.entity.*;
import com.example.savis_intern_project.repository.BrandResponsitory;
import com.example.savis_intern_project.repository.ColorResponsitory;
import com.example.savis_intern_project.repository.ProductImageResponsitory;
import com.example.savis_intern_project.repository.ProductResponsitory;
import com.example.savis_intern_project.service.serviceimpl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/product_detail")
public class ProductDetailController {
    @Autowired
    private ProductServiceimpl productServiceimpl;
    @Autowired
    private ColorServiceimpl colorServiceimpl;
    @Autowired
    private ProductDetailServiceimpl productDetailServiceimpl;
    @Autowired
    private ProductImageServiceimpl productImageServiceimpl;
    @Autowired
    private ProductResponsitory productResponsitory;
    @Autowired
    private ColorResponsitory colorResponsitory;
    @Autowired
    private ProductImageResponsitory productImageResponsitory;
    private final Path root = Paths.get("src/main/resources/static/assets/img/product");
    @GetMapping("/index")
    public String hienThi(Model model){
        model.addAttribute("listProduct",productServiceimpl.getAll());
        model.addAttribute("listColor",colorServiceimpl.getAll());
        model.addAttribute("listProductImage",productImageServiceimpl.getAll());
        model.addAttribute("listProductDetail",productDetailServiceimpl.getAll());
        model.addAttribute("ProductDetail",new ProductDetail());
        model.addAttribute("view", "/ProductDetail/index.jsp");
        return "index";
    }

//    @GetMapping("/indexcus" )
//    public String show_data_product_cus(Model model){
//
//        model.addAttribute("listProduct",productServiceimpl.getAll());
//        model.addAttribute("Product",new Product());
//        model.addAttribute("listCategory",categoryServiceimpl.getAll());
//        model.addAttribute("listColor",colorServiceimpl.getAll());
//        model.addAttribute("view", "/product/index.jsp");
//        return "/customerFE/index";
//    }

//    @PostMapping("/add")
//    public String add(Model model,
//                      @RequestParam("importPrice") BigDecimal importPrice,
//                      @RequestParam("price") BigDecimal price,
//                      @RequestParam("quantity") Integer quantity,
//                      @RequestParam("createdDate") Date createdDate,
//                      @RequestParam("descripTion") String descripTion,
//                      @RequestParam("status") Integer status,
//                      @RequestParam("product") String product,
//                      @RequestParam("color")String color,
//                      @RequestParam("listImages")String listImages
//    ){
//
//        Product product1 = productResponsitory.findById(UUID.fromString(product)).orElse(null);
//        Color color1 = colorResponsitory.findById(UUID.fromString(color)).orElse(null);
//        ProductImage productImage = productImageResponsitory.findById(UUID.fromString(listImages)).orElse(null);
//        ProductDetail productDetail = new ProductDetail(importPrice,price,quantity,createdDate,status,descripTion,product1,color1, (List<ProductImage>) productImage);
//        productDetailServiceimpl.add(productDetail);
//        System.out.println(productDetail.toString());
//        return "redirect:/product_detail/index";
//    }
@PostMapping(value = "add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
public String upload(Model model,
                     @RequestParam("files") MultipartFile[] files,
                     @RequestParam("importPrice") BigDecimal importPrice,
                      @RequestParam("price") BigDecimal price,
                      @RequestParam("quantity") Integer quantity,
                      @RequestParam("createdDate") Date createdDate,
                      @RequestParam("descripTion") String descripTion,
                      @RequestParam("status") Integer status,
                      @RequestParam("product") String product,
                      @RequestParam("color")String color,
                      @RequestParam("listImages")String listImages) {
    ProductImage productImage = productImageResponsitory.findById(UUID.fromString(listImages)).orElse(null);
    Product product1 = productResponsitory.findById(UUID.fromString(product)).orElse(null);
    Color color1 = colorResponsitory.findById(UUID.fromString(color)).orElse(null);
    String message = "";
    try {
        List<String> fileNames = new ArrayList<>();

        Arrays.asList(files).stream().forEach(file -> {
            ProductDetail a = new ProductDetail();
            File uploadRootDir = new File(String.valueOf(root));
            if (!uploadRootDir.exists()) {
                uploadRootDir.mkdirs();
            }
            try {
                String filename = file.getOriginalFilename();
                File serverFile = new File(uploadRootDir.getAbsoluteFile() + File.separator + filename);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(file.getBytes());
//                a.setListImages(filename);
                a.setImportPrice(importPrice);
                a.setPrice(price);
                a.setQuantity(quantity);
                a.setCreatedDate(createdDate);
                a.setDescripTion(descripTion);
                a.setStatus(status);
                a.setProduct(product1);
                a.setColor(color1);
                a.setListImages((List<ProductImage>) productImage);
//                a.setListImages(filename);
                productDetailServiceimpl.add(a);
                stream.close();
            } catch (Exception e) {

            }
        });

        message = "Uploaded the files successfully: " + fileNames;
    } catch (Exception e) {
        message = "Fail to upload files!";
    }
    return "redirect:/product_detail/index";
}
    @GetMapping("/detail/{id}")
    public String detail(Model model,
                         @PathVariable("id") UUID id
                         ){
        model.addAttribute("listProduct",productServiceimpl.getAll());
        model.addAttribute("listColor",colorServiceimpl.getAll());
        model.addAttribute("listProductImage",productImageServiceimpl.getAll());
        model.addAttribute("listProductDetail",productDetailServiceimpl.getAll());
        model.addAttribute("detailSP",productDetailServiceimpl.getOne(id));
        model.addAttribute("view", "/ProductDetail/index.jsp");
        return "index";
    }
    @GetMapping("/delete/{id}")
    public String delete(Model model,
                         @PathVariable("id") UUID id){
        productDetailServiceimpl.delete(id);
        return "redirect:/product_detail/index";
    }
    @PostMapping("/update/{id}")
    public String update(Model model,
                         @PathVariable("id") UUID id,
                         @ModelAttribute("productDetail") ProductDetail productDetail){
       productDetailServiceimpl.update(id,productDetail);
        return "redirect:/product_detail/index";
    }
}
