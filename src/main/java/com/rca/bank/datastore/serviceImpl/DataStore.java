package com.rca.bank.datastore.serviceImpl;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import javax.inject.Singleton;

import com.rca.bank.datastore.service.IDataStore;
import com.rca.bank.domain.Account;
import com.rca.bank.domain.Transaction;

/**
 * 
 * @author kashi
 *
 */
@Singleton
public class DataStore implements IDataStore {

    private  final Map<Long, Account> accStorage = new ConcurrentHashMap<>();
    private  final Map<Long, Transaction> transStorage = new ConcurrentHashMap<>();
       
    private static DataStore sSoleInstance;

    private DataStore(){}  //private constructor.
   
    @Override
    public Collection<Account> getAll() {
        return accStorage.values();
    }

    @Override
    public Account getAccountById(Long accountNumber) {
          return accStorage.get(accountNumber);
    }

    @Override
    public Account saveOrUpdate(Account account) {
    	return accStorage.put(account.getAccNumber(), account);
    }

    @Override
    public void delete(Account account) {
    	accStorage.remove(account.getAccNumber());
    }
    
    @Override
    public Optional<Account> findByAccountNumber(Long accountNumber) {
        return Optional.ofNullable(accStorage.get(accountNumber));
    }  
    
    //Transaction details
    
    @Override
    public Collection<Transaction> getAllTrans() {
        return transStorage.values();
    }
    
    @Override
    public Optional<Transaction> findByTransId(Long transID) {
    	    	
        return Optional.ofNullable(transStorage.get(transID));
    }  
    @Override
    public Transaction findByTransId1(Long transID) { 
    return transStorage.get(transID);
    }
        
    @Override
	public Transaction saveOrUpdate(Transaction trans) {
		
		return transStorage.put(trans.getTransId(), trans);
	}
    
   
    public void clear() {
    	accStorage.clear();
    }

    public static IDataStore getInstance(){
        if (sSoleInstance == null){ //if there is no instance available... create new one
            sSoleInstance = new DataStore();
        }

        return sSoleInstance;
    }

	
}
