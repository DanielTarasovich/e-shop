package com.daniel.springshop.controller;


import com.daniel.springshop.domain.User;
import com.daniel.springshop.dto.ProductDTO;
import com.daniel.springshop.dto.UserDTO;
import com.daniel.springshop.service.ProductService;
import com.daniel.springshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public  String list(Model model){
        List<ProductDTO> list = productService.getAll();
        model.addAttribute("products", list);
        return "products";
    }

  @GetMapping("/{id}/bucket")
    public String addBucket(@PathVariable Long id, Principal principal){
        if(principal==null){
            return "redirect:/products";
        }
        productService.addToUserBucket(id, principal.getName());
      return "redirect:/products";

  }

}
