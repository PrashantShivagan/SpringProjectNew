package com.cg.springass2.Service;

import java.util.List;

import com.cg.springass2.Dto.PrintTransactions;
import com.cg.springass2.Dto.Trainee;
import com.cg.springass2.Exception.BankException;
import com.cg.springass2.Exception.InvalidAmount;
import com.cg.springass2.Exception.InvalidPhoneNumber;


public interface TraineeService {
	public Trainee createAccount(Trainee c) throws BankException;
	public double showBalance (String mobileno) throws InvalidPhoneNumber, BankException;
	public Trainee fundTransfer (String sourceMobileNo,String targetMobileNo, double amount) throws BankException;
	public Trainee depositAmount (String mobileNo, double amount ) throws InvalidPhoneNumber, InvalidAmount, BankException;
	public Trainee withdrawAmount(String mobileNo, double amount) throws BankException;
	public List<PrintTransactions> getTransactions(String mobileNo) throws BankException, InvalidPhoneNumber;
}
