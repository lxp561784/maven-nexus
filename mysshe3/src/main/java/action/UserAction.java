// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   UserAction.java

package action;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import pageModel.Json;
import pageModel.User;
import service.IUserService;
import base.BaseAction;

import com.opensymphony.xwork2.ModelDriven;

import dao.UserDaoTest;


@Namespace("/")

public class UserAction extends BaseAction
	implements ModelDriven
{

	private static final Logger logger = Logger.getLogger(UserAction.class);
	@Autowired
	private IUserService userService;
	private User user;
	
	@Autowired
	private UserDaoTest userDaoTest;

	public UserAction()
	{
		user = new User();
	}

	public void setUserService(IUserService userService)
	{
		this.userService = userService;
	}
	@Action(value="userAction")
	public void reg()
	{
		Json j = new Json();
		try
		{
			userService.saveUser(user);
			j.setMsg("操作成功！");
			j.setSuccess(true);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			j.setMsg(e.getMessage());
		}
		writeJson(j);
	}
	@Action(value="userAction")
	public void login()
	{
		System.out.print("fff");
		User users = userDaoTest.get(User.class,0);
		User u = userService.login(user);
		Json j = new Json();
		if (u != null)
		{
			j.setSuccess(true);
			j.setMsg("登陆成功1！");
		} else
		{
			j.setMsg("登陆失败");
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
