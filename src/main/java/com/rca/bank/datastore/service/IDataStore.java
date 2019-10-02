package com.rca.bank.datastore.service;

import java.util.Collection;
import java.util.Optional;

import com.rca.bank.domain.Account;
import com.rca.bank.domain.Transaction;

/**
 * 
 * @author kashi
 *
 */
public interface IDataStore {
	
	/**
	 * 
	 * @return
	 */
	Collection<Account> getAll();
    Account getAccountById(Long accountNumber);
    Optional<Account> findByAccountNumber(Long accountNumber);
    Account saveOrUpdate(Account account);
    void delete(Account account);

	
	Collection<Transaction> getAllTrans();
	Transaction saveOrUpdate(Transaction trans);
	Optional<Transaction> findByTransId(Long accountNumber);
	Transaction findByTransId1(Long transID);
    
}
