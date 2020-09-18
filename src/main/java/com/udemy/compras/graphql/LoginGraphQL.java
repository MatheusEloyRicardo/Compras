package com.udemy.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.domain.Login;
import com.udemy.compras.domain.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoginGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private LoginService service;

    public Login login(long id) {
        return service.findById(id);
    }

    public List<Login> logins() {
        return service.findAll();
    }
}
