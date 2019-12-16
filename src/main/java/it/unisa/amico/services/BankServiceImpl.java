package it.unisa.amico.services;

import it.unisa.amico.dao.BankAccountDao;
import it.unisa.amico.domain.BankAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BankServiceImpl implements BankService {

    private final BankAccountDao bankAccountDao;

    public BankServiceImpl(BankAccountDao bankAccountDao) {
        this.bankAccountDao = bankAccountDao;
    }

    @Override
    public List<BankAccount> getAllBankAccounts() {
        return null;/*ArrayList<>(bankAccountDao.findAll()*/
    }

    @Override
    public BankAccount createBankAccount(BankAccount account) {
        return bankAccountDao.save(account);
    }

    @Override
    public Optional<BankAccount> getBankAccount(Long id) {
        return bankAccountDao.findById(id);
    }

    @Override
    public Double withdraw(Long id, Double amount) throws IllegalArgumentException {
        Optional<BankAccount> bankAccount = getBankAccount(id);
        if (!bankAccount.isPresent()) {
            throw new IllegalArgumentException("Account not found");
        }
        BankAccount account = bankAccount.get();
        if (amount <= 0) {
            throw new IllegalArgumentException("Wrong amount");
        }
        if (account.getBalance() - amount < 0) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        account.setBalance(account.getBalance() - amount);
        bankAccountDao.save(account);
        return account.getBalance();
    }

    @Override
    public Double deposit(Long id, Double amount) throws IllegalArgumentException {
        Optional<BankAccount> bankAccount = getBankAccount(id);
        if (!bankAccount.isPresent()) {
            throw new IllegalArgumentException("Account not found");
        }
        BankAccount account = bankAccount.get();
        if (amount <= 0) {
            throw new IllegalArgumentException("Wrong amount");
        }
        account.setBalance(account.getBalance() + amount);
        bankAccountDao.save(account);
        return account.getBalance();
    }

    public void transfer(Long id1, Long id2, Double amount) {
        Optional<BankAccount> bankAccount1 = getBankAccount(id1);
        Optional<BankAccount> bankAccount2 = getBankAccount(id2);
        if (!bankAccount1.isPresent() || !bankAccount2.isPresent()) {
            throw new IllegalArgumentException("Account not found");
        }
        withdraw(id1, amount);
        deposit(id2, amount);
    }
}