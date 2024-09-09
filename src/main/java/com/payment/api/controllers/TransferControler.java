package com.payment.api.controllers;

import com.payment.api.dtos.TransferDTO;
import com.payment.api.entities.Transfer;
import com.payment.api.services.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transfer")
public class TransferControler {

    @Autowired
    private TransferService transferService;

    @PostMapping()
    public ResponseEntity create(@RequestBody TransferDTO transfer) throws Exception {
        Transfer obj = transferService.create(transfer);
        return new ResponseEntity<>("Transfer successfully! ID: " + obj.getId(), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity findById(@PathVariable(value = "id") Long id) throws Exception {
        return new ResponseEntity<>(transferService.findById(id), HttpStatus.OK);
    }

    @GetMapping()
    public List<Transfer> findAll() {
        return transferService.findAll();
    }
}
