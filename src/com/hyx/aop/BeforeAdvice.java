package com.hyx.aop;

import java.lang.reflect.Method;

import org.jboss.logging.Logger;
import org.springframework.aop.MethodBeforeAdvice;

public class BeforeAdvice implements MethodBeforeAdvice {
	
	private static Logger logger = Logger.getLogger(BeforeAdvice.class.getName());

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		logger.info("Before advice start!!");
			if(arg2 instanceof UserInterface) {
				UserInterface di = (UserInterface) arg2;
				di.getConn();
				System.out.println("Get here.");
			}
		ConnClass ci = (ConnClass) arg2;
		ExecuteInsert bi = (ExecuteInsert) arg2;
		System.out.println(ci.getStmt());
		bi.setStatement(ci.getStmt());
	}

}
