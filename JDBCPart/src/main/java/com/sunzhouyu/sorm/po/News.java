package com.sunzhouyu.sorm.po;

import java.sql.*;
import java.util.*;

public class News {

	private String Sender;
	private String NewContent;
	private String NewTitle;
	private Integer id;


	public String getSender(){
		return Sender;
	}
	public String getNewContent(){
		return NewContent;
	}
	public String getNewTitle(){
		return NewTitle;
	}
	public Integer getId(){
		return id;
	}
	public void setSender(String Sender){
		this.Sender=Sender;
	}
	public void setNewContent(String NewContent){
		this.NewContent=NewContent;
	}
	public void setNewTitle(String NewTitle){
		this.NewTitle=NewTitle;
	}
	public void setId(Integer id){
		this.id=id;
	}
}
