package com.payment.api.services;

import com.payment.api.dtos.AuthorizeDTO;
import com.payment.api.integration.AuthorizerAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizeService {

    @Autowired
    private AuthorizerAPI authorizerAPI;

    public boolean isAuthorized(){
        AuthorizeDTO authorizeDTO = authorizerAPI.authorizerQuery();
        return authorizeDTO.getData().isAuthorization();
    }
}
