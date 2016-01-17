package com.hybrid.orm;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("beans_mvc.xml");
		
		ctx.close();
	}

}
