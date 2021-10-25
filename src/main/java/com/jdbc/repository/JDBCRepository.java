package com.jdbc.repository;

import com.jdbc.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Repository
public class JDBCRepository {

        @Autowired
        private JdbcTemplate jdbcTemplate;

        private String scriptSelect;
        private final String pathScript = "select_product_name.sql";

        public String getProductName(String name) {

            scriptSelect = read(pathScript);

            Product product = jdbcTemplate.queryForObject(scriptSelect,
                    (rs, rowNum) -> new Product(rs.getString("name"), rs.getString("product_name")), name);
            if (product != null) {
                return product.getProduct_name();
            }
            else {
                System.out.println(name + " ничего не купил!");
                return null;
            }

        }

        private static String read(String scriptFileName) {
            try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
                 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
                return bufferedReader.lines().collect(Collectors.joining("\n"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
}
