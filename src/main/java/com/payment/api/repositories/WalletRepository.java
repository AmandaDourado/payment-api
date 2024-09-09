package com.payment.api.repositories;

import com.payment.api.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet,Long> {

    Wallet findByCpfCnpj(String cpfCnpj);
}
