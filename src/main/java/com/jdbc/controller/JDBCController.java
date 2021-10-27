package com.jdbc.controller;

import com.jdbc.repository.JDBCRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class JDBCController {
    private final JDBCRepository jdbcRepository;

    public JDBCController(JDBCRepository jdbcRepository) {
        this.jdbcRepository = jdbcRepository;
    }

    @GetMapping("/products/fetch-product")
    public String getCustomerProduct(@RequestParam("name") String customersName) {
        return jdbcRepository.getProductName(customersName);
    }
}

