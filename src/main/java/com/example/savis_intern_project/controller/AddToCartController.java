package com.example.savis_intern_project.controller;


import com.example.savis_intern_project.entity.*;
import com.example.savis_intern_project.entity.ViewModels.CartDetailView;
import com.example.savis_intern_project.service.serviceimpl.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class AddToCartController {
    @Autowired
    private HttpSession httpSession;
    @Autowired
    ProductDetailServiceimpl productDetailServiceimpl;
    @Autowired
    CustomerServiceImpl customerService;
    @Autowired
    CartServiceImpl cartService;
    @Autowired
    CartdetailServiceImpl cartDetailService;

    UUID productId = UUID.fromString("f548c39d-d212-45c3-b191-a2a80f8d9d3b");

    @GetMapping("/cart/add/{id}")
    public String themGioHang(@PathVariable("id") UUID id) {
        ProductDetail productDetail = productDetailServiceimpl.getOne(id);

        if (productDetail == null) {
            // Xử lý trường hợp sản phẩm không tồn tại, ví dụ: thông báo lỗi.
            return "redirect:/error";
        }

        if (httpSession.getAttribute("CustomerName") != null) {
            String username = (String) httpSession.getAttribute("CustomerName");
            Customer customer = customerService.getCustomerByName(username);
            var cart = cartService.getOne(customer.getId());
            var check = cartDetailService.checkExistCartDetail(customer.getId(), id);
            if (check) {
                cart.setTotalMoney(cart.getTotalMoney().add(productDetail.getPrice()));
                cartService.update(cart.getId(), cart);
                var cartDetail = cartDetailService.getOneCartDetail(customer.getId(), id);
                cartDetail.setQuantity(cartDetail.getQuantity() + 1);
                cartDetail.setPrice(cartDetail.getPrice().add(productDetail.getPrice()));
                cartDetailService.update(cartDetail.getId(), cartDetail);
            } else {
                cart.setQuantity(cart.getQuantity() + 1);
                cart.setTotalMoney(cart.getTotalMoney().add(productDetail.getPrice()));
                cartService.update(cart.getId(), cart);
                CartDetail cartDetail = new CartDetail();
                cartDetail.setId(UUID.randomUUID());
                cartDetail.setQuantity(1);
                cartDetail.setPrice(productDetail.getPrice());
                cartDetail.setCart(cart);
                cartDetail.setProductDetail(productDetail);
                cartDetailService.save(cartDetail);
            }
        }else{
            OrderCart cartSession = (OrderCart) httpSession.getAttribute("OrderCart");
            if (productDetail == null) {
                // Xử lý trường hợp sản phẩm không tồn tại, ví dụ: thông báo lỗi.
                return "redirect:/error";
            }

            UUID productId1 = productDetail.getId();
            String tenSanPham = productDetail.getProduct().getName();
            BigDecimal price = productDetail.getPrice();
            BillDetail item = new BillDetail();
            item.setPrice(price);
            item.setProductDetail(productDetailServiceimpl.getOne(productId1));
//        item.setBill(b);
            item.setQuantity(1);

            if (cartSession == null) {
                OrderCart cart = new OrderCart();
                ArrayList<BillDetail> list = new ArrayList<>();
                list.add(item);
                cart.setBillDetails(list);
                httpSession.setAttribute("OrderCart", cart);
            } else {
//            OrderCart cart = (OrderCart) httpSession.getAttribute("OrderCart");
                if (cartSession == null) {
                    // Xử lý trường hợp giỏ hàng không tồn tại, ví dụ: thông báo lỗi.
                    return "redirect:/error";
                }

                ArrayList<BillDetail> listItem = cartSession.getBillDetails();
                if (listItem == null) {
                    // Tạo danh sách mới nếu nó chưa tồn tại.
                    listItem = new ArrayList<>();
                }

                for (BillDetail itemTmp : listItem) {
                    if (itemTmp.getProductDetail().getId().equals(productId1)) {
                        itemTmp.setQuantity(itemTmp.getQuantity() + 1);
                        itemTmp.setPrice(price.multiply(BigDecimal.valueOf(itemTmp.getQuantity())));
                        return "redirect:/viewOrderCart";
                    }
                }
                listItem.add(item);
                cartSession.setBillDetails(listItem);
            }
            return "redirect:/viewOrderCart";
        }

        /*CartDetailView cartDetailView = new CartDetailView();
        cartDetailView.setId(productDetail.getId());
        cartDetailView.setName(productDetail.getProduct().getName());
        cartDetailView.setPrice(productDetail.getPrice());
        cartDetailView.setQuantity(1);
        ArrayList<CartDetailView> cartSession = (ArrayList<CartDetailView>) httpSession.getAttribute("OrderCart");

        if (cartSession == null) {
            ArrayList<CartDetailView> list = new ArrayList<CartDetailView>();
            list.add(cartDetailView);
            httpSession.setAttribute("OrderCart", list);
        } else {
            ArrayList<CartDetailView> cart = (ArrayList<CartDetailView>) httpSession.getAttribute("OrderCart");
            if (cart == null) {
                // Xử lý trường hợp giỏ hàng không tồn tại, ví dụ: thông báo lỗi.
                return "redirect:/error";
            }

            ArrayList<CartDetailView> listItem = cart;
            if (listItem == null) {
                // Tạo danh sách mới nếu nó chưa tồn tại.
                listItem = new ArrayList<CartDetailView>();
            }

            for (CartDetailView itemTmp : listItem) {
                if (itemTmp.getProductId().equals(cartDetailView.getId())) {
                    itemTmp.setQuantity(itemTmp.getQuantity() + 1);
                    itemTmp.setPrice(cartDetailView.getPrice().multiply(BigDecimal.valueOf(itemTmp.getQuantity())));
                    return "redirect:/viewOrderCart";
                }
            }
//            listItem.add(itemTmp);
            cart.add(listItem);
        }*/

        /*UUID productId1 = productDetail.getId();
        String tenSanPham = productDetail.getProduct().getName();
        BigDecimal price = productDetail.getPrice();
        Item item = new Item(productId1, tenSanPham, 1, price);
        OrderCart cartSession = (OrderCart) httpSession.getAttribute("OrderCart");

        if (cartSession == null) {
            OrderCart cart = new OrderCart();
            ArrayList<Item> list = new ArrayList<>();
            list.add(item);
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
                    itemTmp.setPrice(price.multiply(BigDecimal.valueOf(itemTmp.getQuantity())));
                    return "redirect:/viewOrderCart";
                }
            }
//            listItem.add(item);
            cart.setItems(listItem);
        }*/



        return "redirect:/viewOrderCart";
    }

    @GetMapping("/cart/increase/{id}")
    public String IncreaseCart(@PathVariable("id") UUID id) {
        CartDetail cartDetail = cartDetailService.getOne(id).get();
        ProductDetail productDetail = productDetailServiceimpl.getOne(cartDetail.getProductDetail().getId());

        if (productDetail == null) {
            // Xử lý trường hợp sản phẩm không tồn tại, ví dụ: thông báo lỗi.
            return "redirect:/error";
        }

        if (httpSession.getAttribute("CustomerName") != null) {
            String username = (String) httpSession.getAttribute("CustomerName");
            Customer customer = customerService.getCustomerByName(username);

            var cart = cartService.getOne(customer.getId());

            cart.setTotalMoney(cart.getTotalMoney().add(productDetail.getPrice()));
            cartService.update(cart.getId(), cart);
            cartDetail.setQuantity(cartDetail.getQuantity() + 1);
            cartDetail.setPrice(cartDetail.getPrice().add(productDetail.getPrice()));
            cartDetailService.update(cartDetail.getId(), cartDetail);
        }
        return "redirect:/viewOrderCart";
    }

    @GetMapping("/cart/reduce/{id}")
    public String ReduceCart(@PathVariable("id") UUID id) {
        CartDetail cartDetail = cartDetailService.getOne(id).get();
        ProductDetail productDetail = productDetailServiceimpl.getOne(cartDetail.getProductDetail().getId());

        if (productDetail == null) {
            // Xử lý trường hợp sản phẩm không tồn tại, ví dụ: thông báo lỗi.
            return "redirect:/error";
        }

        if (httpSession.getAttribute("CustomerName") != null) {
            String username = (String) httpSession.getAttribute("CustomerName");
            Customer customer = customerService.getCustomerByName(username);

            var cart = cartService.getOne(customer.getId());

            cart.setTotalMoney(cart.getTotalMoney().subtract(productDetail.getPrice()));
            if(cartDetail.getQuantity() > 1){
                cartDetail.setQuantity(cartDetail.getQuantity() - 1);
                cartDetail.setPrice(cartDetail.getPrice().subtract(productDetail.getPrice()));
                cartDetailService.update(cartDetail.getId(), cartDetail);
            }
            else{
                cartDetailService.delete(cartDetail.getId());
                cart.setQuantity(cart.getQuantity() - 1);
            }
            cartService.update(cart.getId(), cart);
        }
        return "redirect:/viewOrderCart";
    }

    @GetMapping("/cart/delete/{id}")
    public String deleteCart(@PathVariable("id") UUID id) {
        if (httpSession.getAttribute("CustomerName") != null) {
            CartDetail cartDetail = cartDetailService.getOne(id).get();

            if (cartDetail == null) {
                // Xử lý trường hợp sản phẩm không tồn tại, ví dụ: thông báo lỗi.
                return "redirect:/error";
            }

            String username = (String) httpSession.getAttribute("CustomerName");
            Customer customer = customerService.getCustomerByName(username);

            var cart = cartService.getOne(customer.getId());

            cart.setQuantity(cart.getQuantity() - 1);
            cart.setTotalMoney(cart.getTotalMoney().subtract(cartDetail.getPrice()));
            cartService.update(cart.getId(), cart);
            cartDetailService.delete(cartDetail.getId());
        }
        return "redirect:/viewOrderCart";
    }

    @GetMapping("/cart/deleteAll")
    public String deleteAllCart() {
        if (httpSession.getAttribute("CustomerName") != null) {
            List<CartDetail> cartDetail = cartDetailService.getAll();

            if (cartDetail == null) {
                // Xử lý trường hợp sản phẩm không tồn tại, ví dụ: thông báo lỗi.
                return "redirect:/error";
            }

            String username = (String) httpSession.getAttribute("CustomerName");
            Customer customer = customerService.getCustomerByName(username);

            var cart = cartService.getOne(customer.getId());

            cart.setQuantity(0);
            cart.setTotalMoney(BigDecimal.ZERO);
            cartService.update(cart.getId(), cart);
            cartDetailService.deleteAll(customer.getId());
        }
        return "redirect:/viewOrderCart";
    }

    @GetMapping("/viewOrderCart")
    public String showCartItem(Model model) {
        if (httpSession.getAttribute("CustomerName") != null) {
            String username = (String) httpSession.getAttribute("CustomerName");
            Customer customer = customerService.getCustomerByName(username);
            model.addAttribute("cart", cartService.getOne(customer.getId()));
            model.addAttribute("listCartDetail", cartDetailService.getCartDetailByCustomerId(customer.getId()));
            model.addAttribute("listProductDetail", productDetailServiceimpl.getAll());
        } else {
            OrderCart cart = (OrderCart) httpSession.getAttribute("OrderCart");

            if (cart == null || cart.getBillDetails().isEmpty()) {
                // Giỏ hàng trống, thực hiện xử lý tại đây
                model.addAttribute("emptyCart", true);
                model.addAttribute("view", "/cart/index.jsp");
                return "/customerFE/index";
            }

            ArrayList<BillDetail> list = cart.getBillDetails();
            BigDecimal itemTotal = BigDecimal.ZERO;
            Integer quantity = 0;

            for (BillDetail liItem : list) {
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
        }
        model.addAttribute("view", "/cart/index.jsp");
        return "/customerFE/index";
    }


    @GetMapping("/add/{id}")
    public String themGioHang1(@PathVariable("id") UUID id) {
        ProductDetail productDetail = productDetailServiceimpl.getOne(id);
        OrderCart cartSession = (OrderCart) httpSession.getAttribute("OrderCart");
        if (productDetail == null) {
            // Xử lý trường hợp sản phẩm không tồn tại, ví dụ: thông báo lỗi.
            return "redirect:/error";
        }

        UUID productId1 = productDetail.getId();
        String tenSanPham = productDetail.getProduct().getName();
        BigDecimal price = productDetail.getPrice();
        BillDetail item = new BillDetail();
        item.setPrice(price);
        item.setProductDetail(productDetailServiceimpl.getOne(productId1));
//        item.setBill(b);
        item.setQuantity(1);

        if (cartSession == null) {
            OrderCart cart = new OrderCart();
            ArrayList<BillDetail> list = new ArrayList<>();
            list.add(item);
            cart.setBillDetails(list);
            httpSession.setAttribute("OrderCart", cart);
        } else {
//            OrderCart cart = (OrderCart) httpSession.getAttribute("OrderCart");
            if (cartSession == null) {
                // Xử lý trường hợp giỏ hàng không tồn tại, ví dụ: thông báo lỗi.
                return "redirect:/error";
            }

            ArrayList<BillDetail> listItem = cartSession.getBillDetails();
            if (listItem == null) {
                // Tạo danh sách mới nếu nó chưa tồn tại.
                listItem = new ArrayList<>();
            }

            for (BillDetail itemTmp : listItem) {
                if (itemTmp.getProductDetail().getId().equals(productId1)) {
                    itemTmp.setQuantity(itemTmp.getQuantity() + 1);
                    itemTmp.setPrice(price.multiply(BigDecimal.valueOf(itemTmp.getQuantity())));
                    return "redirect:/viewOrderCart";
                }
            }
            listItem.add(item);
            cartSession.setBillDetails(listItem);
        }
        return "redirect:/viewOrderCart";
    }


}
