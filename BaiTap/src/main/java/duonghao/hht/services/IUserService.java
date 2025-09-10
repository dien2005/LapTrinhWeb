package duonghao.hht.services;

import duonghao.hht.models.UserModel;

public interface IUserService {
	UserModel login(String Username, String Password);
}
