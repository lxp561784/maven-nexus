// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   UserDaoImpl.java

package dao;

import org.springframework.stereotype.Repository;


// Referenced classes of package dao:
//			BaseDaoImpl, IUserDao

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl
	implements IUserDao
{

	public UserDaoImpl()
	{
	}
}
