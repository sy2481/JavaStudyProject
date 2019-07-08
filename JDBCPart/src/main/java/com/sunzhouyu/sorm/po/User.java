package com.sunzhouyu.sorm.po;

import java.sql.*;
import java.util.*;

public class User {

	private Integer Role;
	private String Username;
	private String HeadImage;
	private String UserPhone;
	private String PayPwd;
	private Integer UserMoney;
	private Integer Id;
	private String Password;


	public Integer getRole(){
		return Role;
	}
	public String getUsername(){
		return Username;
	}
	public String getHeadImage(){
		return HeadImage;
	}
	public String getUserPhone(){
		return UserPhone;
	}
	public String getPayPwd(){
		return PayPwd;
	}
	public Integer getUserMoney(){
		return UserMoney;
	}
	public Integer getId(){
		return Id;
	}
	public String getPassword(){
		return Password;
	}
	public void setRole(Integer Role){
		this.Role=Role;
	}
	public void setUsername(String Username){
		this.Username=Username;
	}
	public void setHeadImage(String HeadImage){
		this.HeadImage=HeadImage;
	}
	public void setUserPhone(String UserPhone){
		this.UserPhone=UserPhone;
	}
	public void setPayPwd(String PayPwd){
		this.PayPwd=PayPwd;
	}
	public void setUserMoney(Integer UserMoney){
		this.UserMoney=UserMoney;
	}
	public void setId(Integer Id){
		this.Id=Id;
	}
	public void setPassword(String Password){
		this.Password=Password;
	}
}
