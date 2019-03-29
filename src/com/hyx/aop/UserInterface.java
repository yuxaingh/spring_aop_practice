package com.hyx.aop;

public interface UserInterface {

	public abstract void getConn();
	public abstract void executeInsert(String sql);
	public abstract void closeConn();
	
}
