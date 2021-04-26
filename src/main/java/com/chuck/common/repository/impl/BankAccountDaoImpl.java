//package com.chuck.common.repository.impl;
//
//import com.chuck.common.domain.BankAccountDetails;
//import com.chuck.common.repository.BankAccountDao;
//
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//@Repository(value = "bankAccountDao")
//public class BankAccountDaoImpl implements BankAccountDao {
//	@Autowired
//	private SessionFactory sessionFactory;
//
//	@Override
//	public int createBankAccount(final BankAccountDetails bankAccountDetails) {
//		sessionFactory.getCurrentSession().save(bankAccountDetails);
//		return bankAccountDetails.getAccountId();
//	}
//
//	@Override
//	public void subtractFromAccount(int bankAccountId, int amount) {
//		String hql = "from BankAccountDetails as bankAccountDetails where bankAccountDetails.accountId ="
//				+ bankAccountId;
//		BankAccountDetails bankAccountDetails = (BankAccountDetails) sessionFactory.getCurrentSession().createQuery(hql)
//				.uniqueResult();
//		bankAccountDetails.setBalanceAmount(bankAccountDetails.getBalanceAmount() - amount);
//		sessionFactory.getCurrentSession().merge(bankAccountDetails);
//	}
//}
