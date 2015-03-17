// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   RepairServiceImpl.java

package service;

import java.util.Date;
import java.util.UUID;

import model.TMenu;
import model.TUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import util.MD5Util;
import dao.IUserDao;
import dao.MenuDaoI;

// Referenced classes of package service:
//			RepairServiceI

@Service("repairService")
public class RepairServiceImpl
	implements RepairServiceI
{

	@Autowired
	private MenuDaoI menuDao;
	@Autowired
	private IUserDao userDao;

	public RepairServiceImpl()
	{
	}

	public void save()
	{
		repairUser();
		repairMenu();
	}

	private void repairMenu()
	{
		TMenu menu = new TMenu();
		menu.setId("0");
		menu.setText("管理菜单");
		menu.setUrl("");
		menu.setIconClx("");
		menuDao.saveOrUpdate(menu);
		TMenu xtgl = new TMenu();
		xtgl.setId("xtgl");
		xtgl.setTMenu(menu);
		xtgl.setText("系统管理");
		xtgl.setUrl("");
		menuDao.saveOrUpdate(xtgl);
		TMenu yhgl = new TMenu();
		yhgl.setId("yhgl");
		yhgl.setTMenu(xtgl);
		yhgl.setUrl("/admin/yhgl.jsp");
		yhgl.setText("用户管理");
		menuDao.saveOrUpdate(yhgl);
		TMenu jsgl = new TMenu();
		jsgl.setId("jsgl");
		jsgl.setTMenu(xtgl);
		jsgl.setUrl("");
		jsgl.setText("较色管理");
		menuDao.saveOrUpdate(jsgl);
		TMenu qxgl = new TMenu();
		qxgl.setId("qxgl");
		qxgl.setTMenu(xtgl);
		qxgl.setUrl("");
		qxgl.setText("权限管理");
		menuDao.saveOrUpdate(qxgl);
		TMenu cdgl = new TMenu();
		cdgl.setId("cdgl");
		cdgl.setTMenu(xtgl);
		cdgl.setUrl("");
		cdgl.setText("菜单管理");
		menuDao.saveOrUpdate(cdgl);
		TMenu buggl = new TMenu();
		buggl.setId("buggl");
		buggl.setTMenu(xtgl);
		buggl.setUrl("");
		buggl.setText("bug管理");
		menuDao.saveOrUpdate(buggl);
	}

	private void repairUser()
	{
		TUser t = (TUser)userDao.get("from TUser t where t.name=? and id != '0'", new Object[] {
			"admin"
		});
		if (t != null)
			t.setName(UUID.randomUUID().toString());
		TUser admin = new TUser();
		admin.setId("0");
		admin.setName("admin");
		admin.setPassword(MD5Util.md5("admin"));
		admin.setModifydate(new Date());
		userDao.saveOrUpdate(admin);
	}
}
