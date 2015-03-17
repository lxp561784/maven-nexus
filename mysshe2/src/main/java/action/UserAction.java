// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   UserAction.java

package action;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;

import pageModel.Json;
import pageModel.User;
import service.IUserService;
import base.BaseAction;

import com.opensymphony.xwork2.ModelDriven;


@Action
public class UserAction extends BaseAction
	implements ModelDriven
{

	private static final Logger logger = Logger.getLogger(UserAction.class);
	private IUserService userService;
	private User user;

	public UserAction()
	{
		user = new User();
	}

	public void setUserService(IUserService userService)
	{
		this.userService = userService;
	}

	public void reg()
	{
		Json j = new Json();
		try
		{
			userService.saveUser(user);
			j.setMsg("×¢²á³É¹¦  £¡");
			j.setSuccess(true);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			j.setMsg(e.getMessage());
		}
		writeJson(j);
	}

	public void login()
	{
		User u = userService.login(user);
		Json j = new Json();
		if (u != null)
		{
			j.setSuccess(true);
			j.setMsg("µÇÂ½³É¹¦ £¡");
		} else
		{
			j.setMsg("µÇÂ½Ê§°Ü ");
		}
		writeJson(j);
	}

	public User getModel()
	{
		return user;
	}

	public void datagrid()
	{
		writeJson(userService.datagrid(user));
	}

	

}
