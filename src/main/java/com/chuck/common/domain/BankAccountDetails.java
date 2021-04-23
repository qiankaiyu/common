package com.chuck.common.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity(name = "BankAccountDetails")
@Table(name = "bank_account_details")
@Data
public class BankAccountDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private int accountId;

	@Column(name = "balance_amount")
	private int balanceAmount;

	@Column(name = "last_transaction_ts")
	private Date lastTransactionTimestamp;

}
