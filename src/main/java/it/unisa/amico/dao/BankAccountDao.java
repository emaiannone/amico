package it.unisa.amico.dao;

import it.unisa.amico.domain.BankAccount;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BankAccountDao extends CrudRepository<BankAccount, Long> {
    @Override
    Optional<BankAccount> findById(Long aLong);

    @Override
    List<BankAccount> findAll();

    @Override
    List<BankAccount> findAllById(Iterable<Long> iterable);
}