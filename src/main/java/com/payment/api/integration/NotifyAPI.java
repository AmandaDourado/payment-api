package com.payment.api.integration;

import com.payment.api.dtos.NotifyDTO;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
public class NotifyAPI {

    private final String url = "https://util.devi.tools/api/v1/notify";

    public NotifyDTO notifyQuery() {
        NotifyDTO notifyDTO = new NotifyDTO();

        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();

            headers.add("user-agent", "Application");
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<>(headers);
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

            if (response.getStatusCode() == HttpStatus.NO_CONTENT) {
                notifyDTO.setStatus(response.getStatusCode().toString());
                notifyDTO.setMessage("notification sent successfully");
            }

        } catch(HttpStatusCodeException e) {
            notifyDTO.setStatus(e.getStatusCode().toString());
            notifyDTO.setMessage("notification NOT sent, service unavailable");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return notifyDTO;
    }
}
