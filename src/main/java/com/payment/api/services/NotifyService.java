package com.payment.api.services;

import com.payment.api.integration.NotifyAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotifyService {

    @Autowired
    private NotifyAPI notifyAPI;

    public void notifyPayment() {
        System.out.println(notifyAPI.notifyQuery().getMessage());
    }
}
