package com.cg.springass2.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.springass2.Dao.TraineeDao;
import com.cg.springass2.Dao.TraineeDaoImpl;
import com.cg.springass2.Dto.PrintTransactions;
import com.cg.springass2.Dto.Trainee;
import com.cg.springass2.Exception.BankException;
import com.cg.springass2.Exception.InvalidAmount;
import com.cg.springass2.Exception.InvalidPhoneNumber;


@Service("traineeservice")
@Transactional
public class TraineeServiceImpl implements TraineeService {
	@Autowired
	TraineeDao traineedao;
	public TraineeServiceImpl() {

		traineedao = new TraineeDaoImpl();
	}
	@Override
	public Trainee createAccount(Trainee c) throws BankException {
		// TODO Auto-generated method stub
		Trainee create = traineedao.createAccount(c);
		
		if(create == null)
			throw new BankException("Mobile number doesn't exist");
		return create;
	}
	@Override
	public double showBalance(String mobileno) throws InvalidPhoneNumber,
			BankException {
		// TODO Auto-generated method stub
		String tranType = "Check balance";
		Trainee bal = traineedao.getAccount(mobileno);
		if (bal == null)
			throw new BankException("Mobile number doesn't exist");
		traineedao.loadTransaction(new PrintTransactions(mobileno, tranType, bal.getBal()));
		return bal.getBal();
	
	}
	@Override
	public Trainee fundTransfer(String sourceMobileNo, String targetMobileNo,
			double amount) throws BankException {
		// TODO Auto-generated method stub
		String tranType = "Transfer";
		Trainee sbal = traineedao.getAccount(sourceMobileNo);
		Trainee tbal = traineedao.getAccount(targetMobileNo);
		if (sbal == null)
			throw new BankException("Mobile number doesn't exist");
		if (tbal == null)
			throw new BankException("Mobile number doesn't exist");
		double tmp = (sbal.getBal()- amount);
		if (tmp >= 0) {
			traineedao.setAccount(targetMobileNo, tbal.getBal() + amount);
			traineedao.setAccount(sourceMobileNo, sbal.getBal() - amount);
		} else {
			throw new BankException(
					"Minimum balance of Rupees greater than zero should be available...");
		}
//		System.out.println(dao.getAccount(sourceMobileNo));
		traineedao.loadTransaction(new PrintTransactions(sourceMobileNo, tranType, -amount));
		traineedao.loadTransaction(new PrintTransactions(targetMobileNo, tranType, amount));
		return traineedao.getAccount(sourceMobileNo);
		
	}
	@Override
	public Trainee depositAmount(String mobileNo, double amount)
			throws InvalidPhoneNumber, InvalidAmount, BankException {
		System.out.println("hii");
		// TODO Auto-generated method stub
		String tranType = "Deposit";
		Trainee cDep1 = traineedao.getAccount(mobileNo);
		System.out.println(cDep1.getBal());
		if (cDep1 == null)
			throw new BankException("Mobile number doesn't exist");
		boolean c = traineedao.setAccount(mobileNo, cDep1.getBal() + amount);
System.out.println(c);
		
		Trainee cDep = traineedao.getAccount(mobileNo);
		traineedao.loadTransaction(new PrintTransactions(mobileNo, tranType, amount));
		if (!c)
			throw new BankException("Unable to deposit");
		else
			return cDep;
		

	}
	@Override
	public Trainee withdrawAmount(String mobileNo, double amount)
			throws BankException {
		// TODO Auto-generated method stub
		String tranType = "Withdraw";
		boolean c = false;
		Trainee cDep1 = traineedao.getAccount(mobileNo);
		if (cDep1 == null)
			throw new BankException("Mobile number doesn't exist");
		if ((cDep1.getBal() - amount) >= 0)
			c = traineedao.setAccount(mobileNo, cDep1.getBal() - amount);
		Trainee cDep = traineedao.getAccount(mobileNo);
		traineedao.loadTransaction(new PrintTransactions(mobileNo, tranType, amount));
		if (!c)
			throw new BankException("Unable to withdraw");
		else
			return cDep;
		
	}
	@Override
	public List<PrintTransactions> getTransactions(String mobileNo)
			throws BankException, InvalidPhoneNumber {
		// TODO Auto-generated method stub
		
		if(traineedao.getAccount(mobileNo) == null)
			throw new BankException("Mobile number doesn't exist");
		
		List<PrintTransactions> list = null;
		
		list = traineedao.getTransactions(mobileNo);
		
		return list;
		
	}
	
	
}
