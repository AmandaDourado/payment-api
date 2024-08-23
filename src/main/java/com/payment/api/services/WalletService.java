package com.payment.api.services;

import com.payment.api.entities.Wallet;
import com.payment.api.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    public Wallet create(Wallet obj) {
        Wallet wallet = walletRepository.findbyCpfCnpj(obj.getCpfCnpj());
        if(wallet != null) {
            throw new IllegalArgumentException("There is already a registered user with this CPF/CNPJ!");
        }

        return walletRepository.save(obj);
    }

    public Wallet findById(Long id) throws Exception {
        Wallet wallet = walletRepository.findById(id).get();
        if(wallet == null){
            throw new Exception("User not found");
        }

        return wallet;
    }

    public List<Wallet> findAll(){
        List<Wallet> listWallet = walletRepository.findAll();
        return listWallet;
    }

}
