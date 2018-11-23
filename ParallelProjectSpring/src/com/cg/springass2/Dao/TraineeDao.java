package com.cg.springass2.Dao;

import java.util.List;

import com.cg.springass2.Dto.PrintTransactions;
import com.cg.springass2.Dto.Trainee;
import com.cg.springass2.Exception.BankException;
import com.cg.springass2.Exception.InvalidPhoneNumber;



public interface TraineeDao {
	public Trainee createAccount(Trainee c) throws BankException;
	public Trainee getAccount(String mobileno);
	public boolean setAccount(String mobileNo, double amount);
	public List<PrintTransactions> getTransactions(String mobileNo) throws BankException, InvalidPhoneNumber;
	public void loadTransaction(PrintTransactions pt);

	
}
