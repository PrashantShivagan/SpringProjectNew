package com.cg.springass2.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cg.springass2.Dto.PrintTransactions;
import com.cg.springass2.Dto.Trainee;
import com.cg.springass2.Exception.BankException;
import com.cg.springass2.Exception.InvalidPhoneNumber;


@Repository("traineedao")
public class TraineeDaoImpl implements TraineeDao {
	@PersistenceContext
	EntityManager em;

	@Override
	public Trainee createAccount(Trainee c) throws BankException {
		// TODO Auto-generated method stub
		em.persist(c);
		em.flush();
		return c;
	}

	@Override
	public Trainee getAccount(String mobileno) {
		// TODO Auto-generated method stub
		 Trainee c=em.find(Trainee.class, mobileno);
		 System.out.println(c);
		 return c;
		
	}

	@Override
	public boolean setAccount(String mobileNo, double amount) {
		// TODO Auto-generated method stub
		Trainee cShow = em.find(Trainee.class, mobileNo);
		cShow.setBal(amount);
		em.merge(cShow);
		return true;
	}

	@Override
	public List<PrintTransactions> getTransactions(String mobileNo)
			throws BankException, InvalidPhoneNumber {
		// TODO Auto-generated method stub
		List<PrintTransactions> tranList = null;
		Query query = em.createQuery("from PrintTransactions where mobileNumber = :mobNo");
		query.setParameter("mobNo", mobileNo);
		tranList = query.getResultList();
		if(tranList.isEmpty())
			throw new BankException("No transactions are made yet");
		return tranList;
	}

	@Override
	public void loadTransaction(PrintTransactions pt) {
		// TODO Auto-generated method stub
		em.persist(pt);
	}
}
