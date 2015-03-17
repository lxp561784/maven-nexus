// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MenuAction.java

package action;

import pageModel.Menu;
import service.MenuServiceI;
import base.BaseAction;

import com.opensymphony.xwork2.ModelDriven;

public class MenuAction extends BaseAction
	implements ModelDriven
{

	Menu menu;
	private MenuServiceI menuService;

	public MenuAction()
	{
		menu = new Menu();
	}

	public Menu getModel()
	{
		return menu;
	}

	public void tree()
	{
		writeJson(menuService.getTree(menu.getId()));
	}
}
