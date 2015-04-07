package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IUserDao;

import model.TUser;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao<TUser,Integer> tUserDaoImpl; 
	
	@Override
	public List<TUser> getUser() {
		return tUserDaoImpl.getAll();
	}

}
