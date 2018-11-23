package com.cg.springass2.Controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;



import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import org.springframework.web.servlet.ModelAndView;

import com.cg.springass2.Dto.PrintTransactions;
import com.cg.springass2.Dto.Trainee;
import com.cg.springass2.Exception.BankException;
import com.cg.springass2.Exception.InvalidAmount;
import com.cg.springass2.Exception.InvalidPhoneNumber;
import com.cg.springass2.Service.TraineeService;

@Controller
public class TraineeController {
	@Autowired
	TraineeService traineeservice;
	//@RequestMapping(value="CreateAccount")
	//public String login(){
		//return "Createaccount";
		
	//}
	
	@RequestMapping(value="CreateAccount")
	public String menu(@ModelAttribute("y") Trainee trainee){
		return "Createaccount";
	}
	
	@RequestMapping(value = "adddata", method = RequestMethod.POST)
	public ModelAndView addCustomerNow(@ModelAttribute("y") Trainee trainee) {
		String res = null;
		System.out.println(trainee);
		try {
			traineeservice.createAccount(trainee);
			res = "Account was created successfully!!!";
		} catch (BankException e) {
			// TODO Auto-generated catch block
			res = e.getMessage();
		}
		return new ModelAndView("welcome", "result", res);
	}
	
	
	@RequestMapping(value = "DepositAmount")
	public String deposit(@ModelAttribute("z") Trainee trainee) {
		return "Depositamount";
	}

	@RequestMapping(value = "depdata", method = RequestMethod.POST)
	public ModelAndView depositNow(@ModelAttribute("z") Trainee trainee) {
		System.out.println("hi");
		String res = null;
		try {
			System.out.println(trainee.getMobileno());
			Trainee customer = traineeservice.depositAmount(trainee.getMobileno(), trainee.getBal());
			res = "Your current balance is "+trainee.getBal();
			System.out.println(res);
		} catch (InvalidPhoneNumber e) {
			// TODO Auto-generated catch block
			res = e.getMessage();
		} catch (InvalidAmount e) {
			// TODO Auto-generated catch block
			res = e.getMessage();
		} catch (BankException e) {
			// TODO Auto-generated catch block
			res = e.getMessage();
		}
		return new ModelAndView("welcome1", "result", res);
	}
	
	
	@RequestMapping(value = "ShowBalance")
	public String showBalance(@ModelAttribute("f") Trainee trainee) {
		return "showBalance";
	}
	
	@RequestMapping(value = "shodata", method = RequestMethod.POST)
	public ModelAndView showBalanceNow(@ModelAttribute("f") Trainee trainee) {
		double balance = 0;
		String res = "Nothing updated :(";
		try {
			balance = traineeservice.showBalance(trainee.getMobileno());
			res = "Your current balance is "+balance;
		} catch (InvalidPhoneNumber | BankException e) {
			res = e.getMessage();
		}
		return new ModelAndView("welcome4", "result", res);
	}
	
	@RequestMapping(value = "FundTransfer")
	public String funds(@ModelAttribute("s") Trainee trainee) {
		return "funds";
	}
	
	@RequestMapping(value = "fundata", method = RequestMethod.POST)
	public ModelAndView fundsTransferNow(@ModelAttribute("s") Trainee trainee) {
		String res = null;
		String[] mobile = trainee.getMobileno().split(",");
		for(String s : mobile)
			System.out.println(s);
		try {
			Trainee customer = traineeservice.fundTransfer(mobile[0], mobile[1], trainee.getBal());
			res = "Your current balance is "+customer.getBal();
		} catch (BankException e) {
			// TODO Auto-generated catch block
			res = e.getMessage();
		}
		return new ModelAndView("welcome3", "result", res);
	}
	
	

	@RequestMapping(value = "Withdraw")
	public String withdraw(@ModelAttribute("e") Trainee trainee) {
		return "Withdrawamount";
	}
	
	@RequestMapping(value = "withdata", method = RequestMethod.POST)
	public ModelAndView withdrawNow(@ModelAttribute("e") Trainee trainee) {
		String res = null;
		try {
			Trainee customer = traineeservice.withdrawAmount(trainee.getMobileno(), trainee.getBal());
			res = "Your current balance is "+customer.getBal();
		} catch (BankException e) {
			// TODO Auto-generated catch block
			res = e.getMessage();
		}
		return new ModelAndView("welcome2", "result", res);
	}
	
	@RequestMapping(value = "PrintTrans")
	public String print(@ModelAttribute("k") PrintTransactions printTran) {
		return "printTransactions";
	}
	
	@RequestMapping(value = "printdata", method = RequestMethod.POST)
	public ModelAndView printNow(@ModelAttribute("k") PrintTransactions printTran) {
		String res = null;
		List<PrintTransactions> list = null;
		try {
			list = traineeservice.getTransactions(printTran.getMobileNumber());
		} catch (BankException e) {
			// TODO Auto-generated catch block
			res = e.getMessage();
		} catch (InvalidPhoneNumber e) {
			// TODO Auto-generated catch block
			res = e.getMessage();
		}
		return new ModelAndView("Transaction", "result", list);
	}
}

