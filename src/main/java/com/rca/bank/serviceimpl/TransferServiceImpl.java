package com.rca.bank.serviceimpl;

import java.math.BigDecimal;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rca.bank.datastore.serviceImpl.DataStore;
import com.rca.bank.domain.Account;
import com.rca.bank.domain.Transaction;

import spark.Route;

public class TransferServiceImpl {

	private final Gson gson = new GsonBuilder().create();

	/**
	 * 
	 */
	public Route transfer=(req, res)->{

		String amount =req.queryParams("amount");
		String fromAcc=req.queryParams("fromAcc");
		String tomAcc=req.queryParams("toAcc");
		Transaction transaction= setupTransaction( fromAcc,tomAcc, amount);
		res.status(201);
		res.type("application/json");
		return gson.toJson(transaction);

	};

	/**
	 * 
	 */
	public  Route transferList=(req, res)->{
		res.status(201);
		res.type("application/json");
		return gson.toJson(DataStore.getInstance().getAllTrans());


	};

	/**
	 * 
	 */
	public  Route getTranfer=(req, res)->{
		String id= req.params("id");
		Transaction trans =getTrans(id.trim());
		if (trans == null) {
			res.status(400);
			res.type("application/json");
			return gson.toJson("No transaction found "+id);
		}
		res.status(201);
		res.type("application/json");
		return gson.toJson(trans);

	};

	/**
	 * 
	 * @param fromAcc
	 * @param tomAcc
	 * @param amount
	 * @return
	 */
	public  Transaction setupTransaction(String fromAcc, String tomAcc, String amount) {
		if (amount == null ||  fromAcc == null ||tomAcc == null ) {

			throw new IllegalArgumentException("Please check all inputs are required - fromAcc, toAcc, amount");
		}
		if (fromAcc.equals(tomAcc)) {
			throw new IllegalArgumentException("Source and target account numbers must be different");
		}

		Account sender = getAccount(fromAcc.trim());
		Account recipient = getAccount(tomAcc.trim());

		BigDecimal transAmount=new BigDecimal(amount);
		if (sender.getAccBalance().compareTo(transAmount) < 0) {
			throw new IllegalArgumentException("Account " + sender.getAccNumber() + " has insufficient funds (req: " + transAmount + "; actual: " + sender.getAccBalance());
		}

		sender.setAccBalance(sender.getAccBalance().subtract(transAmount));
		recipient.setAccBalance(recipient.getAccBalance().add(transAmount));
		return create(sender.getAccNumber(),recipient.getAccNumber(),transAmount);

	}

	/**
	 * 
	 * @param transID
	 * @return
	 */
	private  Transaction getTrans(String transID) {
		return DataStore.getInstance().findByTransId(Long.valueOf(transID))
				.orElseThrow(() -> new IllegalArgumentException("Transaction " + transID + " not found!"));
	}

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
	 * @param sourceAcc
	 * @param destinationAcc
	 * @param amount
	 * @return
	 */
	private  Transaction create(Long sourceAcc, Long destinationAcc, BigDecimal amount) {
		Transaction transaction = new Transaction(AccountServiceImpl.getNumber(9), sourceAcc, destinationAcc, amount);
		DataStore.getInstance().saveOrUpdate(transaction);
		return transaction;
	}

}
