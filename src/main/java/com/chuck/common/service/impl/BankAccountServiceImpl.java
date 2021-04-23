package com.chuck.common.service.impl;

import com.chuck.common.domain.BankAccountDetails;
import com.chuck.common.repository.BankAccountDao;
import com.chuck.common.service.BankAccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "bankAccountService")
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	private BankAccountDao bankAccountDao;

	@Override
	@Transactional
	public int createBankAccount(BankAccountDetails bankAccountDetails) {
		return bankAccountDao.createBankAccount(bankAccountDetails);
	}

}
