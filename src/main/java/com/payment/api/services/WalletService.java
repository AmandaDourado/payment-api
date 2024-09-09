package com.payment.api.services;

import com.payment.api.entities.Wallet;
import com.payment.api.exceptions.UserNotFoundException;
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
        Wallet wallet = walletRepository.findByCpfCnpj(obj.getCpfCnpj());
        if(wallet != null) {
            throw new IllegalArgumentException("There is already a registered user with this CPF/CNPJ!");
        }

        return walletRepository.save(obj);
    }

    public Wallet findById(Long id) throws Exception {
        Optional<Wallet> optionalWallet = walletRepository.findById(id);
        if (optionalWallet.isEmpty()) {
            throw new UserNotFoundException();
        }

        return optionalWallet.get();
    }

    public List<Wallet> findAll(){
        List<Wallet> listWallet = walletRepository.findAll();
        return listWallet;
    }

}
