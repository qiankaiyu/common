//package com.chuck.common.service.impl;
//
//import com.chuck.common.domain.FixedDepositDetails;
//import com.chuck.common.repository.BankAccountDao;
//import com.chuck.common.repository.FixedDepositDao;
//import com.chuck.common.service.FixedDepositService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service(value = "fixedDepositService")
//public class FixedDepositServiceImpl implements FixedDepositService {
//
//	@Autowired
//	private FixedDepositDao myFixedDepositDao;
//
//	@Autowired
//	private BankAccountDao bankAccountDao;
//
//	@Override
//	@Transactional
//	public int createFixedDeposit(FixedDepositDetails fdd) throws Exception {
//		// -- create fixed deposit
//		bankAccountDao.subtractFromAccount(fdd.getBankAccountId().getAccountId(), fdd.getFdAmount());
//		return myFixedDepositDao.createFixedDeposit(fdd);
//	}
//
//	@Override
//	@Transactional
//	public FixedDepositDetails getFixedDeposit(int fixedDepositId) {
//		return myFixedDepositDao.getFixedDeposit(fixedDepositId);
//	}
//}
