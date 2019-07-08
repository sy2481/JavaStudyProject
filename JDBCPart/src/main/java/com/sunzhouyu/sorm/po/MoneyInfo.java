package com.sunzhouyu.sorm.po;

import java.sql.*;
import java.util.*;

public class MoneyInfo {

	private String Money;
	private String MoneyTime;
	private Integer CarrierId;
	private Integer DriverId;
	private Integer UserId;
	private Integer State;
	private Integer TranslateInfoId;
	private Integer Id;
	private String Reward;


	public String getMoney(){
		return Money;
	}
	public String getMoneyTime(){
		return MoneyTime;
	}
	public Integer getCarrierId(){
		return CarrierId;
	}
	public Integer getDriverId(){
		return DriverId;
	}
	public Integer getUserId(){
		return UserId;
	}
	public Integer getState(){
		return State;
	}
	public Integer getTranslateInfoId(){
		return TranslateInfoId;
	}
	public Integer getId(){
		return Id;
	}
	public String getReward(){
		return Reward;
	}
	public void setMoney(String Money){
		this.Money=Money;
	}
	public void setMoneyTime(String MoneyTime){
		this.MoneyTime=MoneyTime;
	}
	public void setCarrierId(Integer CarrierId){
		this.CarrierId=CarrierId;
	}
	public void setDriverId(Integer DriverId){
		this.DriverId=DriverId;
	}
	public void setUserId(Integer UserId){
		this.UserId=UserId;
	}
	public void setState(Integer State){
		this.State=State;
	}
	public void setTranslateInfoId(Integer TranslateInfoId){
		this.TranslateInfoId=TranslateInfoId;
	}
	public void setId(Integer Id){
		this.Id=Id;
	}
	public void setReward(String Reward){
		this.Reward=Reward;
	}
}
