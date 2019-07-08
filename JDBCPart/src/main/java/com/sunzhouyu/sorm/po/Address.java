package com.sunzhouyu.sorm.po;

import java.sql.*;
import java.util.*;

public class Address {

	private String UserName;
	private String Phone;
	private Integer Id;
	private Integer userId;
	private String AddressInfo;


	public String getUserName(){
		return UserName;
	}
	public String getPhone(){
		return Phone;
	}
	public Integer getId(){
		return Id;
	}
	public Integer getUserId(){
		return userId;
	}
	public String getAddressInfo(){
		return AddressInfo;
	}
	public void setUserName(String UserName){
		this.UserName=UserName;
	}
	public void setPhone(String Phone){
		this.Phone=Phone;
	}
	public void setId(Integer Id){
		this.Id=Id;
	}
	public void setUserId(Integer userId){
		this.userId=userId;
	}
	public void setAddressInfo(String AddressInfo){
		this.AddressInfo=AddressInfo;
	}
}
