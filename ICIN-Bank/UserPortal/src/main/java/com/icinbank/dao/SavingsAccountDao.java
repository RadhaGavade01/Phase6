package com.icinbank.dao;

import com.icinbank.domain.SavingsAccount;
import org.springframework.data.repository.CrudRepository;


public interface SavingsAccountDao extends CrudRepository<SavingsAccount, Long> {

    SavingsAccount findByAccountNumber (int accountNumber);

}
