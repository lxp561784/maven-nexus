// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   TestMenu.java

package test;

import java.util.UUID;
import model.TMenu;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.RepairServiceI;

public class TestMenu
{

	public TestMenu()
	{
	}

	public void test()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] {
			"classpath:spring.xml", "classpath:spring-hibernate.xml"
		});
		RepairServiceI repairService = (RepairServiceI)ac.getBean("repairService");
		TMenu menu = new TMenu();
		menu.setId(UUID.randomUUID().toString());
		repairService.save();
	}
}
