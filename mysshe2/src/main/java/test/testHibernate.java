// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   testHibernate.java

package test;

import java.util.Date;
import java.util.UUID;
import model.TUser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IUserService;

public class testHibernate
{

	public testHibernate()
	{
	}

	public void test()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] {
			"classpath:spring.xml", "classpath:spring-hibernate.xml"
		});
		IUserService service = (IUserService)ac.getBean("userService");
		TUser user = new TUser();
		user.setId(UUID.randomUUID().toString());
		user.setName("¿Óœ˛≈Ù");
		user.setPassword("123456");
		user.setCreatedate(new Date());
	}

	public void test1()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] {
			"classpath:spring.xml", "classpath:spring-hibernate.xml"
		});
		IUserService service = (IUserService)ac.getBean("userService");
	}
}
