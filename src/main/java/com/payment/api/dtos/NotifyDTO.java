package com.payment.api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class NotifyDTO {

    @JsonProperty("message")
    private String message;
    @JsonProperty("status")
    private String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "NotifyDTO{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
