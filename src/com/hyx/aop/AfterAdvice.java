package com.hyx.aop;

import java.lang.reflect.Method;

import org.jboss.logging.Logger;
import org.springframework.aop.AfterReturningAdvice;

public class AfterAdvice implements AfterReturningAdvice {

	
	private static Logger logger = Logger.getLogger(AfterAdvice.class.getName());
	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {		
		logger.info("After advice start.");
		//if(arg1.getName().equals("executeInsert")) {
			if(arg3 instanceof UserInterface) {
				UserInterface di = (UserInterface) arg3;
				di.closeConn();
			}
		//}
	}
	
}
