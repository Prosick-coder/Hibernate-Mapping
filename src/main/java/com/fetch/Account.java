package com.fetch;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Account {

	private String bankName;
	@Id
	private int AccNo;
	@ManyToOne
	private Employee emp;
	
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public int getAccNo() {
		return AccNo;
	}
	public void setAccNo(int accNo) {
		AccNo = accNo;
	}
	
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	public Account(String bankName, int accNo) {
		super();
		this.bankName = bankName;
		AccNo = accNo;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Account [bankName=" + bankName + ", AccNo=" + AccNo + ", emp=" + emp + "]";
	}
	
	
	
}
