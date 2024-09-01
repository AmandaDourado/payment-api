package com.payment.api.authorizer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.coyote.Response;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
public class AuthorizerAPIQuery {

    private String url = "https://util.devi.tools/api/v2/authorize";

    public AuthorizeDTO authorizerQuery() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Application");
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            ObjectMapper objectMapper = new ObjectMapper();
            AuthorizeDTO authorizeDTO = objectMapper.readValue(response.getBody(), AuthorizeDTO.class);
            return authorizeDTO;

        } catch (HttpStatusCodeException e) {
            AuthorizeDTO errorDTO = new AuthorizeDTO();
            errorDTO.setStatus(e.getStatusCode().toString());
            errorDTO.getData().setAuthorization(false);
            return errorDTO;

        } catch (Exception e) {
            e.printStackTrace();
            AuthorizeDTO errorDTO = new AuthorizeDTO();
            errorDTO.setStatus("fail");
            errorDTO.getData().setAuthorization(false);
            return errorDTO;
        }
    }
}
