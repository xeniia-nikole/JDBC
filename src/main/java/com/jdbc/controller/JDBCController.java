package com.jdbc.controller;

import com.jdbc.model.Product;
import com.jdbc.repository.JDBCRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class JDBCController {

        private JDBCRepository jdbcRepository;

        public JDBCController(JDBCRepository jdbcRepository) {
            this.jdbcRepository = jdbcRepository;
        }

        @GetMapping("/products/fetch-product")
        public List<String> getCustomerProduct(@RequestParam("name") String name) {
            List<Product> products = jdbcRepository.getProductName(name);
            List<String> productsName = new ArrayList<>(10);
            for(Product product : products) {
                productsName.add(product.getProductName());
            }
            return productsName;
        }

}
