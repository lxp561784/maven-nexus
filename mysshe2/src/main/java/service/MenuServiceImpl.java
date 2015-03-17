// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MenuServiceImpl.java

package service;

import dao.MenuDaoI;
import java.util.*;
import model.TMenu;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import pageModel.Menu;

// Referenced classes of package service:
//			MenuServiceI

public class MenuServiceImpl
	implements MenuServiceI
{

	private MenuDaoI menuDao;

	public MenuServiceImpl()
	{
	}

	public List getTree(String id)
	{
		List list = null;
		if (StringUtils.isEmpty(id))
			list = menuDao.find("from TMenu t where t.TMenu.id is null");
		else
			list = menuDao.find("from TMenu t where t.TMenu.id = ? ", new Object[] {
				id
			});
		List l = new ArrayList();
		if (list != null && list.size() > 0)
		{
			Menu m;
			for (Iterator iterator = list.iterator(); iterator.hasNext(); l.add(m))
			{
				TMenu menu = (TMenu)iterator.next();
				m = new Menu();
				BeanUtils.copyProperties(menu, m);
				Map attributes = new HashMap();
				attributes.put("url", menu.getUrl());
				m.setAttributes(attributes);
				if (menu.getTMenus() != null && !menu.getTMenus().isEmpty())
					m.setState("closed");
				else
					m.setState("open");
			}

		}
		return l;
	}
}
