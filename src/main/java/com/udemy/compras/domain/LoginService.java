package com.udemy.compras.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    @Autowired
    private LoginRepository rep;

    public Login findById(long id) {
        return rep.findById(id).orElse(null);
    }

    public List<Login> findAll() {
        return rep.findAll();
    }
}
