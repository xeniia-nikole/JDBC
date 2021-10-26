package com.jdbc.repository;

import com.jdbc.model.Product;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JDBCRepository {

    private NamedParameterJdbcTemplate jdbcTemplate;

    public JDBCRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Product> getProductName(String customerName) {
        String sqlQuery = read("myScript.sql");
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource()
                .addValue("name", customerName);
        return jdbcTemplate.query(sqlQuery, mapSqlParameterSource,
                ((rs, rowNum) -> new Product()
                        .setProductName(rs.getString("product_name"))
                        .setAmount(rs.getInt("amount"))
                        .setDate(rs.getString("date"))));
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
