package com.rca.bank.domain;

import java.math.BigDecimal;

/**
 * 
 * @author kashi
 *
 */
public class Account {
	
	private String custId;
    private Long accNumber;
    private Long sorCode;
    private String custName;
    private BigDecimal accBalance;
    
    public Account() {}
    
    public Account( String custName, BigDecimal accBalance) {
		super();
		
		this.custName = custName;
		this.accBalance = accBalance;
	}
        
	/**
	 * @param custId
	 * @param accNumber
	 * @param sorCode
	 * @param custName
	 * @param accBalance
	 */
	public Account(Long accNumber, String custName, BigDecimal accBalance) {
		super();
		this.accNumber = accNumber;
		this.custName = custName;
		this.accBalance = accBalance;
	}

	/**
	 * @return the custId
	 */
	public String getCustId() {
		return custId;
	}

	/**
	 * @param custId the custId to set
	 */
	public void setCustId(String custId) {
		this.custId = custId;
	}

	
	/**
	 * @return the accNumber
	 */
	public Long getAccNumber() {
		return accNumber;
	}

	/**
	 * @param accNumber the accNumber to set
	 */
	public void setAccNumber(Long accNumber) {
		this.accNumber = accNumber;
	}

	

	/**
	 * @return the sorCode
	 */
	public Long getSorCode() {
		return sorCode;
	}

	/**
	 * @param sorCode the sorCode to set
	 */
	public void setSorCode(Long sorCode) {
		this.sorCode = sorCode;
	}

	/**
	
	/**
	 * @return the custName
	 */
	public String getCustName() {
		return custName;
	}

	/**
	 * @param custName the custName to set
	 */
	public void setCustName(String custName) {
		this.custName = custName;
	}

	/**
	 * @return the accBalance
	 */
	public BigDecimal getAccBalance() {
		return accBalance;
	}

	/**
	 * @param accBalance the accBalance to set
	 */
	public void setAccBalance(BigDecimal accBalance) {
		this.accBalance = accBalance;
	}

	@Override
	public String toString() {
		return "Account [custId=" + custId + ", accNumber=" + accNumber + ", sorCode=" + sorCode + ", custName="
				+ custName + ", accBalance=" + accBalance + "]";
	}
	public static class AccountBuilder {
        private Long accountId;
        private String accountHolderName;
        private BigDecimal balance;
       

        public static AccountBuilder builder() {
            return new AccountBuilder();
        }

        public AccountBuilder accountId(Long accountId) {
            this.accountId = accountId;
            return this;
        }

        public AccountBuilder accountHolderName(String accountHolderName) {
            this.accountHolderName = accountHolderName;
            return this;
        }

        public AccountBuilder balance(BigDecimal balance) {
            this.balance = balance;
            return this;
        }
        
        public Account build() {
            return new Account(accountId, accountHolderName, balance);
        }
    }
    
}
