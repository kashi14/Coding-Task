package com.rca.bank.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 
 * @author kashi
 *
 */
public class Transaction {
	
	private Long transId;
	private Long fromAccount;
    private Long toAccount;
    private BigDecimal amount;
    private String date;
    private String transactionType="Bank Transfer";
    
    
    /**
     * 
     */
    public Transaction() {
    }
    
	/**
	 * @param fromAccount
	 * @param toAccount
	 * @param amount
	 * @param date
	 */
	public Transaction(Long transId, Long fromAccount, Long toAccount, BigDecimal amount) {
		super();
		this.transId=transId;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.amount = amount;
		this.date = getDate();
	}

	

	/**
	 * @return the transId
	 */
	public Long getTransId() {
		return transId;
	}

	/**
	 * @param transId the transId to set
	 */
	public void setTransId(Long transId) {
		this.transId = transId;
	}

	/**
	 * @return the fromAccount
	 */
	public Long getFromAccount() {
		return fromAccount;
	}


	/**
	 * @param fromAccount the fromAccount to set
	 */
	public void setFromAccount(Long fromAccount) {
		this.fromAccount = fromAccount;
	}


	/**
	 * @return the toAccount
	 */
	public Long getToAccount() {
		return toAccount;
	}


	/**
	 * @param toAccount the toAccount to set
	 */
	public void setToAccount(Long toAccount) {
		this.toAccount = toAccount;
	}


	/**
	 * @return the date
	 */
	public String getDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}


	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * @return the transactionType
	 */
	public String getTransactionType() {
		return transactionType;
	}


	/**
	 * @param transactionType the transactionType to set
	 */
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

    

}
