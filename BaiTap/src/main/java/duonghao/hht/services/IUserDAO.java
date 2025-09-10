package duonghao.hht.services;

import duonghao.hht.entity.User;

public interface IUserDAO {
	User findByUserNameAndPassword(String Username, String Password);
}
