// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   IUserService.java

package service;

import action.Datagrid;
import pageModel.User;

public interface IUserService
{

	public abstract void saveUser(User user);

	public abstract User login(User user);

	public abstract Datagrid datagrid(User user);
}
