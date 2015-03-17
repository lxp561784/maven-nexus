// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BaseDaoImpl.java

package dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

// Referenced classes of package dao:
//			BaseDao

@Repository("baseDao")
public class BaseDaoImpl extends HibernateDaoSupport
	implements BaseDao
{

	@Resource
	public void setMySessionFactory(SessionFactory sessionFactory)
	{
		super.setSessionFactory(sessionFactory);
	}
	

	
	
	public BaseDaoImpl()
	{
	}

	
	

	public void save(Object t)
	{
		getHibernateTemplate().save(t);
	}

	public void delete()
	{
	}

	public Object get(String hql)
	{
		List list = getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0)
			return list.get(0);
		else
			return null;
	}

	public Object get(String hql, Object params[])
	{
		List l = getHibernateTemplate().find(hql, params);
		if (l != null && l.size() > 0)
			return l.get(0);
		else
			return null;
	}

	public void delete(Object t)
	{
		getHibernateTemplate().delete(t);
	}

	public void update(Object t)
	{
		getHibernateTemplate().update(t);
	}

	public void saveOrUpdate(Object t)
	{
		getHibernateTemplate().saveOrUpdate(t);
	}

	public List find(String hql)
	{
		return getHibernateTemplate().find(hql);
	}

	public List find(String hql, Object params[])
	{
		return getHibernateTemplate().find(hql, params);
	}

	public List find(String hql, int pageNum, int pageSize)
	{
		Query q = getSession().createQuery(hql);
		q.setMaxResults(pageSize);
		q.setFirstResult((pageNum - 1) * pageSize);
		return q.list();
	}

	public List find(String hql, Object params[], int pageNum, int pageSize)
	{
		Query q = getSession().createQuery(hql);
		if (params != null && params.length > 0)
		{
			for (int i = 0; i < params.length; i++)
				q.setParameter(i, params[i]);

		}
		q.setMaxResults(pageSize);
		q.setFirstResult((pageNum - 1) * pageSize);
		return q.list();
	}

	public Long count(String hql)
	{
		Query q = getSession().createQuery(hql);
		return (Long)q.uniqueResult();
	}

	public Long count(String hql, Object params[])
	{
		Query q = getSession().createQuery(hql);
		if (params != null && params.length > 0)
		{
			for (int i = 0; i < params.length; i++)
				q.setParameter(i, params[i]);

		}
		return (Long)q.uniqueResult();
	}
}
