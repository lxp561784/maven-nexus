// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Menu.java

package pageModel;

import java.util.Map;

public class Menu
{

	private String state;
	private String pid;
	private String ptext;
	private String id;
	private String text;
	private String iconClx;
	private Map attributes;

	public Menu()
	{
	}

	public Map getAttributes()
	{
		return attributes;
	}

	public void setAttributes(Map attributes)
	{
		this.attributes = attributes;
	}

	public String getPid()
	{
		return pid;
	}

	public void setPid(String pid)
	{
		this.pid = pid;
	}

	public String getPtext()
	{
		return ptext;
	}

	public void setPtext(String ptext)
	{
		this.ptext = ptext;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public String getIconClx()
	{
		return iconClx;
	}

	public void setIconClx(String iconClx)
	{
		this.iconClx = iconClx;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}
}
