package com.hyx.aop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.jboss.logging.Logger;
import org.springframework.aop.AfterAdvice;

public abstract class ConnClass implements UserInterface {
	
	private static Logger logger = Logger.getLogger(BeforeAdvice.class.getName());
	private Connection Con = null;
	private Statement Stmt = null;

	public Connection getConnection() {
		return Con; 
	}
	
	public void setConn(Connection Con) {
		this.Con = Con;
	}
	
	public Statement getStmt() {
		return Stmt;
	}
	
	public void setStmt(Statement Stmt) {
		this.Stmt = Stmt;
	}
	
	@Override
	public void getConn() {
		String url = "jdbc:mysql://localhost:3306/test";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Con = DriverManager.getConnection(url, "root", "1111");
			logger.info("Connection has been created.");
			Stmt = Con.createStatement();
			System.out.println(Stmt);
			logger.info("Statement has been created.");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		if(Con != null) {
			if(Stmt != null) {
				try {
					Con.close();
					logger.info("Connection has been closed.");
					Stmt.close();
					logger.info("Statement has been closed.");
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
