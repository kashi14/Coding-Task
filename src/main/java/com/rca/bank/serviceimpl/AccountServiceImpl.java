package com.rca.bank.serviceimpl;

import java.math.BigDecimal;
import java.util.Random;
import javax.inject.Singleton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rca.bank.datastore.serviceImpl.DataStore;
import com.rca.bank.domain.Account;
import spark.Route;

/**
 * 
 * @author Kashi
 *
 */
@Singleton

public class AccountServiceImpl {

	private final Gson gson = new GsonBuilder().create();
	/**
	 * 
	 */
	public  Route setupAccount=(req, res)->{

		String Custname=req.queryParams("custName");
		String openingBal=req.queryParams("bal");
		failIfInvalid(Custname,openingBal);
	 	Account acc=new Account();
		acc.setCustName(Custname);
		acc.setAccBalance(new BigDecimal(openingBal));
		if (acc.getCustName()!=null) {
			acc.setAccNumber(getNumber(7));
			acc.setSorCode(getNumber(4));
		}
		DataStore.getInstance().saveOrUpdate(acc);
		res.status(201);
		res.type("application/json");
		return gson.toJson(acc);
	};

	/**
	 * 
	 */
	public  Route accountList=(req, res)->{

		res.status(201);
		res.type("application/json");
		return gson.toJson(DataStore.getInstance().getAll());
	};
	
	/**
	 * 
	 */
	public  Route getAccount=(req, res)->{

		String id= req.params("id");
		Account acc =getAccount(id.trim());
		if (acc == null) {
			res.status(400);
			res.type("application/json");
			return gson.toJson("No user found with account number "+id);
		}
		res.status(201);
		res.type("application/json");
		return gson.toJson(acc);	
	};
 
	/**
	 * 
	 * @param accountNum
	 * @return
	 */
	private  Account getAccount(String accountNum) {
		  return DataStore.getInstance().findByAccountNumber(Long.valueOf(accountNum))
         .orElseThrow(() -> new IllegalArgumentException("Account " + accountNum + " not found!"));
    }
	/**
	 * 
	 * @param n
	 * @return
	 */
	public static Long getNumber(int n) {
		int m = (int) Math.pow(10, n - 1);
	   return Long.valueOf(m + new Random().nextInt(9 * m));
	}
	
	/**
	 * 
	 * @param name
	 * @param bal
	 */
	private  void failIfInvalid(String name, String bal) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Parameter 'Customer name' cannot be empty");
		}
		if (bal == null || bal.isEmpty()) {
			throw new IllegalArgumentException("Parameter 'opening bal' cannot be empty");
		}
	}

}
