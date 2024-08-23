package com.payment.api.controllers;

import com.payment.api.entities.Wallet;
import com.payment.api.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @PostMapping()
    public ResponseEntity create(@RequestBody Wallet wallet){
        try{
            Wallet obj =  walletService.create(wallet);
            return new ResponseEntity<>("Wallet registered successfully! ID: " + obj.getId(), HttpStatus.CREATED);
        } catch (Exception error){
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/{id}")
    public Wallet findById(@PathVariable(value = "id") Long id) throws Exception {
        return walletService.findById(id);
    }

    @GetMapping()
    public List<Wallet> findAll() {
        return walletService.findAll();
    }
}
