package dao;

import org.springframework.stereotype.Repository;

import model.TUser;

@SuppressWarnings({ "hiding", "rawtypes" })
@Repository
public class TUserDaoImpl<TUser,Integer> extends BaseDaoImpl implements IUserDao<TUser,Integer> {

	
	
//	@Override
//	public List<TUser> getUser() {
//		String hql = "from TUser";
//		return this.getHibernateTemplate().find(hql);
//	}

}
