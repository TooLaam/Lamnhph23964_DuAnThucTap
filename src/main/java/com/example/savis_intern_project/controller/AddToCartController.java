package com.example.savis_intern_project.controller;


import com.example.savis_intern_project.entity.Item;
import com.example.savis_intern_project.entity.OrderCart;
import com.example.savis_intern_project.entity.Product;
import com.example.savis_intern_project.service.serviceimpl.ProductServiceimpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

@Controller
public class AddToCartController {


    @Autowired
    private HttpSession httpSession;
    @Autowired
    ProductServiceimpl productServie;

    UUID productId = UUID.fromString("60975438-e58b-47a7-8c71-42726ea92e7c");


    @GetMapping("/cart/add")
    public String themGioHang() {
        Product product = productServie.getOne(productId);

        if (product == null) {
            // Xử lý trường hợp sản phẩm không tồn tại, ví dụ: thông báo lỗi.
            return "redirect:/error";
        }

        UUID productId1 = product.getId();
        String tenSanPham = product.getName();
//        BigDecimal price = product.getPrice();
//        Item item = new Item(productId1, tenSanPham, 1, price);
        OrderCart cartSession = (OrderCart) httpSession.getAttribute("OrderCart");

        if (cartSession == null) {
            OrderCart cart = new OrderCart();
            ArrayList<Item> list = new ArrayList<>();
//            list.add(item);
            cart.setItems(list);
            httpSession.setAttribute("OrderCart", cart);
        } else {
            OrderCart cart = (OrderCart) httpSession.getAttribute("OrderCart");
            if (cart == null) {
                // Xử lý trường hợp giỏ hàng không tồn tại, ví dụ: thông báo lỗi.
                return "redirect:/error";
            }

            ArrayList<Item> listItem = cart.getItems();
            if (listItem == null) {
                // Tạo danh sách mới nếu nó chưa tồn tại.
                listItem = new ArrayList<>();
            }

            for (Item itemTmp : listItem) {
                if (itemTmp.getIdProduct().equals(productId1)) {
                    itemTmp.setQuantity(itemTmp.getQuantity() + 1);
//                    itemTmp.setPrice(price.multiply(BigDecimal.valueOf(itemTmp.getQuantity())));
                    return "redirect:/viewOrderCart";
                }
            }
//            listItem.add(item);
            cart.setItems(listItem);
        }
        return "redirect:/viewOrderCart";
    }

    @GetMapping("/viewOrderCart")
    public String showCartItem(Model model) {
        OrderCart cart = (OrderCart) httpSession.getAttribute("OrderCart");

        if (cart == null || cart.getItems().isEmpty()) {
            // Giỏ hàng trống, thực hiện xử lý tại đây
            model.addAttribute("emptyCart", true);
            model.addAttribute("view", "/cart/index.jsp");
            return "/customerFE/index";
        }

        ArrayList<Item> list = cart.getItems();
        BigDecimal itemTotal = BigDecimal.ZERO;
        Integer quantity = 0;

        for (Item liItem : list) {
            BigDecimal total;
            total = liItem.getPrice();
            quantity += liItem.getQuantity();
            System.out.println("Total: " + total);
            System.out.println("Quantity: " + quantity);
            model.addAttribute("total", total);
            break;
        }

        model.addAttribute("cartDetail", list);
        model.addAttribute("quantity", quantity);
        model.addAttribute("view", "/cart/index.jsp");
        return "/customerFE/index";
    }



    @GetMapping("/add")
    public String themGioHang1() {
        Product product = productServie.getOne(productId);
        OrderCart cartSession = (OrderCart) httpSession.getAttribute("OrderCart");
        if (product == null) {
            // Xử lý trường hợp sản phẩm không tồn tại, ví dụ: thông báo lỗi.
            return "redirect:/error";
        }

        UUID productId1 = product.getId();
        String tenSanPham = product.getName();
//        BigDecimal price = product.getPrice();
//        Item item = new Item(productId1, tenSanPham, 1, price);

        if (cartSession == null) {
            OrderCart cart = new OrderCart();
            ArrayList<Item> list = new ArrayList<>();
//            list.add(item);
            cart.setItems(list);
            httpSession.setAttribute("OrderCart", cart);
        } else {
//            OrderCart cart = (OrderCart) httpSession.getAttribute("OrderCart");
            if (cartSession == null) {
                // Xử lý trường hợp giỏ hàng không tồn tại, ví dụ: thông báo lỗi.
                return "redirect:/error";
            }

            ArrayList<Item> listItem = cartSession.getItems();
            if (listItem == null) {
                // Tạo danh sách mới nếu nó chưa tồn tại.
                listItem = new ArrayList<>();
            }

            for (Item itemTmp : listItem) {
                if (itemTmp.getIdProduct().equals(productId1)) {
                    itemTmp.setQuantity(itemTmp.getQuantity() + 1);
//                    itemTmp.setPrice(price.multiply(BigDecimal.valueOf(itemTmp.getQuantity())));
                    return "redirect:/viewOrderCart";
                }
            }
//            listItem.add(item);
            cartSession.setItems(listItem);
        }
        return "redirect:/viewOrderCart";
    }


}
