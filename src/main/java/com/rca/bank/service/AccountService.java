/**
 * 
 */
package com.rca.bank.service;

import java.util.List;

import com.rca.bank.domain.Account;

/**
 * @author kashi
 *
 */
public interface AccountService {
	
	public List<Account> getAll();
    public Account getById(Long id);
    public String setUpAccount(Account account);
    void delete(Integer id);

}
