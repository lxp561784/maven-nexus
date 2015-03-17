// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BaseDao.java

package dao;

import java.util.List;

public interface BaseDao
{

	public abstract void save(Object obj);

	public abstract void delete();

	public abstract Object get(String s);

	public abstract Object get(String s, Object aobj[]);

	public abstract void delete(Object obj);

	public abstract void update(Object obj);

	public abstract void saveOrUpdate(Object obj);

	public abstract List find(String s);

	public abstract List find(String s, Object aobj[]);

	public abstract List find(String s, Object aobj[], int i, int j);

	public abstract List find(String s, int i, int j);

	public abstract Long count(String s);

	public abstract Long count(String s, Object aobj[]);
}
