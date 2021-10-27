package com.jdbc.repository;

import com.jdbc.model.Product;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Component
public class JDBCRepository {

    private final JdbcTemplate jdbcTemplate;
    private final String sql;

    public JDBCRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.sql = read("productByName.sql");
    }

    public String getProductName(String customersName) {
        Product product = jdbcTemplate.queryForObject(sql, (resultSet, rowNum) -> new Product(
                resultSet.getString("product_name"),
                resultSet.getInt("amount")
        ), customersName);
        if (product != null) {
            return customersName + "'s order contains " + product.getAmount() +
                    " pieces of product " + product.getProductName();
        } else {
            System.out.println(customersName + "'s order includes nothing");
            return null;
        }
    }


    public static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
