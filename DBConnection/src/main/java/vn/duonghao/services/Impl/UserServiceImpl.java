package vn.duonghao.services.Impl;

import java.util.List;

import vn.duonghao.models.UserModel;
import vn.duonghao.services.UserDAO;
import vn.duonghao.services.UserService;

public class UserServiceImpl implements UserService {

	UserDAO userDAO = new UserDAOImpl();
	@Override
	public UserModel login(String username, String password) {
		// TODO Auto-generated method stub
		UserModel user = this.get(username);
		if(user != null && password.trim().equals(user.getPassWord().trim()))
			return user;
		else
			return null;
	}

	@Override
	public UserModel get(String username) {
		// TODO Auto-generated method stub
		return userDAO.get(username);
	}
    @Override
    public void insert(UserModel user) {
        userDAO.insert(user);
    }

    @Override
    public boolean register(String email, String password, String username, String fullname, String phone) {
        return userDAO.register(email, password, username, fullname, phone);
    }

    @Override
    public boolean checkExistEmail(String email) {
        return userDAO.checkExistEmail(email);
    }

    @Override
    public boolean checkExistUsername(String username) {
        return userDAO.checkExistUsername(username);
    }

    @Override
    public boolean checkExistPhone(String phone) {
        return userDAO.checkExistPhone(phone);
    }
    @Override
    public boolean updatePasswordByEmail(String email, String newPassword) {
        return userDAO.updatePasswordByEmail(email, newPassword);
    }
	@Override
	public void update(UserModel user)
	{
		userDAO.update(user);
	}
	@Override
	public void delete(int id)
	{
		userDAO.delete(id);
	}
	@Override 
	public List<UserModel> getAll()
	{
		return userDAO.getAll();
		
	}
}
