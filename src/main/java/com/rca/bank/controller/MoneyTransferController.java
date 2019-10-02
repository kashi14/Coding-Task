package com.rca.bank.controller;
import static spark.Spark.*;

import com.rca.bank.serviceimpl.AccountServiceImpl;
import com.rca.bank.serviceimpl.TransferServiceImpl;

/**
 * 
 * @author theone
 *
 */
public class MoneyTransferController {

	public static TransferServiceImpl transfer=new TransferServiceImpl();
	public static AccountServiceImpl account=new AccountServiceImpl();

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		post("/account", account.setupAccount);
		get("/accounts", account.accountList);
		get("/account/:id", account.getAccount);

		post("/transfer", transfer.transfer);
		get("/transfers", transfer.transferList);
		get("/transfer/:id", transfer.getTranfer);

		System.out.println("Rregistering services...");

	}
}
