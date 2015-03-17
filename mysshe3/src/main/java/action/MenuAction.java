// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MenuAction.java

package action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import pageModel.Menu;
import service.MenuServiceI;
import base.BaseAction;

import com.opensymphony.xwork2.ModelDriven;

@Namespace("/")
public class MenuAction extends BaseAction
	implements ModelDriven
{

	Menu menu;
	@Autowired
	private MenuServiceI menuService;

	public MenuAction()
	{
		menu = new Menu();
	}

	public Menu getModel()
	{
		return menu;
	}
	
	@Action(value="menuAction")
	public void tree()
	{
		writeJson(menuService.getTree(menu.getId()));
	}
}
