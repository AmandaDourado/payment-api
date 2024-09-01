package com.payment.api.services;

import com.payment.api.authorizer.AuthorizeDTO;
import com.payment.api.authorizer.AuthorizerAPIQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizeService {

    @Autowired
    AuthorizerAPIQuery authorizerAPIQuery;

    public boolean isAuthorized(){
        AuthorizeDTO authorizeDTO = authorizerAPIQuery.authorizerQuery();
        return authorizeDTO.getData().isAuthorization();
    }
}
