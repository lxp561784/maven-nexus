// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   UserServiceImpl.java

package service;

import action.Datagrid;
import dao.IUserDao;
import java.util.*;
import model.TUser;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import pageModel.User;
import util.MD5Util;

// Referenced classes of package service:
//			IUserService

public class UserServiceImpl
	implements IUserService
{

	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	private IUserDao userDao;

	public UserServiceImpl()
	{
	}

	public void setUserDao(IUserDao userDao)
	{
		this.userDao = userDao;
	}

	public void saveUser(User user)
	{
		TUser t = new TUser();
		BeanUtils.copyProperties(user, t, new String[] {
			"pwd"
		});
		t.setPassword(MD5Util.md5(user.getPwd()));
		t.setId(UUID.randomUUID().toString());
		t.setCreatedate(new Date());
		userDao.save(t);
	}

	public User login(User user)
	{
		TUser t = (TUser)userDao.get("from TUser where name = ? and password = ?", new Object[] {
			user.getName(), MD5Util.md5(user.getPwd())
		});
		if (t != null)
			return user;
		else
			return null;
	}

	public Datagrid datagrid(User user)
	{
		Datagrid d = new Datagrid();
		String hql = "from TUser t";
		if (!StringUtils.isEmpty(user.getName()))
			hql = (new StringBuilder(String.valueOf(hql))).append(" where t.name like '%").append(user.getName()).append("%'").toString();
		String totalHql = (new StringBuilder("select count(*) ")).append(hql).toString();
		if (StringUtils.isNotBlank(user.getSort()))
			hql = (new StringBuilder(String.valueOf(hql))).append(" order by ").append(user.getSort()).toString();
		List l = userDao.find(hql, user.getPage(), user.getRows());
		List nl = new ArrayList();
		if (l != null && l.size() > 0)
		{
			User u;
			for (Iterator iterator = l.iterator(); iterator.hasNext(); nl.add(u))
			{
				TUser tuser = (TUser)iterator.next();
				u = new User();
				BeanUtils.copyProperties(tuser, u);
				u.setPwd(tuser.getPassword());
			}

		}
		d.setTotal(userDao.count(totalHql));
		d.setRows(nl);
		return d;
	}

}
