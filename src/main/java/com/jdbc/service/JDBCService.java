package com.jdbc.service;

import com.jdbc.repository.JDBCRepository;
import org.springframework.stereotype.Service;

@Service
public class JDBCService {
    private JDBCRepository repository;

    public JDBCService(JDBCRepository repository) {
        this.repository = repository;
    }

    public String getProductName(String name) {
        return repository.getProductName(name);
    }
}
