package dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import util.GenericsUtils;

@Repository
public class BaseDaoImpl<T,PK> extends HibernateDaoSupport implements BaseDao<T, PK> {

	private Class<T> clazz;
	
	public void setClazz(Class<T> type){
		this.clazz = type;
	}
	public Class<T> getClazz(){
		return clazz;
	}
	
	@Resource
	public void setMySessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	
	public BaseDaoImpl(){
		this.clazz = (Class<T>)GenericsUtils.getSupperClassGenericType(getClass(), 0);
	}

	@Override
	public List<T> getAll() {
		
		return this.getHibernateTemplate().loadAll(clazz);
	}
	
	
}
