package com.sunzhouyu.sorm.po;

import java.sql.*;
import java.util.*;

public class AccountInfo {

	private Integer TradeMoney;
	private java.sql.Timestamp TradeTime;
	private Integer UserId;
	private String Content;
	private String Title;
	private Integer Id;


	public Integer getTradeMoney(){
		return TradeMoney;
	}
	public java.sql.Timestamp getTradeTime(){
		return TradeTime;
	}
	public Integer getUserId(){
		return UserId;
	}
	public String getContent(){
		return Content;
	}
	public String getTitle(){
		return Title;
	}
	public Integer getId(){
		return Id;
	}
	public void setTradeMoney(Integer TradeMoney){
		this.TradeMoney=TradeMoney;
	}
	public void setTradeTime(java.sql.Timestamp TradeTime){
		this.TradeTime=TradeTime;
	}
	public void setUserId(Integer UserId){
		this.UserId=UserId;
	}
	public void setContent(String Content){
		this.Content=Content;
	}
	public void setTitle(String Title){
		this.Title=Title;
	}
	public void setId(Integer Id){
		this.Id=Id;
	}
}
