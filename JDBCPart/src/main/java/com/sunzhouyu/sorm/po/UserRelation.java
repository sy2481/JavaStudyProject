package com.sunzhouyu.sorm.po;

import java.sql.*;
import java.util.*;

public class UserRelation {

	private Integer id;
	private Integer carrierId;
	private Integer userId;


	public Integer getId(){
		return id;
	}
	public Integer getCarrierId(){
		return carrierId;
	}
	public Integer getUserId(){
		return userId;
	}
	public void setId(Integer id){
		this.id=id;
	}
	public void setCarrierId(Integer carrierId){
		this.carrierId=carrierId;
	}
	public void setUserId(Integer userId){
		this.userId=userId;
	}
}
