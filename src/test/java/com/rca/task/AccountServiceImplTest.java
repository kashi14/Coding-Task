package com.rca.task;

import java.math.BigDecimal;

import com.rca.bank.domain.Account;
import com.rca.bank.service.AccountService;
import com.rca.bank.serviceimpl.AccountServiceImpl;
import com.rca.bank.serviceimpl.TransferServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.hamcrest.Matcher;
import org.hamcrest.core.Is;

/**
 * 
 * @author kashi
 *
 */
public class AccountServiceImplTest {
	
	public static final BigDecimal BALANCE = BigDecimal.valueOf(10000.00);
    public static final BigDecimal AMOUNT = BigDecimal.valueOf(1000.00);
    TransferServiceImpl transfer = new TransferServiceImpl();

    @Test
    public void testTransfer() throws Exception {
        Account source = new Account("1", BALANCE);
        Account destination = new Account("2", BALANCE);

        transfer.setupTransaction(source, destination, AMOUNT);

        Assert.assertThat(source.getAccBalance(), Is.is(BALANCE - AMOUNT));
        Assert.assertThat(destination.getAccBalance(), Is.is(BALANCE + AMOUNT));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTransferToTheSameAccount() {
        Account account = new Account("1", BALANCE);

        transfer.setupTransaction(account, account, AMOUNT);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTransferAmountGreaterThanBalance() {
        Account source = new Account("1", BALANCE);
        Account destination = new Account("2", BALANCE);

        transfer.setupTransaction(source, destination, BALANCE * 2);
    }
}
