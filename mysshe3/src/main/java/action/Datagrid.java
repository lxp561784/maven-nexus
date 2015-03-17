// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Datagrid.java

package action;

import java.util.ArrayList;
import java.util.List;

public class Datagrid
{

	private Long total;
	private List rows;

	public Datagrid()
	{
		total = Long.valueOf(0L);
		rows = new ArrayList();
	}

	public Long getTotal()
	{
		return total;
	}

	public void setTotal(Long total)
	{
		this.total = total;
	}

	public List getRows()
	{
		return rows;
	}

	public void setRows(List rows)
	{
		this.rows = rows;
	}
}
