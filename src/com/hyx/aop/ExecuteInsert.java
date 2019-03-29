package com.hyx.aop;

import java.sql.Statement;

import org.jboss.logging.Logger;
import org.springframework.aop.AfterAdvice;


public class ExecuteInsert extends ConnClass {
	
	private Logger logger = Logger.getLogger(AfterAdvice.class.getName());
	private Statement stmt = null;
	
	public Statement getStatement() {
		return stmt;
	}
	
	public void setStatement(Statement stmt) {
		this.stmt = stmt;
	}

	public void executeInsert(String sql) {
		try {
			stmt.execute(sql);
			logger.info("Successfully register!");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void closeConn() {
		super.close();
		if(stmt != null) {
			try {
				stmt.close();
				logger.info("Database closed!!");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
