// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Test.java

package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IUserService;

public class Test
{

	public Test()
	{
	}

	public void test1()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] {
			"classpath:spring.xml"
		});
		IUserService service = (IUserService)ac.getBean("userService");
	}
}
