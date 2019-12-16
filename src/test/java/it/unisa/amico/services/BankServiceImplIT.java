package it.unisa.amico.services;

import it.unisa.amico.dao.BankAccountDao;
import it.unisa.amico.domain.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class BankServiceImplIT {

    /**
     * Class under test
     */
    @Autowired
    BankServiceImpl bankService;

    /**
     * Needed to setup DB
     */
    @Autowired
    BankAccountDao bankAccountDao;

    @BeforeEach
    void setUp() {
        bankAccountDao.deleteAll();
    }

    @Test
    void getAllBankAccounts() {
        bankAccountDao.save(new BankAccount("Test1", 10.0));
        bankAccountDao.save(new BankAccount("Test2", 10.0));
        List<BankAccount> accounts = bankService.getAllBankAccounts();
        System.out.println(accounts);
        assertEquals(2, accounts.size());
    }

    @Test
    void createBankAccount() {
        BankAccount newAccount = new BankAccount("Emanuele", 100.0);
        BankAccount returnedAccount = bankService.createBankAccount(newAccount);
        System.out.println(bankAccountDao.findAll());
        assertEquals(returnedAccount, newAccount);
    }

    @Test
    void getBankAccount() {
    }

    @Test
    void withdraw() {
    }

    @Test
    void deposit() {
    }

    @Test
    void transfer() {
    }
}