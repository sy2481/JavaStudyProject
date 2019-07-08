package com.sunzhouyu.sorm.po;

import java.sql.*;
import java.util.*;

public class Message {

	private String MessageContent;
	private String MessageTitle;
	private Integer Id;
	private java.sql.Timestamp MessageTime;
	private String OrderId;
	private Integer ReceiveId;


	public String getMessageContent(){
		return MessageContent;
	}
	public String getMessageTitle(){
		return MessageTitle;
	}
	public Integer getId(){
		return Id;
	}
	public java.sql.Timestamp getMessageTime(){
		return MessageTime;
	}
	public String getOrderId(){
		return OrderId;
	}
	public Integer getReceiveId(){
		return ReceiveId;
	}
	public void setMessageContent(String MessageContent){
		this.MessageContent=MessageContent;
	}
	public void setMessageTitle(String MessageTitle){
		this.MessageTitle=MessageTitle;
	}
	public void setId(Integer Id){
		this.Id=Id;
	}
	public void setMessageTime(java.sql.Timestamp MessageTime){
		this.MessageTime=MessageTime;
	}
	public void setOrderId(String OrderId){
		this.OrderId=OrderId;
	}
	public void setReceiveId(Integer ReceiveId){
		this.ReceiveId=ReceiveId;
	}
}
