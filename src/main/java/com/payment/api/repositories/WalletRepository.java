package com.payment.api.repositories;

import com.payment.api.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WalletRepository  extends JpaRepository<Wallet,Long> {

    @Query("SELECT u FROM Wallet u WHERE u.cpfCnpj = :cpfcnpj")
    Wallet findbyCpfCnpj(@Param("cpfcnpj") String cpfcnpj);
}
