// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   RepairListener.java

package listener;

import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import service.RepairServiceI;

public class RepairListener
	implements ServletContextListener, ServletContextAttributeListener, HttpSessionListener, HttpSessionActivationListener, HttpSessionBindingListener
{

	private static final Logger logger = Logger.getLogger(RepairListener.class);
	private static ApplicationContext ac = null;

	public RepairListener()
	{
	}

	public void sessionCreated(HttpSessionEvent httpsessionevent)
	{
	}

	public void sessionDestroyed(HttpSessionEvent httpsessionevent)
	{
	}

	public void attributeAdded(ServletContextAttributeEvent servletcontextattributeevent)
	{
	}

	public void attributeRemoved(ServletContextAttributeEvent servletcontextattributeevent)
	{
	}

	public void attributeReplaced(ServletContextAttributeEvent servletcontextattributeevent)
	{
	}

	public void contextDestroyed(ServletContextEvent servletcontextevent)
	{
	}

	public void contextInitialized(ServletContextEvent evt)
	{
		logger.info("初始化数据开始");
		ac = WebApplicationContextUtils.getWebApplicationContext(evt.getServletContext());
		RepairServiceI service = (RepairServiceI)ac.getBean("repairService");
		service.save();
	}

	public void valueBound(HttpSessionBindingEvent httpsessionbindingevent)
	{
	}

	public void valueUnbound(HttpSessionBindingEvent httpsessionbindingevent)
	{
	}

	public void sessionDidActivate(HttpSessionEvent httpsessionevent)
	{
	}

	public void sessionWillPassivate(HttpSessionEvent httpsessionevent)
	{
	}

}
