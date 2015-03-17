// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   RepairAction.java

package action;

import base.BaseAction;
import service.RepairServiceI;

public class RepairAction extends BaseAction
{

	private RepairServiceI repairService;

	public RepairAction()
	{
	}

	public void init()
	{
		repairService.save();
	}
}
