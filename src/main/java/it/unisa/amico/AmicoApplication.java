package it.unisa.amico;

import it.unisa.amico.domain.BankAccount;
import it.unisa.amico.services.BankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AmicoApplication {

    private static final Logger log = LoggerFactory.getLogger(AmicoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AmicoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BankService bankService) {
        return args -> {
            log.info("Creating two bank account");
            log.info("----------");

            bankService.createBankAccount(new BankAccount("Emanuele", 100.0));
            bankService.createBankAccount(new BankAccount("Manuel", 10000.0));
            List<BankAccount> accounts = bankService.getAllBankAccounts();

            log.info("List of bank accounts");
            log.info("----------");
            log.info(accounts.toString());

            try {
                bankService.transfer(accounts.get(0).getId(), accounts.get(1).getId(), 10.0);
            } catch (Exception e) {
                e.printStackTrace();
            }
            accounts = bankService.getAllBankAccounts();

            log.info("Updated list of bank accounts");
            log.info("----------");
            log.info(accounts.toString());
        };
    }
}
