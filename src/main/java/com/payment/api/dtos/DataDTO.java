package com.payment.api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataDTO {

    @JsonProperty("authorization")
    private boolean authorization;

    public boolean isAuthorization() {
        return authorization;
    }

    public void setAuthorization(boolean authorization) {
        this.authorization = authorization;
    }

    @Override
    public String toString() {
        return "DataDTO{" +
                "authorization=" + authorization +
                '}';
    }
}
