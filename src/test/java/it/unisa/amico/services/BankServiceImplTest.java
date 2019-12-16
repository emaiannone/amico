package it.unisa.amico.services;

import it.unisa.amico.dao.BankAccountDao;
import it.unisa.amico.domain.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class BankServiceImplTest {

    /**
     * Class under test that received the mocks
     */
    @InjectMocks
    BankServiceImpl bankService;

    /**
     * Mocked class for testing BankService in isolation
     */
    @Mock
    BankAccountDao bankAccountDao;

    @BeforeEach
    void setUp() {

    }

    @Test
    void getAllBankAccounts() {
        when(bankAccountDao.findAll()).thenReturn(new ArrayList<>());
        List<BankAccount> accounts1 = bankService.getAllBankAccounts();
        // assertFalse(accounts1.isEmpty());
        assertTrue(accounts1.isEmpty());
    }

    @Test
    void createBankAccount() {
        BankAccount newAccount = new BankAccount("Emanuele", 100.0);
        when(bankAccountDao.save(newAccount)).thenReturn(newAccount);
        BankAccount returnedAccount = bankService.createBankAccount(newAccount);
        assertEquals(returnedAccount, newAccount);
    }

    @Test
    void getBankAccount() {
        fail();
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