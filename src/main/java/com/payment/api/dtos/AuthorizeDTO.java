package com.payment.api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthorizeDTO {

    @JsonProperty("status")
    private String status;

    @JsonProperty("data")
    private DataDTO data = new DataDTO();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "AuthorizeDTO{" +
                "status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}

/*
{
  "status": "success",
  "data": {
    "authorization": true
  }
}

{
  "status": "fail",
  "data": {
    "authorization": false
  }
}
 */