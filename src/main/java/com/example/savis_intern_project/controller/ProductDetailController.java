package com.example.savis_intern_project.controller;


import com.example.savis_intern_project.entity.*;
import com.example.savis_intern_project.repository.BrandResponsitory;
import com.example.savis_intern_project.repository.ColorResponsitory;
import com.example.savis_intern_project.repository.ProductImageResponsitory;
import com.example.savis_intern_project.repository.ProductResponsitory;
import com.example.savis_intern_project.service.serviceimpl.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.time.LocalDate;
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
    public String hienThi(Model model) {
        model.addAttribute("listProduct", productServiceimpl.getAll());
        model.addAttribute("listColor", colorServiceimpl.getAll());
        model.addAttribute("listProductImage", productImageServiceimpl.getAll());
        model.addAttribute("listProductDetail", productDetailServiceimpl.getAll());
        model.addAttribute("ProductDetail", new ProductDetail());
        model.addAttribute("view", "/ProductDetail/index.jsp");
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("listProduct", productServiceimpl.getAll());
        model.addAttribute("listColor", colorServiceimpl.getAll());
        model.addAttribute("listProductImage", productImageServiceimpl.getAll());
        model.addAttribute("listProductDetail", productDetailServiceimpl.getAll());
        model.addAttribute("ProductDetail", new ProductDetail());
        model.addAttribute("view", "/ProductDetail/createProductDetail.jsp");
        return "index";
    }

    @GetMapping("/indexcus/{productDetailId}")
    public String show_data_product_cus(@PathVariable("productDetailId") UUID productDetailId, Model model) {

        model.addAttribute("listProduct", productServiceimpl.getAllProduct().subList(0, 4));
        model.addAttribute("productDetail", productDetailServiceimpl.getProductDetailById(productDetailId));
        model.addAttribute("image", productImageServiceimpl.getByProductDetailId(productDetailId).get(0));
        model.addAttribute("listImage", productImageServiceimpl.getByProductDetailId(productDetailId));
        model.addAttribute("listColor", colorServiceimpl.getAllByProductDetailId(productDetailId));
        model.addAttribute("view", "/detail/index.jsp");
        return "/customerFE/index";
    }

    @GetMapping("/increase/{productDetailId}")
    public String IncreaseProductDetail(@PathVariable("productDetailId") UUID productDetailId) {
        ProductDetail productDetail = productDetailServiceimpl.getOne(productDetailId);

        if (productDetail == null) {
            // Xử lý trường hợp sản phẩm không tồn tại, ví dụ: thông báo lỗi.
            return "redirect:/error";
        }

        productDetail.setQuantity(productDetail.getQuantity() + 1);
        productDetailServiceimpl.update(productDetailId, productDetail);
        return "redirect:/product_detail/indexcus/{productDetailId}";
    }

    @GetMapping("/reduce/{productDetailId}")
    public String ReduceProductDetail(@PathVariable("productDetailId") UUID productDetailId) {
        ProductDetail productDetail = productDetailServiceimpl.getOne(productDetailId);

        if (productDetail == null) {
            // Xử lý trường hợp sản phẩm không tồn tại, ví dụ: thông báo lỗi.
            return "redirect:/error";
        }

        if(productDetail.getQuantity() > 1){
            productDetail.setQuantity(productDetail.getQuantity() - 1);
            productDetailServiceimpl.update(productDetailId, productDetail);
        }
        return "redirect:/product_detail/indexcus/{productDetailId}";
    }

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
//    @PostMapping(value = "add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public String upload(Model model,
//                         @RequestParam("files") MultipartFile[] files,
//                         @RequestParam("importPrice") BigDecimal importPrice,
//                         @RequestParam("price") BigDecimal price,
//                         @RequestParam("quantity") Integer quantity,
//                         @RequestParam("createdDate") Date createdDate,
//                         @RequestParam("descripTion") String descripTion,
//                         @RequestParam("status") Integer status,
//                         @RequestParam("product") String product,
//                         @RequestParam("color") String color,
//                         @RequestParam("listImages") String listImages) {
//        ProductImage productImage = productImageResponsitory.findById(UUID.fromString(listImages)).orElse(null);
//        Product product1 = productResponsitory.findById(UUID.fromString(product)).orElse(null);
//        Color color1 = colorResponsitory.findById(UUID.fromString(color)).orElse(null);
//        String message = "";
//        try {
//            String fileNames = null;
//
//            Arrays.asList(files).stream().forEach(file -> {
//                ProductDetail a = new ProductDetail();
//                File uploadRootDir = new File(String.valueOf(root));
//                if (!uploadRootDir.exists()) {
//                    uploadRootDir.mkdirs();
//                }
//                try {
//                    String filename = file.getOriginalFilename();
//                    File serverFile = new File(uploadRootDir.getAbsoluteFile() + File.separator + filename);
//                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
//                    stream.write(file.getBytes());
//                    a.setImportPrice(importPrice);
//                    a.setPrice(price);
//                    a.setQuantity(quantity);
//                    a.setCreatedDate(createdDate);
//                    a.setDescripTion(descripTion);
//                    a.setStatus(status);
//                    a.setProduct(product1);
//                    a.setColor(color1);
////                a.setListImages((List<ProductImage>) fileNames);
//                    productDetailServiceimpl.add(a);
//                    stream.close();
//                } catch (Exception e) {
//
//                }
//            });
//
//            message = "Uploaded the files successfully: " + fileNames;
//        } catch (Exception e) {
//            message = "Fail to upload files!";
//        }
//        return "redirect:/product_detail/index";
//    }
    @PostMapping(value = "add")
    public String upload(Model model,
                         @ModelAttribute("ProductRepuest") ProductRepuest productRepuest,
                         @RequestParam("files") List<MultipartFile> files
                         ) throws IOException {

        ProductDetail a = new ProductDetail();
            a.setImportPrice(productRepuest.getImportPrice());
            a.setPrice(productRepuest.getPrice());
            a.setQuantity(productRepuest.getQuantity());
            a.setStatus(productRepuest.getStatus());
            a.setDescripTion(productRepuest.getDescripTion());
        a.setCreatedDate(java.sql.Date.valueOf(LocalDate.now()));
        a.setProduct(Product.builder().id(productRepuest.getProduct()).build());
        a.setColor(Color.builder().Id(productRepuest.getColor()).build());
        productDetailServiceimpl.add(a);

        for (MultipartFile file : files) {
            ProductImage spa = new ProductImage();
            ClassPathResource resource = new ClassPathResource("static/assets/img/product/");
            String uploadDir = resource.getFile().getAbsolutePath();
            File uploadPath = new File(uploadDir);
            if (!uploadPath.exists()) {
                uploadPath.mkdirs();
            }
            spa.setName(file.getOriginalFilename());
            spa.setStaTus(0);
            spa.setProductDetail(a);
            productImageServiceimpl.add(spa);
        }
            return "redirect:/product_detail/index";
    }
    @PutMapping (value = "update/{id}")
    public String update(Model model,
                         @ModelAttribute("ProductRepuest") ProductRepuest productRepuest,
                         @RequestParam("files") List<MultipartFile> files,
                         @PathVariable("id") UUID id
    ) throws IOException {

        ProductDetail a = new ProductDetail();
        a.setImportPrice(productRepuest.getImportPrice());
        a.setPrice(productRepuest.getPrice());
        a.setQuantity(productRepuest.getQuantity());
        a.setStatus(productRepuest.getStatus());
        a.setDescripTion(productRepuest.getDescripTion());
        a.setCreatedDate(java.sql.Date.valueOf(LocalDate.now()));
        a.setProduct(Product.builder().id(productRepuest.getProduct()).build());
        a.setColor(Color.builder().Id(productRepuest.getColor()).build());
        productDetailServiceimpl.update(id,a);

        for (MultipartFile file : files) {
            ProductImage spa = new ProductImage();
            ClassPathResource resource = new ClassPathResource("static/assets/img/product/");
            String uploadDir = resource.getFile().getAbsolutePath();
            File uploadPath = new File(uploadDir);
            if (!uploadPath.exists()) {
                uploadPath.mkdirs();
            }
            spa.setName(file.getOriginalFilename());
            spa.setStaTus(0);
            spa.setProductDetail(a);
            productImageServiceimpl.update(id,spa);
        }
        return "redirect:/product_detail/index";
    }
    @GetMapping("/detail/{id}")
    public String detail(Model model,
                         @PathVariable("id") UUID id
    ) {
        model.addAttribute("listProduct", productServiceimpl.getAll());
        model.addAttribute("listColor", colorServiceimpl.getAll());
        model.addAttribute("listProductImage", productImageServiceimpl.getAll());
        model.addAttribute("listProductDetail", productDetailServiceimpl.getAll());
        model.addAttribute("detailSP", productDetailServiceimpl.getOne(id));
        model.addAttribute("view", "/ProductDetail/editProductDetail.jsp");
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model,
                         @PathVariable("id") UUID id) {
        productDetailServiceimpl.delete(id);
        return "redirect:/product_detail/index";
    }
    @GetMapping("/deleteImage/{id}")
    public String deleteImg(Model model, HttpServletRequest request,
                            @PathVariable("id") UUID id) {
        productImageServiceimpl.delete(id);
        String referer = request.getHeader("Referer");
        // Chuyển hướng trở lại trang gọi đến (referer)
        return "redirect:" + referer;

    }

    @PostMapping("/update/{id}")
    public String update(Model model,
                         @PathVariable("id") UUID id,
                         @ModelAttribute("productDetail") ProductDetail productDetail) {
        productDetailServiceimpl.update(id, productDetail);
        return "redirect:/product_detail/index";
    }
}
