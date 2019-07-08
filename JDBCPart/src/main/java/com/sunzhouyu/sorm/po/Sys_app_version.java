package com.sunzhouyu.sorm.po;

import java.sql.*;
import java.util.*;

public class Sys_app_version {

	private String AppVersion;
	private String Comment;
	private String Platform;
	private String AppVersionName;
	private String UpdateTime;
	private Integer Enable;
	private Integer IsForceUpdate;
	private String ID;
	private String Url;
	private String Name;


	public String getAppVersion(){
		return AppVersion;
	}
	public String getComment(){
		return Comment;
	}
	public String getPlatform(){
		return Platform;
	}
	public String getAppVersionName(){
		return AppVersionName;
	}
	public String getUpdateTime(){
		return UpdateTime;
	}
	public Integer getEnable(){
		return Enable;
	}
	public Integer getIsForceUpdate(){
		return IsForceUpdate;
	}
	public String getID(){
		return ID;
	}
	public String getUrl(){
		return Url;
	}
	public String getName(){
		return Name;
	}
	public void setAppVersion(String AppVersion){
		this.AppVersion=AppVersion;
	}
	public void setComment(String Comment){
		this.Comment=Comment;
	}
	public void setPlatform(String Platform){
		this.Platform=Platform;
	}
	public void setAppVersionName(String AppVersionName){
		this.AppVersionName=AppVersionName;
	}
	public void setUpdateTime(String UpdateTime){
		this.UpdateTime=UpdateTime;
	}
	public void setEnable(Integer Enable){
		this.Enable=Enable;
	}
	public void setIsForceUpdate(Integer IsForceUpdate){
		this.IsForceUpdate=IsForceUpdate;
	}
	public void setID(String ID){
		this.ID=ID;
	}
	public void setUrl(String Url){
		this.Url=Url;
	}
	public void setName(String Name){
		this.Name=Name;
	}
}
