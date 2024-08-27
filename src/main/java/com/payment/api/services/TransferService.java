package com.payment.api.services;

import com.payment.api.dtos.TransferDTO;
import com.payment.api.entities.Transfer;
import com.payment.api.entities.Wallet;
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
        Wallet payer = walletService.findById(obj.getPayer());
        Wallet payee = walletService.findById(obj.getPayee());

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
