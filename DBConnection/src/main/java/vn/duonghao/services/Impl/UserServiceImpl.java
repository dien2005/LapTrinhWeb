package vn.duonghao.services.Impl;

import vn.duonghao.models.UserModel;
import vn.duonghao.services.UserDAO;
import vn.duonghao.services.UserService;

public class UserServiceImpl implements UserService {

	UserDAO userDAO = new UserDAOImpl();
	@Override
	public UserModel login(String username, String password) {
		// TODO Auto-generated method stub
		UserModel user = this.get(username);
		if(user != null && password.equals(user.getPassWord()))
		{
			return user;
		}
		return null;
	}

	@Override
	public UserModel get(String username) {
		// TODO Auto-generated method stub
		return userDAO.get(username);
	}
	
}
