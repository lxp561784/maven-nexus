// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BaseAction.java

package base;

import com.alibaba.fastjson.JSON;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

public class BaseAction
{

	public BaseAction()
	{
	}

	public void writeJson(Object obj)
	{
		try
		{
			ServletActionContext.getResponse().setContentType("text/html,charset-utf-8");
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().getWriter().write(JSON.toJSONString(obj));
			ServletActionContext.getResponse().getWriter().flush();
			ServletActionContext.getResponse().getWriter().close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
