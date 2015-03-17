// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MD5Util.java

package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util
{

	public MD5Util()
	{
	}

	public static void main(String args[])
	{
		String s = "ÀÔ”Ó";
		System.out.println(md5(s));
	}

	public static String md5(String str)
	{
		try{
			StringBuffer buf;
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte byteDigest[] = md.digest();
			buf = new StringBuffer("");
			for (int offset = 0; offset < byteDigest.length; offset++)
			{
				int i = byteDigest[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}

			return buf.toString();
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
			return null;
		}
		
		
		
		
	}
}
