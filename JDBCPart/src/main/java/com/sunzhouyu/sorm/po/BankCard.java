package com.sunzhouyu.sorm.po;

import java.sql.*;
import java.util.*;

public class BankCard {

	private String UserId;
	private String BankAccount;
	private Integer Id;
	private String BankOwner;


	public String getUserId(){
		return UserId;
	}
	public String getBankAccount(){
		return BankAccount;
	}
	public Integer getId(){
		return Id;
	}
	public String getBankOwner(){
		return BankOwner;
	}
	public void setUserId(String UserId){
		this.UserId=UserId;
	}
	public void setBankAccount(String BankAccount){
		this.BankAccount=BankAccount;
	}
	public void setId(Integer Id){
		this.Id=Id;
	}
	public void setBankOwner(String BankOwner){
		this.BankOwner=BankOwner;
	}
}
