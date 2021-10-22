package com.jdbc.controller;

import com.jdbc.service.JDBCService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class JDBCController {
    private final JDBCService service;

    public JDBCController(JDBCService service) {
        this.service = service;
    }

    @GetMapping("/products/fetch-product")
    public String getProductName(String name) {
        String product_name = service.getProductName(name);
        System.out.println("Клиент " + name + " купил продукт " + product_name);
        return product_name;
    }

}
