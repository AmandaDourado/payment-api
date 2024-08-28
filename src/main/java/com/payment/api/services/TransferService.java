package com.payment.api.services;

import com.payment.api.dtos.TransferDTO;
import com.payment.api.entities.Transfer;
import com.payment.api.entities.Wallet;
import com.payment.api.enums.UserType;
import com.payment.api.repositories.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransferService {

    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private WalletService walletService;

    public Transfer create(TransferDTO obj) throws Exception {
        if(obj.getValue() <= 0){
            throw new IllegalArgumentException("The value must be greater than zero");
        }

        if(obj.getPayee() == obj.getPayer()) {
            throw new IllegalArgumentException("The payer and the payee cannot be the same person in a bank transfer");
        }

        Wallet payer = walletService.findById(obj.getPayer());
        Wallet payee = walletService.findById(obj.getPayee());

        if(payer.getUserType().equals(UserType.SHOPKEEPER)) {
            throw new IllegalArgumentException("Shopkeeper is not authorized to make transfers");
        }

        if(payer.getBalance() < obj.getValue()) {
            throw new IllegalArgumentException("The payer has insufficient balance");
        }

        payer.setBalance(payer.getBalance() - obj.getValue());
        payee.setBalance(payee.getBalance() + obj.getValue());

        Transfer transfer = new Transfer();
        transfer.setValue(obj.getValue());
        transfer.setPayer(payer);
        transfer.setPayee(payee);

        return transferRepository.save(transfer);
    }

    public Transfer findById(Long id) throws Exception {
        Optional<Transfer> optionalTransfer = transferRepository.findById(id);
        if (optionalTransfer.isEmpty()) {
            throw new Exception("Transfer not found");
        }

        return optionalTransfer.get();
    }

    public List<Transfer> findAll(){
        List<Transfer> listTranfer = transferRepository.findAll();
        return listTranfer;
    }
}
