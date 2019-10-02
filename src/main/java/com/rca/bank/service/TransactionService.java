/**
 * 
 */
package com.rca.bank.service;

import java.util.function.BiConsumer;

import com.rca.bank.domain.Account;

/**
 * @author kashi
 *
 */
public interface TransactionService {
	public interface AccountTransactionService {

	    void transferNow(Account account1, Account account2, BiConsumer<Account, Account> action);
	}

}
