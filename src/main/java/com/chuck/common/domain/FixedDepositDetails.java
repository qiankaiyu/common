//package com.chuck.common.domain;
//
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//import lombok.Data;
//
//@Entity(name = "FixedDepositDetails")
//@Table(name = "fixed_deposit_details")
//@Data
//public class FixedDepositDetails {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "fixed_deposit_id")
//	private int fixedDepositId;
//
//	@ManyToOne
//	@JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ACCOUNT_ID", nullable = false)
//	private BankAccountDetails bankAccountId;
//
//	@Column(name = "fd_creation_date")
//	private Date fdCreationDate;
//
//	@Column(name = "amount")
//	private int fdAmount;
//
//	@Column(name = "tenure")
//	private int tenure;
//
//	@Column(name = "active")
//	private String active;
//
//}