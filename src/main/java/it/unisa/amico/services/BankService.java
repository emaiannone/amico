package it.unisa.amico.services;

import it.unisa.amico.domain.BankAccount;

import java.util.List;
import java.util.Optional;

public interface BankService {

    List<BankAccount> getAllBankAccounts();

    BankAccount createBankAccount(BankAccount account);

    Optional<BankAccount> getBankAccount(Long id);

    Double withdraw(Long id, Double amount);

    Double deposit(Long id, Double amount);

    void transfer(Long id1, Long id2, Double amount);
}