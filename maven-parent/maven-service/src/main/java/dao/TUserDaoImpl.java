package dao;

import java.util.List;

import javax.annotation.Resource;
import javax.annotation.Resources;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import model.TUser;

@Repository
public class TUserDaoImpl extends HibernateDaoSupport implements IUserDao {

	@Resource
	public void setMySessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	
	
	@Override
	public List<TUser> getUser() {
		String hql = "from TUser";
		return this.getHibernateTemplate().find(hql);
	}

}
