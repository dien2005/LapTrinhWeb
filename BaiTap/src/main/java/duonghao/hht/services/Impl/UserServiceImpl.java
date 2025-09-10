package duonghao.hht.services.Impl;

import duonghao.hht.entity.User;
import duonghao.hht.models.UserModel;
import duonghao.hht.services.IUserDAO;
import duonghao.hht.services.IUserService;

public class UserServiceImpl implements IUserService{
	private IUserDAO userDAO = new UserDAOImpl();
	@Override
	public UserModel login(String Username, String Password) {
		// TODO Auto-generated method stub
		User user = userDAO.findByUserNameAndPassword(Username, Password);
		if(user != null)
		{
			return new UserModel(user.getID(), user.getUsername(), user.getPassword(), user.isSeller(), user.isAdmin(), user.getImg());
		}
		return null;
	}

}
